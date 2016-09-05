/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.rest;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.camel.AsyncCallback;
import org.apache.camel.AsyncProcessor;
import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.Producer;
import org.apache.camel.impl.DefaultAsyncProducer;
import org.apache.camel.spi.DataFormat;
import org.apache.camel.spi.RestConfiguration;
import org.apache.camel.tools.apt.helper.CollectionStringBuffer;
import org.apache.camel.util.AsyncProcessorConverterHelper;
import org.apache.camel.util.EndpointHelper;
import org.apache.camel.util.FileUtil;
import org.apache.camel.util.ServiceHelper;
import org.apache.camel.util.URISupport;

/**
 * Rest producer for calling remote REST services.
 */
public class RestProducer extends DefaultAsyncProducer {

    private final CamelContext camelContext;
    private final RestConfiguration configuration;
    private String bindingMode;
    private Boolean skipBindingOnErrorCode;

    // the producer of the Camel component that is used as the HTTP client to call the REST service
    private AsyncProcessor producer;
    private AsyncProcessor binding;

    private boolean prepareUriTemplate = true;

    public RestProducer(Endpoint endpoint, Producer producer, RestConfiguration configuration) {
        super(endpoint);
        this.camelContext = endpoint.getCamelContext();
        this.configuration = configuration;
        this.producer = AsyncProcessorConverterHelper.convert(producer);
    }

    @Override
    public boolean process(Exchange exchange, AsyncCallback callback) {
        // TODO: request bind to consumes context-type
        // TODO: response bind to content-type returned in response
        // TODO: binding
        // TODO: binding get type/outType from api-doc if possible
        // TODO: binding reverse only enabled if outType configured
        // TODO move consumer binding processor to this pacakge so they are both the same place

        try {
            prepareExchange(exchange);
            if (binding != null) {
                return binding.process(exchange, callback);
            } else {
                // no binding in use call the producer directly
                return producer.process(exchange, callback);
            }
        } catch (Throwable e) {
            exchange.setException(e);
            callback.done(true);
            return true;
        }
    }

    @Override
    public RestEndpoint getEndpoint() {
        return (RestEndpoint) super.getEndpoint();
    }

    public boolean isPrepareUriTemplate() {
        return prepareUriTemplate;
    }

    /**
     * Whether to prepare the uri template and replace {key} with values from the exchange, and set
     * as {@link Exchange#HTTP_URI} header with the resolved uri to use instead of uri from endpoint.
     */
    public void setPrepareUriTemplate(boolean prepareUriTemplate) {
        this.prepareUriTemplate = prepareUriTemplate;
    }

    public String getBindingMode() {
        return bindingMode;
    }

    public void setBindingMode(String bindingMode) {
        this.bindingMode = bindingMode;
    }

    public Boolean getSkipBindingOnErrorCode() {
        return skipBindingOnErrorCode;
    }

    public void setSkipBindingOnErrorCode(Boolean skipBindingOnErrorCode) {
        this.skipBindingOnErrorCode = skipBindingOnErrorCode;
    }

