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
 * Component for integrate IOTA DLT
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@Generated("org.apache.camel.maven.packaging.EndpointDslMojo")
public interface IOTAEndpointBuilderFactory {


    /**
     * Builder for endpoint consumers for the IOTA component.
     */
    public interface IOTAEndpointConsumerBuilder
            extends
                EndpointConsumerBuilder {
        default AdvancedIOTAEndpointConsumerBuilder advanced() {
            return (AdvancedIOTAEndpointConsumerBuilder) this;
        }
        /**
         * Component name.
         * The option is a <code>java.lang.String</code> type.
         * @group common
         */
        default IOTAEndpointConsumerBuilder name(String name) {
            setProperty("name", name);
            return this;
        }
        /**
         * The depth determines how deep the tangle is analysed for getting
         * Tips.
         * The option is a <code>java.lang.Integer</code> type.
         * @group common
         */
        default IOTAEndpointConsumerBuilder depth(Integer depth) {
            setProperty("depth", depth);
            return this;
        }
        /**
         * The depth determines how deep the tangle is analysed for getting
         * Tips.
         * The option will be converted to a <code>java.lang.Integer</code>
         * type.
         * @group common
         */
        default IOTAEndpointConsumerBuilder depth(String depth) {
            setProperty("depth", depth);
            return this;
        }
        /**
         * The minWeightMagnitude is the minimum number of zeroes that a
         * proof-of-work output/transaction hash must end with to be considered
         * valid by full nodes.
         * The option is a <code>java.lang.Integer</code> type.
         * @group common
         */
        default IOTAEndpointConsumerBuilder minWeightMagnitude(
                Integer minWeightMagnitude) {
            setProperty("minWeightMagnitude", minWeightMagnitude);
            return this;
        }
        /**
         * The minWeightMagnitude is the minimum number of zeroes that a
         * proof-of-work output/transaction hash must end with to be considered
         * valid by full nodes.
         * The option will be converted to a <code>java.lang.Integer</code>
         * type.
         * @group common
         */
        default IOTAEndpointConsumerBuilder minWeightMagnitude(
                String minWeightMagnitude) {
            setProperty("minWeightMagnitude", minWeightMagnitude);
            return this;
        }
        /**
         * Supported operations are 'sendTransfer', 'getNewAddress'.
         * The option is a <code>java.lang.String</code> type.
         * @group common
         */
        default IOTAEndpointConsumerBuilder operation(String operation) {
            setProperty("operation", operation);
            return this;
        }
        /**
         * Address security level.
         * The option is a <code>java.lang.Integer</code> type.
         * @group common
         */
        default IOTAEndpointConsumerBuilder securityLevel(Integer securityLevel) {
            setProperty("securityLevel", securityLevel);
            return this;
        }
        /**
         * Address security level.
         * The option will be converted to a <code>java.lang.Integer</code>
         * type.
         * @group common
         */
        default IOTAEndpointConsumerBuilder securityLevel(String securityLevel) {
            setProperty("securityLevel", securityLevel);
            return this;
        }
        /**
         * TAG.
         * The option is a <code>java.lang.String</code> type.
         * @group common
         */
        default IOTAEndpointConsumerBuilder tag(String tag) {
            setProperty("tag", tag);
            return this;
        }
        /**
         * Node url.
         * The option is a <code>java.lang.String</code> type.
         * @group common
         */
        default IOTAEndpointConsumerBuilder url(String url) {
            setProperty("url", url);
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
         * The option is a <code>boolean</code> type.
         * @group consumer
         */
        default IOTAEndpointConsumerBuilder bridgeErrorHandler(
                boolean bridgeErrorHandler) {
            setProperty("bridgeErrorHandler", bridgeErrorHandler);
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
         * The option will be converted to a <code>boolean</code> type.
         * @group consumer
         */
        default IOTAEndpointConsumerBuilder bridgeErrorHandler(
                String bridgeErrorHandler) {
            setProperty("bridgeErrorHandler", bridgeErrorHandler);
            return this;
        }
    }

    /**
     * Advanced builder for endpoint consumers for the IOTA component.
     */
    public interface AdvancedIOTAEndpointConsumerBuilder
            extends
                EndpointConsumerBuilder {
        default IOTAEndpointConsumerBuilder basic() {
            return (IOTAEndpointConsumerBuilder) this;
        }
        /**
         * To let the consumer use a custom ExceptionHandler. Notice if the
         * option bridgeErrorHandler is enabled then this option is not in use.
         * By default the consumer will deal with exceptions, that will be
         * logged at WARN or ERROR level and ignored.
         * The option is a <code>org.apache.camel.spi.ExceptionHandler</code>
         * type.
         * @group consumer (advanced)
         */
        default AdvancedIOTAEndpointConsumerBuilder exceptionHandler(
                ExceptionHandler exceptionHandler) {
            setProperty("exceptionHandler", exceptionHandler);
            return this;
        }
        /**
         * To let the consumer use a custom ExceptionHandler. Notice if the
         * option bridgeErrorHandler is enabled then this option is not in use.
         * By default the consumer will deal with exceptions, that will be
         * logged at WARN or ERROR level and ignored.
         * The option will be converted to a
         * <code>org.apache.camel.spi.ExceptionHandler</code> type.
         * @group consumer (advanced)
         */
        default AdvancedIOTAEndpointConsumerBuilder exceptionHandler(
                String exceptionHandler) {
            setProperty("exceptionHandler", exceptionHandler);
            return this;
        }
        /**
         * Sets the exchange pattern when the consumer creates an exchange.
         * The option is a <code>org.apache.camel.ExchangePattern</code> type.
         * @group consumer (advanced)
         */
        default AdvancedIOTAEndpointConsumerBuilder exchangePattern(
                ExchangePattern exchangePattern) {
            setProperty("exchangePattern", exchangePattern);
            return this;
        }
        /**
         * Sets the exchange pattern when the consumer creates an exchange.
         * The option will be converted to a
         * <code>org.apache.camel.ExchangePattern</code> type.
         * @group consumer (advanced)
         */
        default AdvancedIOTAEndpointConsumerBuilder exchangePattern(
                String exchangePattern) {
            setProperty("exchangePattern", exchangePattern);
            return this;
        }
        /**
         * Whether the endpoint should use basic property binding (Camel 2.x) or
         * the newer property binding with additional capabilities.
         * The option is a <code>boolean</code> type.
         * @group advanced
         */
        default AdvancedIOTAEndpointConsumerBuilder basicPropertyBinding(
                boolean basicPropertyBinding) {
            setProperty("basicPropertyBinding", basicPropertyBinding);
            return this;
        }
        /**
         * Whether the endpoint should use basic property binding (Camel 2.x) or
         * the newer property binding with additional capabilities.
         * The option will be converted to a <code>boolean</code> type.
         * @group advanced
         */
        default AdvancedIOTAEndpointConsumerBuilder basicPropertyBinding(
                String basicPropertyBinding) {
            setProperty("basicPropertyBinding", basicPropertyBinding);
            return this;
        }
        /**
         * Sets whether synchronous processing should be strictly used, or Camel
         * is allowed to use asynchronous processing (if supported).
         * The option is a <code>boolean</code> type.
         * @group advanced
         */
        default AdvancedIOTAEndpointConsumerBuilder synchronous(
                boolean synchronous) {
            setProperty("synchronous", synchronous);
            return this;
        }
        /**
         * Sets whether synchronous processing should be strictly used, or Camel
         * is allowed to use asynchronous processing (if supported).
         * The option will be converted to a <code>boolean</code> type.
         * @group advanced
         */
        default AdvancedIOTAEndpointConsumerBuilder synchronous(
                String synchronous) {
            setProperty("synchronous", synchronous);
            return this;
        }
    }

    /**
     * Builder for endpoint producers for the IOTA component.
     */
    public interface IOTAEndpointProducerBuilder
            extends
                EndpointProducerBuilder {
        default AdvancedIOTAEndpointProducerBuilder advanced() {
            return (AdvancedIOTAEndpointProducerBuilder) this;
        }
        /**
         * Component name.
         * The option is a <code>java.lang.String</code> type.
         * @group common
         */
        default IOTAEndpointProducerBuilder name(String name) {
            setProperty("name", name);
            return this;
        }
        /**
         * The depth determines how deep the tangle is analysed for getting
         * Tips.
         * The option is a <code>java.lang.Integer</code> type.
         * @group common
         */
        default IOTAEndpointProducerBuilder depth(Integer depth) {
            setProperty("depth", depth);
            return this;
        }
        /**
         * The depth determines how deep the tangle is analysed for getting
         * Tips.
         * The option will be converted to a <code>java.lang.Integer</code>
         * type.
         * @group common
         */
        default IOTAEndpointProducerBuilder depth(String depth) {
            setProperty("depth", depth);
            return this;
        }
        /**
         * The minWeightMagnitude is the minimum number of zeroes that a
         * proof-of-work output/transaction hash must end with to be considered
         * valid by full nodes.
         * The option is a <code>java.lang.Integer</code> type.
         * @group common
         */
        default IOTAEndpointProducerBuilder minWeightMagnitude(
                Integer minWeightMagnitude) {
            setProperty("minWeightMagnitude", minWeightMagnitude);
            return this;
        }
        /**
         * The minWeightMagnitude is the minimum number of zeroes that a
         * proof-of-work output/transaction hash must end with to be considered
         * valid by full nodes.
         * The option will be converted to a <code>java.lang.Integer</code>
         * type.
         * @group common
         */
        default IOTAEndpointProducerBuilder minWeightMagnitude(
                String minWeightMagnitude) {
            setProperty("minWeightMagnitude", minWeightMagnitude);
            return this;
        }
        /**
         * Supported operations are 'sendTransfer', 'getNewAddress'.
         * The option is a <code>java.lang.String</code> type.
         * @group common
         */
        default IOTAEndpointProducerBuilder operation(String operation) {
            setProperty("operation", operation);
            return this;
        }
        /**
         * Address security level.
         * The option is a <code>java.lang.Integer</code> type.
         * @group common
         */
        default IOTAEndpointProducerBuilder securityLevel(Integer securityLevel) {
            setProperty("securityLevel", securityLevel);
            return this;
        }
        /**
         * Address security level.
         * The option will be converted to a <code>java.lang.Integer</code>
         * type.
         * @group common
         */
        default IOTAEndpointProducerBuilder securityLevel(String securityLevel) {
            setProperty("securityLevel", securityLevel);
            return this;
        }
        /**
         * TAG.
         * The option is a <code>java.lang.String</code> type.
         * @group common
         */
        default IOTAEndpointProducerBuilder tag(String tag) {
            setProperty("tag", tag);
            return this;
        }
        /**
         * Node url.
         * The option is a <code>java.lang.String</code> type.
         * @group common
         */
        default IOTAEndpointProducerBuilder url(String url) {
            setProperty("url", url);
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
         * The option is a <code>boolean</code> type.
         * @group producer
         */
        default IOTAEndpointProducerBuilder lazyStartProducer(
                boolean lazyStartProducer) {
            setProperty("lazyStartProducer", lazyStartProducer);
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
         * The option will be converted to a <code>boolean</code> type.
         * @group producer
         */
        default IOTAEndpointProducerBuilder lazyStartProducer(
                String lazyStartProducer) {
            setProperty("lazyStartProducer", lazyStartProducer);
            return this;
        }
    }

    /**
     * Advanced builder for endpoint producers for the IOTA component.
     */
    public interface AdvancedIOTAEndpointProducerBuilder
            extends
                EndpointProducerBuilder {
        default IOTAEndpointProducerBuilder basic() {
            return (IOTAEndpointProducerBuilder) this;
        }
        /**
         * Whether the endpoint should use basic property binding (Camel 2.x) or
         * the newer property binding with additional capabilities.
         * The option is a <code>boolean</code> type.
         * @group advanced
         */
        default AdvancedIOTAEndpointProducerBuilder basicPropertyBinding(
                boolean basicPropertyBinding) {
            setProperty("basicPropertyBinding", basicPropertyBinding);
            return this;
        }
        /**
         * Whether the endpoint should use basic property binding (Camel 2.x) or
         * the newer property binding with additional capabilities.
         * The option will be converted to a <code>boolean</code> type.
         * @group advanced
         */
        default AdvancedIOTAEndpointProducerBuilder basicPropertyBinding(
                String basicPropertyBinding) {
            setProperty("basicPropertyBinding", basicPropertyBinding);
            return this;
        }
        /**
         * Sets whether synchronous processing should be strictly used, or Camel
         * is allowed to use asynchronous processing (if supported).
         * The option is a <code>boolean</code> type.
         * @group advanced
         */
        default AdvancedIOTAEndpointProducerBuilder synchronous(
                boolean synchronous) {
            setProperty("synchronous", synchronous);
            return this;
        }
        /**
         * Sets whether synchronous processing should be strictly used, or Camel
         * is allowed to use asynchronous processing (if supported).
         * The option will be converted to a <code>boolean</code> type.
         * @group advanced
         */
        default AdvancedIOTAEndpointProducerBuilder synchronous(
                String synchronous) {
            setProperty("synchronous", synchronous);
            return this;
        }
    }

    /**
     * Builder for endpoint for the IOTA component.
     */
    public interface IOTAEndpointBuilder
            extends
                IOTAEndpointConsumerBuilder, IOTAEndpointProducerBuilder {
        default AdvancedIOTAEndpointBuilder advanced() {
            return (AdvancedIOTAEndpointBuilder) this;
        }
        /**
         * Component name.
         * The option is a <code>java.lang.String</code> type.
         * @group common
         */
        default IOTAEndpointBuilder name(String name) {
            setProperty("name", name);
            return this;
        }
        /**
         * The depth determines how deep the tangle is analysed for getting
         * Tips.
         * The option is a <code>java.lang.Integer</code> type.
         * @group common
         */
        default IOTAEndpointBuilder depth(Integer depth) {
            setProperty("depth", depth);
            return this;
        }
        /**
         * The depth determines how deep the tangle is analysed for getting
         * Tips.
         * The option will be converted to a <code>java.lang.Integer</code>
         * type.
         * @group common
         */
        default IOTAEndpointBuilder depth(String depth) {
            setProperty("depth", depth);
            return this;
        }
        /**
         * The minWeightMagnitude is the minimum number of zeroes that a
         * proof-of-work output/transaction hash must end with to be considered
         * valid by full nodes.
         * The option is a <code>java.lang.Integer</code> type.
         * @group common
         */
        default IOTAEndpointBuilder minWeightMagnitude(
                Integer minWeightMagnitude) {
            setProperty("minWeightMagnitude", minWeightMagnitude);
            return this;
        }
        /**
         * The minWeightMagnitude is the minimum number of zeroes that a
         * proof-of-work output/transaction hash must end with to be considered
         * valid by full nodes.
         * The option will be converted to a <code>java.lang.Integer</code>
         * type.
         * @group common
         */
        default IOTAEndpointBuilder minWeightMagnitude(String minWeightMagnitude) {
            setProperty("minWeightMagnitude", minWeightMagnitude);
            return this;
        }
        /**
         * Supported operations are 'sendTransfer', 'getNewAddress'.
         * The option is a <code>java.lang.String</code> type.
         * @group common
         */
        default IOTAEndpointBuilder operation(String operation) {
            setProperty("operation", operation);
            return this;
        }
        /**
         * Address security level.
         * The option is a <code>java.lang.Integer</code> type.
         * @group common
         */
        default IOTAEndpointBuilder securityLevel(Integer securityLevel) {
            setProperty("securityLevel", securityLevel);
            return this;
        }
        /**
         * Address security level.
         * The option will be converted to a <code>java.lang.Integer</code>
         * type.
         * @group common
         */
        default IOTAEndpointBuilder securityLevel(String securityLevel) {
            setProperty("securityLevel", securityLevel);
            return this;
        }
        /**
         * TAG.
         * The option is a <code>java.lang.String</code> type.
         * @group common
         */
        default IOTAEndpointBuilder tag(String tag) {
            setProperty("tag", tag);
            return this;
        }
        /**
         * Node url.
         * The option is a <code>java.lang.String</code> type.
         * @group common
         */
        default IOTAEndpointBuilder url(String url) {
            setProperty("url", url);
            return this;
        }
    }

    /**
     * Advanced builder for endpoint for the IOTA component.
     */
    public interface AdvancedIOTAEndpointBuilder
            extends
                AdvancedIOTAEndpointConsumerBuilder, AdvancedIOTAEndpointProducerBuilder {
        default IOTAEndpointBuilder basic() {
            return (IOTAEndpointBuilder) this;
        }
        /**
         * Whether the endpoint should use basic property binding (Camel 2.x) or
         * the newer property binding with additional capabilities.
         * The option is a <code>boolean</code> type.
         * @group advanced
         */
        default AdvancedIOTAEndpointBuilder basicPropertyBinding(
                boolean basicPropertyBinding) {
            setProperty("basicPropertyBinding", basicPropertyBinding);
            return this;
        }
        /**
         * Whether the endpoint should use basic property binding (Camel 2.x) or
         * the newer property binding with additional capabilities.
         * The option will be converted to a <code>boolean</code> type.
         * @group advanced
         */
        default AdvancedIOTAEndpointBuilder basicPropertyBinding(
                String basicPropertyBinding) {
            setProperty("basicPropertyBinding", basicPropertyBinding);
            return this;
        }
        /**
         * Sets whether synchronous processing should be strictly used, or Camel
         * is allowed to use asynchronous processing (if supported).
         * The option is a <code>boolean</code> type.
         * @group advanced
         */
        default AdvancedIOTAEndpointBuilder synchronous(boolean synchronous) {
            setProperty("synchronous", synchronous);
            return this;
        }
        /**
         * Sets whether synchronous processing should be strictly used, or Camel
         * is allowed to use asynchronous processing (if supported).
         * The option will be converted to a <code>boolean</code> type.
         * @group advanced
         */
        default AdvancedIOTAEndpointBuilder synchronous(String synchronous) {
            setProperty("synchronous", synchronous);
            return this;
        }
    }
    /**
     * Component for integrate IOTA DLT Creates a builder to build endpoints for
     * the IOTA component.
     */
    default IOTAEndpointBuilder iOTA(String path) {
        class IOTAEndpointBuilderImpl extends AbstractEndpointBuilder implements IOTAEndpointBuilder, AdvancedIOTAEndpointBuilder {
            public IOTAEndpointBuilderImpl(String path) {
                super("iota", path);
            }
        }
        return new IOTAEndpointBuilderImpl(path);
    }
}