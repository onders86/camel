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
import org.apache.camel.builder.EndpointConsumerBuilder;
import org.apache.camel.builder.EndpointProducerBuilder;
import org.apache.camel.builder.endpoint.AbstractEndpointBuilder;

/**
 * The lumberjack retrieves logs sent over the network using the Lumberjack
 * protocol.
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@Generated("org.apache.camel.maven.packaging.EndpointDslMojo")
public interface LumberjackEndpointBuilderFactory {


    /**
     * Builder for endpoint for the Lumberjack component.
     */
    public interface LumberjackEndpointBuilder
            extends
                EndpointConsumerBuilder {
        default AdvancedLumberjackEndpointBuilder advanced() {
            return (AdvancedLumberjackEndpointBuilder) this;
        }
        /**
         * Network interface on which to listen for Lumberjack.
         * The option is a <code>java.lang.String</code> type.
         * @group consumer
         */
        default LumberjackEndpointBuilder host(String host) {
            setProperty("host", host);
            return this;
        }
        /**
         * Network port on which to listen for Lumberjack.
         * The option is a <code>int</code> type.
         * @group consumer
         */
        default LumberjackEndpointBuilder port(int port) {
            setProperty("port", port);
            return this;
        }
        /**
         * Network port on which to listen for Lumberjack.
         * The option will be converted to a <code>int</code> type.
         * @group consumer
         */
        default LumberjackEndpointBuilder port(String port) {
            setProperty("port", port);
            return this;
        }
        /**
         * SSL configuration.
         * The option is a
         * <code>org.apache.camel.support.jsse.SSLContextParameters</code> type.
         * @group consumer
         */
        default LumberjackEndpointBuilder sslContextParameters(
                Object sslContextParameters) {
            setProperty("sslContextParameters", sslContextParameters);
            return this;
        }
        /**
         * SSL configuration.
         * The option will be converted to a
         * <code>org.apache.camel.support.jsse.SSLContextParameters</code> type.
         * @group consumer
         */
        default LumberjackEndpointBuilder sslContextParameters(
                String sslContextParameters) {
            setProperty("sslContextParameters", sslContextParameters);
            return this;
        }
    }

    /**
     * Advanced builder for endpoint for the Lumberjack component.
     */
    public interface AdvancedLumberjackEndpointBuilder
            extends
                EndpointConsumerBuilder {
        default LumberjackEndpointBuilder basic() {
            return (LumberjackEndpointBuilder) this;
        }
        /**
         * Whether the endpoint should use basic property binding (Camel 2.x) or
         * the newer property binding with additional capabilities.
         * The option is a <code>boolean</code> type.
         * @group advanced
         */
        default AdvancedLumberjackEndpointBuilder basicPropertyBinding(
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
        default AdvancedLumberjackEndpointBuilder basicPropertyBinding(
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
        default AdvancedLumberjackEndpointBuilder synchronous(
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
        default AdvancedLumberjackEndpointBuilder synchronous(String synchronous) {
            setProperty("synchronous", synchronous);
            return this;
        }
    }
    /**
     * The lumberjack retrieves logs sent over the network using the Lumberjack
     * protocol. Creates a builder to build endpoints for the Lumberjack
     * component.
     */
    default LumberjackEndpointBuilder lumberjack(String path) {
        class LumberjackEndpointBuilderImpl extends AbstractEndpointBuilder implements LumberjackEndpointBuilder, AdvancedLumberjackEndpointBuilder {
            public LumberjackEndpointBuilderImpl(String path) {
                super("lumberjack", path);
            }
        }
        return new LumberjackEndpointBuilderImpl(path);
    }
}