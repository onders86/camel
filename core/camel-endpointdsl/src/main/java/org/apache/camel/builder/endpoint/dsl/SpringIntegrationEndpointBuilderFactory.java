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
 * Bridges Camel with Spring Integration.
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@Generated("org.apache.camel.maven.packaging.EndpointDslMojo")
public interface SpringIntegrationEndpointBuilderFactory {


    /**
     * Builder for endpoint consumers for the Spring Integration component.
     */
    public interface SpringIntegrationEndpointConsumerBuilder
            extends
                EndpointConsumerBuilder {
        default AdvancedSpringIntegrationEndpointConsumerBuilder advanced() {
            return (AdvancedSpringIntegrationEndpointConsumerBuilder) this;
        }
        /**
         * The default channel name which is used by the Spring Integration
         * Spring context. It will equal to the inputChannel name for the Spring
         * Integration consumer and the outputChannel name for the Spring
         * Integration provider.
         * The option is a <code>java.lang.String</code> type.
         * @group common
         */
        default SpringIntegrationEndpointConsumerBuilder defaultChannel(
                String defaultChannel) {
            setProperty("defaultChannel", defaultChannel);
            return this;
        }
        /**
         * The exchange pattern that the Spring integration endpoint should use.
         * If inOut=true then a reply channel is expected, either from the
         * Spring Integration Message header or configured on the endpoint.
         * The option is a <code>boolean</code> type.
         * @group common
         */
        default SpringIntegrationEndpointConsumerBuilder inOut(boolean inOut) {
            setProperty("inOut", inOut);
            return this;
        }
        /**
         * The exchange pattern that the Spring integration endpoint should use.
         * If inOut=true then a reply channel is expected, either from the
         * Spring Integration Message header or configured on the endpoint.
         * The option will be converted to a <code>boolean</code> type.
         * @group common
         */
        default SpringIntegrationEndpointConsumerBuilder inOut(String inOut) {
            setProperty("inOut", inOut);
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
        default SpringIntegrationEndpointConsumerBuilder bridgeErrorHandler(
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
        default SpringIntegrationEndpointConsumerBuilder bridgeErrorHandler(
                String bridgeErrorHandler) {
            setProperty("bridgeErrorHandler", bridgeErrorHandler);
            return this;
        }
        /**
         * The Spring integration input channel name that this endpoint wants to
         * consume from Spring integration.
         * The option is a <code>java.lang.String</code> type.
         * @group consumer
         */
        default SpringIntegrationEndpointConsumerBuilder inputChannel(
                String inputChannel) {
            setProperty("inputChannel", inputChannel);
            return this;
        }
    }

    /**
     * Advanced builder for endpoint consumers for the Spring Integration
     * component.
     */
    public interface AdvancedSpringIntegrationEndpointConsumerBuilder
            extends
                EndpointConsumerBuilder {
        default SpringIntegrationEndpointConsumerBuilder basic() {
            return (SpringIntegrationEndpointConsumerBuilder) this;
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
        default AdvancedSpringIntegrationEndpointConsumerBuilder exceptionHandler(
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
        default AdvancedSpringIntegrationEndpointConsumerBuilder exceptionHandler(
                String exceptionHandler) {
            setProperty("exceptionHandler", exceptionHandler);
            return this;
        }
        /**
         * Sets the exchange pattern when the consumer creates an exchange.
         * The option is a <code>org.apache.camel.ExchangePattern</code> type.
         * @group consumer (advanced)
         */
        default AdvancedSpringIntegrationEndpointConsumerBuilder exchangePattern(
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
        default AdvancedSpringIntegrationEndpointConsumerBuilder exchangePattern(
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
        default AdvancedSpringIntegrationEndpointConsumerBuilder basicPropertyBinding(
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
        default AdvancedSpringIntegrationEndpointConsumerBuilder basicPropertyBinding(
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
        default AdvancedSpringIntegrationEndpointConsumerBuilder synchronous(
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
        default AdvancedSpringIntegrationEndpointConsumerBuilder synchronous(
                String synchronous) {
            setProperty("synchronous", synchronous);
            return this;
        }
    }

    /**
     * Builder for endpoint producers for the Spring Integration component.
     */
    public interface SpringIntegrationEndpointProducerBuilder
            extends
                EndpointProducerBuilder {
        default AdvancedSpringIntegrationEndpointProducerBuilder advanced() {
            return (AdvancedSpringIntegrationEndpointProducerBuilder) this;
        }
        /**
         * The default channel name which is used by the Spring Integration
         * Spring context. It will equal to the inputChannel name for the Spring
         * Integration consumer and the outputChannel name for the Spring
         * Integration provider.
         * The option is a <code>java.lang.String</code> type.
         * @group common
         */
        default SpringIntegrationEndpointProducerBuilder defaultChannel(
                String defaultChannel) {
            setProperty("defaultChannel", defaultChannel);
            return this;
        }
        /**
         * The exchange pattern that the Spring integration endpoint should use.
         * If inOut=true then a reply channel is expected, either from the
         * Spring Integration Message header or configured on the endpoint.
         * The option is a <code>boolean</code> type.
         * @group common
         */
        default SpringIntegrationEndpointProducerBuilder inOut(boolean inOut) {
            setProperty("inOut", inOut);
            return this;
        }
        /**
         * The exchange pattern that the Spring integration endpoint should use.
         * If inOut=true then a reply channel is expected, either from the
         * Spring Integration Message header or configured on the endpoint.
         * The option will be converted to a <code>boolean</code> type.
         * @group common
         */
        default SpringIntegrationEndpointProducerBuilder inOut(String inOut) {
            setProperty("inOut", inOut);
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
        default SpringIntegrationEndpointProducerBuilder lazyStartProducer(
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
        default SpringIntegrationEndpointProducerBuilder lazyStartProducer(
                String lazyStartProducer) {
            setProperty("lazyStartProducer", lazyStartProducer);
            return this;
        }
        /**
         * The Spring integration output channel name that is used to send
         * messages to Spring integration.
         * The option is a <code>java.lang.String</code> type.
         * @group producer
         */
        default SpringIntegrationEndpointProducerBuilder outputChannel(
                String outputChannel) {
            setProperty("outputChannel", outputChannel);
            return this;
        }
    }

    /**
     * Advanced builder for endpoint producers for the Spring Integration
     * component.
     */
    public interface AdvancedSpringIntegrationEndpointProducerBuilder
            extends
                EndpointProducerBuilder {
        default SpringIntegrationEndpointProducerBuilder basic() {
            return (SpringIntegrationEndpointProducerBuilder) this;
        }
        /**
         * Whether the endpoint should use basic property binding (Camel 2.x) or
         * the newer property binding with additional capabilities.
         * The option is a <code>boolean</code> type.
         * @group advanced
         */
        default AdvancedSpringIntegrationEndpointProducerBuilder basicPropertyBinding(
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
        default AdvancedSpringIntegrationEndpointProducerBuilder basicPropertyBinding(
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
        default AdvancedSpringIntegrationEndpointProducerBuilder synchronous(
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
        default AdvancedSpringIntegrationEndpointProducerBuilder synchronous(
                String synchronous) {
            setProperty("synchronous", synchronous);
            return this;
        }
    }

    /**
     * Builder for endpoint for the Spring Integration component.
     */
    public interface SpringIntegrationEndpointBuilder
            extends
                SpringIntegrationEndpointConsumerBuilder, SpringIntegrationEndpointProducerBuilder {
        default AdvancedSpringIntegrationEndpointBuilder advanced() {
            return (AdvancedSpringIntegrationEndpointBuilder) this;
        }
        /**
         * The default channel name which is used by the Spring Integration
         * Spring context. It will equal to the inputChannel name for the Spring
         * Integration consumer and the outputChannel name for the Spring
         * Integration provider.
         * The option is a <code>java.lang.String</code> type.
         * @group common
         */
        default SpringIntegrationEndpointBuilder defaultChannel(
                String defaultChannel) {
            setProperty("defaultChannel", defaultChannel);
            return this;
        }
        /**
         * The exchange pattern that the Spring integration endpoint should use.
         * If inOut=true then a reply channel is expected, either from the
         * Spring Integration Message header or configured on the endpoint.
         * The option is a <code>boolean</code> type.
         * @group common
         */
        default SpringIntegrationEndpointBuilder inOut(boolean inOut) {
            setProperty("inOut", inOut);
            return this;
        }
        /**
         * The exchange pattern that the Spring integration endpoint should use.
         * If inOut=true then a reply channel is expected, either from the
         * Spring Integration Message header or configured on the endpoint.
         * The option will be converted to a <code>boolean</code> type.
         * @group common
         */
        default SpringIntegrationEndpointBuilder inOut(String inOut) {
            setProperty("inOut", inOut);
            return this;
        }
    }

    /**
     * Advanced builder for endpoint for the Spring Integration component.
     */
    public interface AdvancedSpringIntegrationEndpointBuilder
            extends
                AdvancedSpringIntegrationEndpointConsumerBuilder, AdvancedSpringIntegrationEndpointProducerBuilder {
        default SpringIntegrationEndpointBuilder basic() {
            return (SpringIntegrationEndpointBuilder) this;
        }
        /**
         * Whether the endpoint should use basic property binding (Camel 2.x) or
         * the newer property binding with additional capabilities.
         * The option is a <code>boolean</code> type.
         * @group advanced
         */
        default AdvancedSpringIntegrationEndpointBuilder basicPropertyBinding(
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
        default AdvancedSpringIntegrationEndpointBuilder basicPropertyBinding(
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
        default AdvancedSpringIntegrationEndpointBuilder synchronous(
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
        default AdvancedSpringIntegrationEndpointBuilder synchronous(
                String synchronous) {
            setProperty("synchronous", synchronous);
            return this;
        }
    }
    /**
     * Bridges Camel with Spring Integration. Creates a builder to build
     * endpoints for the Spring Integration component.
     */
    default SpringIntegrationEndpointBuilder springIntegration(String path) {
        class SpringIntegrationEndpointBuilderImpl extends AbstractEndpointBuilder implements SpringIntegrationEndpointBuilder, AdvancedSpringIntegrationEndpointBuilder {
            public SpringIntegrationEndpointBuilderImpl(String path) {
                super("spring-integration", path);
            }
        }
        return new SpringIntegrationEndpointBuilderImpl(path);
    }
}