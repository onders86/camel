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
 * The drill component gives you the ability to quering into apache drill
 * cluster.
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@Generated("org.apache.camel.maven.packaging.EndpointDslMojo")
public interface DrillEndpointBuilderFactory {


    /**
     * Builder for endpoint for the Drill component.
     */
    public interface DrillEndpointBuilder extends EndpointProducerBuilder {
        default AdvancedDrillEndpointBuilder advanced() {
            return (AdvancedDrillEndpointBuilder) this;
        }
        /**
         * Cluster ID
         * https://drill.apache.org/docs/using-the-jdbc-driver/#determining-the-cluster-id.
         * 
         * The option is a: <code>java.lang.String</code> type.
         * 
         * Group: producer
         */
        default DrillEndpointBuilder clusterId(String clusterId) {
            doSetProperty("clusterId", clusterId);
            return this;
        }
        /**
         * Drill directory in ZooKeeper.
         * 
         * The option is a: <code>java.lang.String</code> type.
         * 
         * Group: producer
         */
        default DrillEndpointBuilder directory(String directory) {
            doSetProperty("directory", directory);
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
        default DrillEndpointBuilder lazyStartProducer(boolean lazyStartProducer) {
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
         * Default: false
         * Group: producer
         */
        default DrillEndpointBuilder lazyStartProducer(String lazyStartProducer) {
            doSetProperty("lazyStartProducer", lazyStartProducer);
            return this;
        }
        /**
         * Connection mode: zk: Zookeeper drillbit: Drillbit direct connection
         * https://drill.apache.org/docs/using-the-jdbc-driver/.
         * 
         * The option is a:
         * <code>org.apache.camel.component.drill.DrillConnectionMode</code>
         * type.
         * 
         * Default: ZK
         * Group: producer
         */
        default DrillEndpointBuilder mode(DrillConnectionMode mode) {
            doSetProperty("mode", mode);
            return this;
        }
        /**
         * Connection mode: zk: Zookeeper drillbit: Drillbit direct connection
         * https://drill.apache.org/docs/using-the-jdbc-driver/.
         * 
         * The option will be converted to a
         * <code>org.apache.camel.component.drill.DrillConnectionMode</code>
         * type.
         * 
         * Default: ZK
         * Group: producer
         */
        default DrillEndpointBuilder mode(String mode) {
            doSetProperty("mode", mode);
            return this;
        }
        /**
         * ZooKeeper port number.
         * 
         * The option is a: <code>java.lang.Integer</code> type.
         * 
         * Group: producer
         */
        default DrillEndpointBuilder port(Integer port) {
            doSetProperty("port", port);
            return this;
        }
        /**
         * ZooKeeper port number.
         * 
         * The option will be converted to a <code>java.lang.Integer</code>
         * type.
         * 
         * Group: producer
         */
        default DrillEndpointBuilder port(String port) {
            doSetProperty("port", port);
            return this;
        }
    }

    /**
     * Advanced builder for endpoint for the Drill component.
     */
    public interface AdvancedDrillEndpointBuilder
            extends
                EndpointProducerBuilder {
        default DrillEndpointBuilder basic() {
            return (DrillEndpointBuilder) this;
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
        default AdvancedDrillEndpointBuilder basicPropertyBinding(
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
         * Default: false
         * Group: advanced
         */
        default AdvancedDrillEndpointBuilder basicPropertyBinding(
                String basicPropertyBinding) {
            doSetProperty("basicPropertyBinding", basicPropertyBinding);
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
        default AdvancedDrillEndpointBuilder synchronous(boolean synchronous) {
            doSetProperty("synchronous", synchronous);
            return this;
        }
        /**
         * Sets whether synchronous processing should be strictly used, or Camel
         * is allowed to use asynchronous processing (if supported).
         * 
         * The option will be converted to a <code>boolean</code> type.
         * 
         * Default: false
         * Group: advanced
         */
        default AdvancedDrillEndpointBuilder synchronous(String synchronous) {
            doSetProperty("synchronous", synchronous);
            return this;
        }
    }

    /**
     * Proxy enum for
     * <code>org.apache.camel.component.drill.DrillConnectionMode</code> enum.
     */
    enum DrillConnectionMode {
        ZK,
        DRILLBIT;
    }
    /**
     * Drill (camel-drill)
     * The drill component gives you the ability to quering into apache drill
     * cluster.
     * 
     * Category: database,sql
     * Since: 2.19
     * Maven coordinates: org.apache.camel:camel-drill
     * 
     * Syntax: <code>drill:host</code>
     * 
     * Path parameter: host (required)
     * ZooKeeper host name or IP address. Use local instead of a host name or IP
     * address to connect to the local Drillbit
     */
    default DrillEndpointBuilder drill(String path) {
        class DrillEndpointBuilderImpl extends AbstractEndpointBuilder implements DrillEndpointBuilder, AdvancedDrillEndpointBuilder {
            public DrillEndpointBuilderImpl(String path) {
                super("drill", path);
            }
        }
        return new DrillEndpointBuilderImpl(path);
    }
}