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
package org.apache.camel.builder.endpoint.dsl;

import javax.annotation.Generated;
import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.EndpointConsumerBuilder;
import org.apache.camel.builder.EndpointProducerBuilder;
import org.apache.camel.builder.endpoint.AbstractEndpointBuilder;
import org.apache.camel.spi.ExceptionHandler;

/**
 * The cmis component uses the Apache Chemistry client API and allows you to
 * add/read nodes to/from a CMIS compliant content repositories.
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@Generated("org.apache.camel.maven.packaging.EndpointDslMojo")
public interface CMISEndpointBuilderFactory {


    /**
     * Builder for endpoint consumers for the CMIS component.
     */
    public interface CMISEndpointConsumerBuilder
            extends
                EndpointConsumerBuilder {
        default AdvancedCMISEndpointConsumerBuilder advanced() {
            return (AdvancedCMISEndpointConsumerBuilder) this;
        }
        /**
         * Number of nodes to retrieve per page.
         * 
         * The option is a: <code>int</code> type.
         * 
         * Default: 100
         * Group: common
         */
        default CMISEndpointConsumerBuilder pageSize(int pageSize) {
            doSetProperty("pageSize", pageSize);
            return this;
        }
        /**
         * Number of nodes to retrieve per page.
         * 
         * The option will be converted to a <code>int</code> type.
         * 
         * Group: common
         */
        default CMISEndpointConsumerBuilder pageSize(String pageSize) {
            doSetProperty("pageSize", pageSize);
            return this;
        }
        /**
         * If set to true, the content of document node will be retrieved in
         * addition to the properties.
         * 
         * The option is a: <code>boolean</code> type.
         * 
         * Default: false
         * Group: common
         */
        default CMISEndpointConsumerBuilder readContent(boolean readContent) {
            doSetProperty("readContent", readContent);
            return this;
        }
        /**
         * If set to true, the content of document node will be retrieved in
         * addition to the properties.
         * 
         * The option will be converted to a <code>boolean</code> type.
         * 
         * Group: common
         */
        default CMISEndpointConsumerBuilder readContent(String readContent) {
            doSetProperty("readContent", readContent);
            return this;
        }
        /**
         * Max number of nodes to read.
         * 
         * The option is a: <code>int</code> type.
         * 
         * Group: common
         */
        default CMISEndpointConsumerBuilder readCount(int readCount) {
            doSetProperty("readCount", readCount);
            return this;
        }
        /**
         * Max number of nodes to read.
         * 
         * The option will be converted to a <code>int</code> type.
         * 
         * Group: common
         */
        default CMISEndpointConsumerBuilder readCount(String readCount) {
            doSetProperty("readCount", readCount);
            return this;
        }
        /**
         * The Id of the repository to use. If not specified the first available
         * repository is used.
         * 
         * The option is a: <code>java.lang.String</code> type.
         * 
         * Group: common
         */
        default CMISEndpointConsumerBuilder repositoryId(String repositoryId) {
            doSetProperty("repositoryId", repositoryId);
            return this;
        }
        /**
         * Allows for bridging the consumer to the Camel routing Error Handler,
         * which mean any exceptions occurred while the consumer is trying to
         * pickup incoming messages, or the likes, will now be processed as a
         * message and handled by the routing Error Handler. By default the
         * consumer will use the org.apache.camel.spi.ExceptionHandler to deal
         * with exceptions, that will be logged at WARN or ERROR level and
         * ignored.
         * 
         * The option is a: <code>boolean</code> type.
         * 
         * Default: false
         * Group: consumer
         */
        default CMISEndpointConsumerBuilder bridgeErrorHandler(
                boolean bridgeErrorHandler) {
            doSetProperty("bridgeErrorHandler", bridgeErrorHandler);
            return this;
        }
        /**
         * Allows for bridging the consumer to the Camel routing Error Handler,
         * which mean any exceptions occurred while the consumer is trying to
         * pickup incoming messages, or the likes, will now be processed as a
         * message and handled by the routing Error Handler. By default the
         * consumer will use the org.apache.camel.spi.ExceptionHandler to deal
         * with exceptions, that will be logged at WARN or ERROR level and
         * ignored.
         * 
         * The option will be converted to a <code>boolean</code> type.
         * 
         * Group: consumer
         */
        default CMISEndpointConsumerBuilder bridgeErrorHandler(
                String bridgeErrorHandler) {
            doSetProperty("bridgeErrorHandler", bridgeErrorHandler);
            return this;
        }
        /**
         * The cmis query to execute against the repository. If not specified,
         * the consumer will retrieve every node from the content repository by
         * iterating the content tree recursively.
         * 
         * The option is a: <code>java.lang.String</code> type.
         * 
         * Group: consumer
         */
        default CMISEndpointConsumerBuilder query(String query) {
            doSetProperty("query", query);
            return this;
        }
        /**
         * Password for the cmis repository.
         * 
         * The option is a: <code>java.lang.String</code> type.
         * 
         * Group: security
         */
        default CMISEndpointConsumerBuilder password(String password) {
            doSetProperty("password", password);
            return this;
        }
        /**
         * Username for the cmis repository.
         * 
         * The option is a: <code>java.lang.String</code> type.
         * 
         * Group: security
         */
        default CMISEndpointConsumerBuilder username(String username) {
            doSetProperty("username", username);
            return this;
        }
    }

    /**
     * Advanced builder for endpoint consumers for the CMIS component.
     */
    public interface AdvancedCMISEndpointConsumerBuilder
            extends
                EndpointConsumerBuilder {
        default CMISEndpointConsumerBuilder basic() {
            return (CMISEndpointConsumerBuilder) this;
        }
        /**
         * To let the consumer use a custom ExceptionHandler. Notice if the
         * option bridgeErrorHandler is enabled then this option is not in use.
         * By default the consumer will deal with exceptions, that will be
         * logged at WARN or ERROR level and ignored.
         * 
         * The option is a: <code>org.apache.camel.spi.ExceptionHandler</code>
         * type.
         * 
         * Group: consumer (advanced)
         */
        default AdvancedCMISEndpointConsumerBuilder exceptionHandler(
                ExceptionHandler exceptionHandler) {
            doSetProperty("exceptionHandler", exceptionHandler);
            return this;
        }
        /**
         * To let the consumer use a custom ExceptionHandler. Notice if the
         * option bridgeErrorHandler is enabled then this option is not in use.
         * By default the consumer will deal with exceptions, that will be
         * logged at WARN or ERROR level and ignored.
         * 
         * The option will be converted to a
         * <code>org.apache.camel.spi.ExceptionHandler</code> type.
         * 
         * Group: consumer (advanced)
         */
        default AdvancedCMISEndpointConsumerBuilder exceptionHandler(
                String exceptionHandler) {
            doSetProperty("exceptionHandler", exceptionHandler);
            return this;
        }
        /**
         * Sets the exchange pattern when the consumer creates an exchange.
         * 
         * The option is a: <code>org.apache.camel.ExchangePattern</code> type.
         * 
         * Group: consumer (advanced)
         */
        default AdvancedCMISEndpointConsumerBuilder exchangePattern(
                ExchangePattern exchangePattern) {
            doSetProperty("exchangePattern", exchangePattern);
            return this;
        }
        /**
         * Sets the exchange pattern when the consumer creates an exchange.
         * 
         * The option will be converted to a
         * <code>org.apache.camel.ExchangePattern</code> type.
         * 
         * Group: consumer (advanced)
         */
        default AdvancedCMISEndpointConsumerBuilder exchangePattern(
                String exchangePattern) {
            doSetProperty("exchangePattern", exchangePattern);
            return this;
        }
        /**
         * Whether the endpoint should use basic property binding (Camel 2.x) or
         * the newer property binding with additional capabilities.
         * 
         * The option is a: <code>boolean</code> type.
         * 
         * Default: false
         * Group: advanced
         */
        default AdvancedCMISEndpointConsumerBuilder basicPropertyBinding(
                boolean basicPropertyBinding) {
            doSetProperty("basicPropertyBinding", basicPropertyBinding);
            return this;
        }
        /**
         * Whether the endpoint should use basic property binding (Camel 2.x) or
         * the newer property binding with additional capabilities.
         * 
         * The option will be converted to a <code>boolean</code> type.
         * 
         * Group: advanced
         */
        default AdvancedCMISEndpointConsumerBuilder basicPropertyBinding(
                String basicPropertyBinding) {
            doSetProperty("basicPropertyBinding", basicPropertyBinding);
            return this;
        }
        /**
         * To use a custom CMISSessionFacadeFactory to create the
         * CMISSessionFacade instances.
         * 
         * The option is a:
         * <code>org.apache.camel.component.cmis.CMISSessionFacadeFactory</code>
         * type.
         * 
         * Group: advanced
         */
        default AdvancedCMISEndpointConsumerBuilder sessionFacadeFactory(
                Object sessionFacadeFactory) {
            doSetProperty("sessionFacadeFactory", sessionFacadeFactory);
            return this;
        }
        /**
         * To use a custom CMISSessionFacadeFactory to create the
         * CMISSessionFacade instances.
         * 
         * The option will be converted to a
         * <code>org.apache.camel.component.cmis.CMISSessionFacadeFactory</code>
         * type.
         * 
         * Group: advanced
         */
        default AdvancedCMISEndpointConsumerBuilder sessionFacadeFactory(
                String sessionFacadeFactory) {
            doSetProperty("sessionFacadeFactory", sessionFacadeFactory);
            return this;
        }
        /**
         * Sets whether synchronous processing should be strictly used, or Camel
         * is allowed to use asynchronous processing (if supported).
         * 
         * The option is a: <code>boolean</code> type.
         * 
         * Default: false
         * Group: advanced
         */
        default AdvancedCMISEndpointConsumerBuilder synchronous(
                boolean synchronous) {
            doSetProperty("synchronous", synchronous);
            return this;
        }
        /**
         * Sets whether synchronous processing should be strictly used, or Camel
         * is allowed to use asynchronous processing (if supported).
         * 
         * The option will be converted to a <code>boolean</code> type.
         * 
         * Group: advanced
         */
        default AdvancedCMISEndpointConsumerBuilder synchronous(
                String synchronous) {
            doSetProperty("synchronous", synchronous);
            return this;
        }
    }

    /**
     * Builder for endpoint producers for the CMIS component.
     */
    public interface CMISEndpointProducerBuilder
            extends
                EndpointProducerBuilder {
        default AdvancedCMISEndpointProducerBuilder advanced() {
            return (AdvancedCMISEndpointProducerBuilder) this;
        }
        /**
         * Number of nodes to retrieve per page.
         * 
         * The option is a: <code>int</code> type.
         * 
         * Default: 100
         * Group: common
         */
        default CMISEndpointProducerBuilder pageSize(int pageSize) {
            doSetProperty("pageSize", pageSize);
            return this;
        }
        /**
         * Number of nodes to retrieve per page.
         * 
         * The option will be converted to a <code>int</code> type.
         * 
         * Group: common
         */
        default CMISEndpointProducerBuilder pageSize(String pageSize) {
            doSetProperty("pageSize", pageSize);
            return this;
        }
        /**
         * If set to true, the content of document node will be retrieved in
         * addition to the properties.
         * 
         * The option is a: <code>boolean</code> type.
         * 
         * Default: false
         * Group: common
         */
        default CMISEndpointProducerBuilder readContent(boolean readContent) {
            doSetProperty("readContent", readContent);
            return this;
        }
        /**
         * If set to true, the content of document node will be retrieved in
         * addition to the properties.
         * 
         * The option will be converted to a <code>boolean</code> type.
         * 
         * Group: common
         */
        default CMISEndpointProducerBuilder readContent(String readContent) {
            doSetProperty("readContent", readContent);
            return this;
        }
        /**
         * Max number of nodes to read.
         * 
         * The option is a: <code>int</code> type.
         * 
         * Group: common
         */
        default CMISEndpointProducerBuilder readCount(int readCount) {
            doSetProperty("readCount", readCount);
            return this;
        }
        /**
         * Max number of nodes to read.
         * 
         * The option will be converted to a <code>int</code> type.
         * 
         * Group: common
         */
        default CMISEndpointProducerBuilder readCount(String readCount) {
            doSetProperty("readCount", readCount);
            return this;
        }
        /**
         * The Id of the repository to use. If not specified the first available
         * repository is used.
         * 
         * The option is a: <code>java.lang.String</code> type.
         * 
         * Group: common
         */
        default CMISEndpointProducerBuilder repositoryId(String repositoryId) {
            doSetProperty("repositoryId", repositoryId);
            return this;
        }
        /**
         * Whether the producer should be started lazy (on the first message).
         * By starting lazy you can use this to allow CamelContext and routes to
         * startup in situations where a producer may otherwise fail during
         * starting and cause the route to fail being started. By deferring this
         * startup to be lazy then the startup failure can be handled during
         * routing messages via Camel's routing error handlers. Beware that when
         * the first message is processed then creating and starting the
         * producer may take a little time and prolong the total processing time
         * of the processing.
         * 
         * The option is a: <code>boolean</code> type.
         * 
         * Default: false
         * Group: producer
         */
        default CMISEndpointProducerBuilder lazyStartProducer(
                boolean lazyStartProducer) {
            doSetProperty("lazyStartProducer", lazyStartProducer);
            return this;
        }
        /**
         * Whether the producer should be started lazy (on the first message).
         * By starting lazy you can use this to allow CamelContext and routes to
         * startup in situations where a producer may otherwise fail during
         * starting and cause the route to fail being started. By deferring this
         * startup to be lazy then the startup failure can be handled during
         * routing messages via Camel's routing error handlers. Beware that when
         * the first message is processed then creating and starting the
         * producer may take a little time and prolong the total processing time
         * of the processing.
         * 
         * The option will be converted to a <code>boolean</code> type.
         * 
         * Group: producer
         */
        default CMISEndpointProducerBuilder lazyStartProducer(
                String lazyStartProducer) {
            doSetProperty("lazyStartProducer", lazyStartProducer);
            return this;
        }
        /**
         * If true, will execute the cmis query from the message body and return
         * result, otherwise will create a node in the cmis repository.
         * 
         * The option is a: <code>boolean</code> type.
         * 
         * Default: false
         * Group: producer
         */
        default CMISEndpointProducerBuilder queryMode(boolean queryMode) {
            doSetProperty("queryMode", queryMode);
            return this;
        }
        /**
         * If true, will execute the cmis query from the message body and return
         * result, otherwise will create a node in the cmis repository.
         * 
         * The option will be converted to a <code>boolean</code> type.
         * 
         * Group: producer
         */
        default CMISEndpointProducerBuilder queryMode(String queryMode) {
            doSetProperty("queryMode", queryMode);
            return this;
        }
        /**
         * Password for the cmis repository.
         * 
         * The option is a: <code>java.lang.String</code> type.
         * 
         * Group: security
         */
        default CMISEndpointProducerBuilder password(String password) {
            doSetProperty("password", password);
            return this;
        }
        /**
         * Username for the cmis repository.
         * 
         * The option is a: <code>java.lang.String</code> type.
         * 
         * Group: security
         */
        default CMISEndpointProducerBuilder username(String username) {
            doSetProperty("username", username);
            return this;
        }
    }

    /**
     * Advanced builder for endpoint producers for the CMIS component.
     */
    public interface AdvancedCMISEndpointProducerBuilder
            extends
                EndpointProducerBuilder {
        default CMISEndpointProducerBuilder basic() {
            return (CMISEndpointProducerBuilder) this;
        }
        /**
         * Whether the endpoint should use basic property binding (Camel 2.x) or
         * the newer property binding with additional capabilities.
         * 
         * The option is a: <code>boolean</code> type.
         * 
         * Default: false
         * Group: advanced
         */
        default AdvancedCMISEndpointProducerBuilder basicPropertyBinding(
                boolean basicPropertyBinding) {
            doSetProperty("basicPropertyBinding", basicPropertyBinding);
            return this;
        }
        /**
         * Whether the endpoint should use basic property binding (Camel 2.x) or
         * the newer property binding with additional capabilities.
         * 
         * The option will be converted to a <code>boolean</code> type.
         * 
         * Group: advanced
         */
        default AdvancedCMISEndpointProducerBuilder basicPropertyBinding(
                String basicPropertyBinding) {
            doSetProperty("basicPropertyBinding", basicPropertyBinding);
            return this;
        }
        /**
         * To use a custom CMISSessionFacadeFactory to create the
         * CMISSessionFacade instances.
         * 
         * The option is a:
         * <code>org.apache.camel.component.cmis.CMISSessionFacadeFactory</code>
         * type.
         * 
         * Group: advanced
         */
        default AdvancedCMISEndpointProducerBuilder sessionFacadeFactory(
                Object sessionFacadeFactory) {
            doSetProperty("sessionFacadeFactory", sessionFacadeFactory);
            return this;
        }
        /**
         * To use a custom CMISSessionFacadeFactory to create the
         * CMISSessionFacade instances.
         * 
         * The option will be converted to a
         * <code>org.apache.camel.component.cmis.CMISSessionFacadeFactory</code>
         * type.
         * 
         * Group: advanced
         */
        default AdvancedCMISEndpointProducerBuilder sessionFacadeFactory(
                String sessionFacadeFactory) {
            doSetProperty("sessionFacadeFactory", sessionFacadeFactory);
            return this;
        }
        /**
         * Sets whether synchronous processing should be strictly used, or Camel
         * is allowed to use asynchronous processing (if supported).
         * 
         * The option is a: <code>boolean</code> type.
         * 
         * Default: false
         * Group: advanced
         */
        default AdvancedCMISEndpointProducerBuilder synchronous(
                boolean synchronous) {
            doSetProperty("synchronous", synchronous);
            return this;
        }
        /**
         * Sets whether synchronous processing should be strictly used, or Camel
         * is allowed to use asynchronous processing (if supported).
         * 
         * The option will be converted to a <code>boolean</code> type.
         * 
         * Group: advanced
         */
        default AdvancedCMISEndpointProducerBuilder synchronous(
                String synchronous) {
            doSetProperty("synchronous", synchronous);
            return this;
        }
    }

    /**
     * Builder for endpoint for the CMIS component.
     */
    public interface CMISEndpointBuilder
            extends
                CMISEndpointConsumerBuilder, CMISEndpointProducerBuilder {
        default AdvancedCMISEndpointBuilder advanced() {
            return (AdvancedCMISEndpointBuilder) this;
        }
        /**
         * Number of nodes to retrieve per page.
         * 
         * The option is a: <code>int</code> type.
         * 
         * Default: 100
         * Group: common
         */
        default CMISEndpointBuilder pageSize(int pageSize) {
            doSetProperty("pageSize", pageSize);
            return this;
        }
        /**
         * Number of nodes to retrieve per page.
         * 
         * The option will be converted to a <code>int</code> type.
         * 
         * Group: common
         */
        default CMISEndpointBuilder pageSize(String pageSize) {
            doSetProperty("pageSize", pageSize);
            return this;
        }
        /**
         * If set to true, the content of document node will be retrieved in
         * addition to the properties.
         * 
         * The option is a: <code>boolean</code> type.
         * 
         * Default: false
         * Group: common
         */
        default CMISEndpointBuilder readContent(boolean readContent) {
            doSetProperty("readContent", readContent);
            return this;
        }
        /**
         * If set to true, the content of document node will be retrieved in
         * addition to the properties.
         * 
         * The option will be converted to a <code>boolean</code> type.
         * 
         * Group: common
         */
        default CMISEndpointBuilder readContent(String readContent) {
            doSetProperty("readContent", readContent);
            return this;
        }
        /**
         * Max number of nodes to read.
         * 
         * The option is a: <code>int</code> type.
         * 
         * Group: common
         */
        default CMISEndpointBuilder readCount(int readCount) {
            doSetProperty("readCount", readCount);
            return this;
        }
        /**
         * Max number of nodes to read.
         * 
         * The option will be converted to a <code>int</code> type.
         * 
         * Group: common
         */
        default CMISEndpointBuilder readCount(String readCount) {
            doSetProperty("readCount", readCount);
            return this;
        }
        /**
         * The Id of the repository to use. If not specified the first available
         * repository is used.
         * 
         * The option is a: <code>java.lang.String</code> type.
         * 
         * Group: common
         */
        default CMISEndpointBuilder repositoryId(String repositoryId) {
            doSetProperty("repositoryId", repositoryId);
            return this;
        }
        /**
         * Password for the cmis repository.
         * 
         * The option is a: <code>java.lang.String</code> type.
         * 
         * Group: security
         */
        default CMISEndpointBuilder password(String password) {
            doSetProperty("password", password);
            return this;
        }
        /**
         * Username for the cmis repository.
         * 
         * The option is a: <code>java.lang.String</code> type.
         * 
         * Group: security
         */
        default CMISEndpointBuilder username(String username) {
            doSetProperty("username", username);
            return this;
        }
    }

    /**
     * Advanced builder for endpoint for the CMIS component.
     */
    public interface AdvancedCMISEndpointBuilder
            extends
                AdvancedCMISEndpointConsumerBuilder, AdvancedCMISEndpointProducerBuilder {
        default CMISEndpointBuilder basic() {
            return (CMISEndpointBuilder) this;
        }
        /**
         * Whether the endpoint should use basic property binding (Camel 2.x) or
         * the newer property binding with additional capabilities.
         * 
         * The option is a: <code>boolean</code> type.
         * 
         * Default: false
         * Group: advanced
         */
        default AdvancedCMISEndpointBuilder basicPropertyBinding(
                boolean basicPropertyBinding) {
            doSetProperty("basicPropertyBinding", basicPropertyBinding);
            return this;
        }
        /**
         * Whether the endpoint should use basic property binding (Camel 2.x) or
         * the newer property binding with additional capabilities.
         * 
         * The option will be converted to a <code>boolean</code> type.
         * 
         * Group: advanced
         */
        default AdvancedCMISEndpointBuilder basicPropertyBinding(
                String basicPropertyBinding) {
            doSetProperty("basicPropertyBinding", basicPropertyBinding);
            return this;
        }
        /**
         * To use a custom CMISSessionFacadeFactory to create the
         * CMISSessionFacade instances.
         * 
         * The option is a:
         * <code>org.apache.camel.component.cmis.CMISSessionFacadeFactory</code>
         * type.
         * 
         * Group: advanced
         */
        default AdvancedCMISEndpointBuilder sessionFacadeFactory(
                Object sessionFacadeFactory) {
            doSetProperty("sessionFacadeFactory", sessionFacadeFactory);
            return this;
        }
        /**
         * To use a custom CMISSessionFacadeFactory to create the
         * CMISSessionFacade instances.
         * 
         * The option will be converted to a
         * <code>org.apache.camel.component.cmis.CMISSessionFacadeFactory</code>
         * type.
         * 
         * Group: advanced
         */
        default AdvancedCMISEndpointBuilder sessionFacadeFactory(
                String sessionFacadeFactory) {
            doSetProperty("sessionFacadeFactory", sessionFacadeFactory);
            return this;
        }
        /**
         * Sets whether synchronous processing should be strictly used, or Camel
         * is allowed to use asynchronous processing (if supported).
         * 
         * The option is a: <code>boolean</code> type.
         * 
         * Default: false
         * Group: advanced
         */
        default AdvancedCMISEndpointBuilder synchronous(boolean synchronous) {
            doSetProperty("synchronous", synchronous);
            return this;
        }
        /**
         * Sets whether synchronous processing should be strictly used, or Camel
         * is allowed to use asynchronous processing (if supported).
         * 
         * The option will be converted to a <code>boolean</code> type.
         * 
         * Group: advanced
         */
        default AdvancedCMISEndpointBuilder synchronous(String synchronous) {
            doSetProperty("synchronous", synchronous);
            return this;
        }
    }
    /**
     * CMIS (camel-cmis)
     * The cmis component uses the Apache Chemistry client API and allows you to
     * add/read nodes to/from a CMIS compliant content repositories.
     * 
     * Category: cms,database
     * Since: 2.11
     * Maven coordinates: org.apache.camel:camel-cmis
     * 
     * Syntax: <code>cmis:cmsUrl</code>
     * 
     * Path parameter: cmsUrl (required)
     * URL to the cmis repository
     */
    default CMISEndpointBuilder cmis(String path) {
        class CMISEndpointBuilderImpl extends AbstractEndpointBuilder implements CMISEndpointBuilder, AdvancedCMISEndpointBuilder {
            public CMISEndpointBuilderImpl(String path) {
                super("cmis", path);
            }
        }
        return new CMISEndpointBuilderImpl(path);
    }
}