    protected void prepareExchange(Exchange exchange) throws Exception {
        boolean hasPath = false;

        // uri template with path parameters resolved
        // uri template may be optional and the user have entered the uri template in the path instead
        String resolvedUriTemplate = getEndpoint().getUriTemplate() != null ? getEndpoint().getUriTemplate() : getEndpoint().getPath();

        if (prepareUriTemplate) {
            if (resolvedUriTemplate.contains("{")) {
                // resolve template and replace {key} with the values form the exchange
                // each {} is a parameter (url templating)
                String[] arr = resolvedUriTemplate.split("\\/");
                CollectionStringBuffer csb = new CollectionStringBuffer("/");
                for (String a : arr) {
                    if (a.startsWith("{") && a.endsWith("}")) {
                        String key = a.substring(1, a.length() - 1);
                        String value = exchange.getIn().getHeader(key, String.class);
                        if (value != null) {
                            hasPath = true;
                            csb.append(value);
                        } else {
                            csb.append(a);
                        }
                    } else {
                        csb.append(a);
                    }
                }
                resolvedUriTemplate = csb.toString();
            }
        }

        // resolve uri parameters
        String query = getEndpoint().getQueryParameters();
        if (query != null) {
            Map<String, Object> params = URISupport.parseQuery(query);
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                Object v = entry.getValue();
                if (v != null) {
                    String a = v.toString();
                    // decode the key as { may be decoded to %NN
                    a = URLDecoder.decode(a, "UTF-8");
                    if (a.startsWith("{") && a.endsWith("}")) {
                        String key = a.substring(1, a.length() - 1);
                        String value = exchange.getIn().getHeader(key, String.class);
                        if (value != null) {
                            params.put(key, value);
                        } else {
                            params.put(entry.getKey(), entry.getValue());
                        }
                    } else {
                        params.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            query = URISupport.createQueryString(params);
        }

        if (query != null) {
            // the query parameters for the rest call to be used
            exchange.getIn().setHeader(Exchange.REST_HTTP_QUERY, query);
        }

        if (hasPath) {
            String host = getEndpoint().getHost();
            String basePath = getEndpoint().getUriTemplate() != null ? getEndpoint().getPath() :  null;
            basePath = FileUtil.stripLeadingSeparator(basePath);
            resolvedUriTemplate = FileUtil.stripLeadingSeparator(resolvedUriTemplate);
            // if so us a header for the dynamic uri template so we reuse same endpoint but the header overrides the actual url to use
            String overrideUri;
            if (basePath != null) {
                overrideUri = String.format("%s/%s/%s", host, basePath, resolvedUriTemplate);
            } else {
                overrideUri = String.format("%s/%s", host, resolvedUriTemplate);
            }
            // the http uri for the rest call to be used
            exchange.getIn().setHeader(Exchange.REST_HTTP_URI, overrideUri);
        }
    }

    @Override
    protected void doStart() throws Exception {
        super.doStart();

        // create binding processor
        binding = createBindingProcessor();

        ServiceHelper.startServices(binding, producer);
    }

    @Override
    protected void doStop() throws Exception {
        super.doStop();
        ServiceHelper.stopServices(producer, binding);
    }

    protected AsyncProcessor createBindingProcessor() throws Exception {

        // these options can be overridden per endpoint
        String mode = configuration.getBindingMode().name();
        if (bindingMode != null) {
            mode = bindingMode;
        }
        boolean skip = configuration.isSkipBindingOnErrorCode();
        if (skipBindingOnErrorCode != null) {
            skip = skipBindingOnErrorCode;
        }

        if (mode == null || "off".equals(mode)) {
            // binding mode is off
            return null;
        }

        // setup json data format
        String name = configuration.getJsonDataFormat();
        if (name != null) {
            // must only be a name, not refer to an existing instance
            Object instance = camelContext.getRegistry().lookupByName(name);
            if (instance != null) {
                throw new IllegalArgumentException("JsonDataFormat name: " + name + " must not be an existing bean instance from the registry");
            }
        } else {
            name = "json-jackson";
        }
        // this will create a new instance as the name was not already pre-created
        DataFormat json = camelContext.resolveDataFormat(name);
        DataFormat outJson = camelContext.resolveDataFormat(name);

        // is json binding required?
        if (mode.contains("json") && json == null) {
            throw new IllegalArgumentException("JSon DataFormat " + name + " not found.");
        }

        if (json != null) {
            setAdditionalConfiguration(configuration, camelContext, json, "json.in.");
            setAdditionalConfiguration(configuration, camelContext, outJson, "json.out.");
        }

        // setup xml data format
        name = configuration.getXmlDataFormat();
        if (name != null) {
            // must only be a name, not refer to an existing instance
            Object instance = camelContext.getRegistry().lookupByName(name);
            if (instance != null) {
                throw new IllegalArgumentException("XmlDataFormat name: " + name + " must not be an existing bean instance from the registry");
            }
        } else {
            name = "jaxb";
        }
        // this will create a new instance as the name was not already pre-created
        DataFormat jaxb = camelContext.resolveDataFormat(name);
        DataFormat outJaxb = camelContext.resolveDataFormat(name);

        // is xml binding required?
        if (mode.contains("xml") && jaxb == null) {
            throw new IllegalArgumentException("XML DataFormat " + name + " not found.");
        }

        if (jaxb != null) {
            setAdditionalConfiguration(configuration, camelContext, jaxb, "xml.in.");
            setAdditionalConfiguration(configuration, camelContext, outJaxb, "xml.out.");
        }

        return new RestProducerBindingProcessor(producer, camelContext, json, jaxb, outJson, outJaxb, mode, skip);
    }

    private void setAdditionalConfiguration(RestConfiguration config, CamelContext context,
                                            DataFormat dataFormat, String prefix) throws Exception {
        if (config.getDataFormatProperties() != null && !config.getDataFormatProperties().isEmpty()) {
            // must use a copy as otherwise the options gets removed during introspection setProperties
            Map<String, Object> copy = new HashMap<String, Object>();

            // filter keys on prefix
            // - either its a known prefix and must match the prefix parameter
            // - or its a common configuration that we should always use
            for (Map.Entry<String, Object> entry : config.getDataFormatProperties().entrySet()) {
                String key = entry.getKey();
                String copyKey;
                boolean known = isKeyKnownPrefix(key);
                if (known) {
                    // remove the prefix from the key to use
                    copyKey = key.substring(prefix.length());
                } else {
                    // use the key as is
                    copyKey = key;
                }
                if (!known || key.startsWith(prefix)) {
                    copy.put(copyKey, entry.getValue());
                }
            }

            // set reference properties first as they use # syntax that fools the regular properties setter
            EndpointHelper.setReferenceProperties(context, dataFormat, copy);
            EndpointHelper.setProperties(context, dataFormat, copy);
        }
    }

    private boolean isKeyKnownPrefix(String key) {
        return key.startsWith("json.in.") || key.startsWith("json.out.") || key.startsWith("xml.in.") || key.startsWith("xml.out.");
    }

}
