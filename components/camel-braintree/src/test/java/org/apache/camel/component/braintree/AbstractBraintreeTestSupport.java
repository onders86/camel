/*
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
package org.apache.camel.component.braintree;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.braintreegateway.BraintreeGateway;
import org.apache.camel.CamelContext;
import org.apache.camel.CamelExecutionException;
import org.apache.camel.component.braintree.internal.BraintreeApiCollection;
import org.apache.camel.component.braintree.internal.BraintreeApiName;
import org.apache.camel.component.braintree.internal.BraintreeConstants;
import org.apache.camel.component.braintree.internal.BraintreeLogHandler;
import org.apache.camel.support.IntrospectionSupport;
import org.apache.camel.support.component.ApiMethod;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.apache.camel.util.ObjectHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract base class for Braintree Integration tests generated by Camel API component maven plugin.
 */
public class AbstractBraintreeTestSupport extends CamelTestSupport {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractBraintreeTestSupport.class);

    private static final String TEST_OPTIONS_PROPERTIES = "/test-options.properties";

    private AuthenticationType authenticationType;

    private BraintreeGateway gateway;

    protected AbstractBraintreeTestSupport() {
        this.gateway = null;
    }

    @Override
    protected CamelContext createCamelContext() throws Exception {

        final CamelContext context = super.createCamelContext();

        // add BraintreeComponent to Camel context
        final BraintreeComponent component = new BraintreeComponent(context);
        component.setConfiguration(buildBraintreeConfiguration());
        context.addComponent("braintree", component);

        return context;
    }

    protected void addOptionIfMissing(Map<String, Object> options, String name, String envName) {
        if (!options.containsKey(name)) {
            String value = System.getenv(envName);
            if (ObjectHelper.isNotEmpty(value)) {
                options.put(name, value);
            }
        }
    }

    protected BraintreeConfiguration buildBraintreeConfiguration() throws Exception {

        final Properties properties = new Properties();
        try {
            properties.load(getClass().getResourceAsStream(TEST_OPTIONS_PROPERTIES));
        } catch (Exception e) {
            throw new IOException(String.format("%s could not be loaded: %s", TEST_OPTIONS_PROPERTIES, e.getMessage()), e);
        }

        Map<String, Object> options = new HashMap<>();
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            options.put(entry.getKey().toString(), entry.getValue());
        }

        AuthenticationType configurationType = getAuthenticationType();
        LOG.info(String.format("Test using %s configuration profile", configurationType));
        switch (configurationType) {
        case PUBLIC_PRIVATE_KEYS:
            addOptionIfMissing(options, "environment", "CAMEL_BRAINTREE_ENVIRONMENT");
            addOptionIfMissing(options, "merchantId", "CAMEL_BRAINTREE_MERCHANT_ID");
            addOptionIfMissing(options, "publicKey", "CAMEL_BRAINTREE_PUBLIC_KEY");
            addOptionIfMissing(options, "privateKey", "CAMEL_BRAINTREE_PRIVATE_KEY");
            options.remove("accessToken");
            options.remove("clientId");
            break;
        case ACCESS_TOKEN:
            addOptionIfMissing(options, "accessToken", "CAMEL_BRAINTREE_ACCESS_TOKEN");
            options.remove("environment");
            options.remove("merchantId");
            options.remove("publicKey");
            options.remove("privateKey");
            break;
        default:
            throw new IllegalArgumentException("Unsupported configuration type");
        }

        final BraintreeConfiguration configuration = new BraintreeConfiguration();
        configuration.setHttpLogLevel(BraintreeLogHandler.DEFAULT_LOGGER_VERSION);
        configuration.setHttpLogName(BraintreeLogHandler.DEFAULT_LOGGER_NAME);
        IntrospectionSupport.setProperties(configuration, options);

        return configuration;
    }

    protected AuthenticationType getAuthenticationType() {
        if (authenticationType == null) {
            authenticationType = parseAuthenticationType();
        }
        return authenticationType;
    }

    protected boolean checkAuthenticationType(AuthenticationType authenticationType) {
        return getAuthenticationType().equals(authenticationType);
    }

    private AuthenticationType parseAuthenticationType() {
        String authenticationTypeString = System.getProperty("braintreeAuthenticationType");
        if (authenticationTypeString != null) {
            AuthenticationType authenticationType = AuthenticationType.valueOf(authenticationTypeString);
            if (authenticationType != null) {
                return authenticationType;
            }
        }
        return AuthenticationType.PUBLIC_PRIVATE_KEYS;
    }

    @Override
    public boolean isCreateCamelContextPerClass() {

        // only create the context once for this class
        return false;
    }

    @SuppressWarnings("unchecked")
    protected <T> T requestBodyAndHeaders(String endpointUri, Object body, Map<String, Object> headers) throws CamelExecutionException {
        return (T)template().requestBodyAndHeaders(endpointUri, body, headers);
    }

    protected <T> T requestBodyAndHeaders(String endpointUri, Object body, Map<String, Object> headers, Class<T> type) throws CamelExecutionException {
        return template().requestBodyAndHeaders(endpointUri, body, headers, type);
    }

    @SuppressWarnings("unchecked")
    protected <T> T requestBody(String endpoint, Object body) throws CamelExecutionException {
        return (T)template().requestBody(endpoint, body);
    }

    protected <T> T requestBody(String endpoint, Object body, Class<T> type) throws CamelExecutionException {
        return template().requestBody(endpoint, body, type);
    }

    protected static BraintreeApiName getApiName(Class<? extends ApiMethod> apiMethod) {
        return BraintreeApiCollection.getCollection().getApiName(apiMethod);
    }

    protected static String getApiNameAsString(Class<? extends ApiMethod> apiMethod) {
        return getApiName(apiMethod).getName();
    }

    protected final BraintreeComponent getBraintreeComponent() {
        return (BraintreeComponent)context().getComponent("braintree");
    }

    protected final synchronized BraintreeGateway getGateway() {
        if (gateway == null) {
            gateway = getBraintreeComponent().getConfiguration().newBraintreeGateway();
        }

        return gateway;
    }

    protected final class BraintreeHeaderBuilder {
        private final Map<String, Object> headers;

        public BraintreeHeaderBuilder() {
            headers = new HashMap<>();
        }

        public BraintreeHeaderBuilder add(String key, Object value) {
            if (key.startsWith(BraintreeConstants.PROPERTY_PREFIX)) {
                headers.put(key, value);
            } else {
                headers.put(BraintreeConstants.PROPERTY_PREFIX + key, value);
            }

            return this;
        }

        public Map<String, Object> build() {
            return Collections.unmodifiableMap(headers);
        }
    }
}
