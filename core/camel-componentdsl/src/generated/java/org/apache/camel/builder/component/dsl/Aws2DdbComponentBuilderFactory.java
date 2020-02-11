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
package org.apache.camel.builder.component.dsl;

import javax.annotation.Generated;
import org.apache.camel.Component;
import org.apache.camel.builder.component.AbstractComponentBuilder;
import org.apache.camel.builder.component.ComponentBuilder;
import org.apache.camel.component.aws2.ddb.Ddb2Component;

/**
 * The aws-ddb component is used for storing and retrieving data from Amazon's
 * DynamoDB service.
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@Generated("org.apache.camel.maven.packaging.ComponentDslMojo")
public interface Aws2DdbComponentBuilderFactory {

    /**
     * AWS 2 DynamoDB (camel-aws2-ddb)
     * The aws-ddb component is used for storing and retrieving data from
     * Amazon's DynamoDB service.
     * 
     * Category: cloud,database,nosql
     * Since: 3.1
     * Maven coordinates: org.apache.camel:camel-aws2-ddb
     */
    static Aws2DdbComponentBuilder aws2Ddb() {
        return new Aws2DdbComponentBuilderImpl();
    }

    /**
     * Builder for the AWS 2 DynamoDB component.
     */
    interface Aws2DdbComponentBuilder extends ComponentBuilder<Ddb2Component> {
        /**
         * Amazon AWS Access Key.
         * 
         * The option is a: <code>java.lang.String</code> type.
         * 
         * Group: producer
         */
        default Aws2DdbComponentBuilder accessKey(java.lang.String accessKey) {
            doSetProperty("accessKey", accessKey);
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
        default Aws2DdbComponentBuilder lazyStartProducer(
                boolean lazyStartProducer) {
            doSetProperty("lazyStartProducer", lazyStartProducer);
            return this;
        }
        /**
         * The region in which DDB client needs to work.
         * 
         * The option is a: <code>java.lang.String</code> type.
         * 
         * Group: producer
         */
        default Aws2DdbComponentBuilder region(java.lang.String region) {
            doSetProperty("region", region);
            return this;
        }
        /**
         * Amazon AWS Secret Key.
         * 
         * The option is a: <code>java.lang.String</code> type.
         * 
         * Group: producer
         */
        default Aws2DdbComponentBuilder secretKey(java.lang.String secretKey) {
            doSetProperty("secretKey", secretKey);
            return this;
        }
        /**
         * Whether the component should use basic property binding (Camel 2.x)
         * or the newer property binding with additional capabilities.
         * 
         * The option is a: <code>boolean</code> type.
         * 
         * Default: false
         * Group: advanced
         */
        default Aws2DdbComponentBuilder basicPropertyBinding(
                boolean basicPropertyBinding) {
            doSetProperty("basicPropertyBinding", basicPropertyBinding);
            return this;
        }
        /**
         * The AWS DDB default configuration.
         * 
         * The option is a:
         * <code>org.apache.camel.component.aws2.ddb.Ddb2Configuration</code>
         * type.
         * 
         * Group: advanced
         */
        default Aws2DdbComponentBuilder configuration(
                org.apache.camel.component.aws2.ddb.Ddb2Configuration configuration) {
            doSetProperty("configuration", configuration);
            return this;
        }
    }

    class Aws2DdbComponentBuilderImpl
            extends
                AbstractComponentBuilder<Ddb2Component>
            implements
                Aws2DdbComponentBuilder {
        @Override
        protected Ddb2Component buildConcreteComponent() {
            return new Ddb2Component();
        }
        @Override
        protected boolean setPropertyOnComponent(
                Component component,
                String name,
                Object value) {
            switch (name) {
            case "accessKey": ((Ddb2Component) component).setAccessKey((java.lang.String) value); return true;
            case "lazyStartProducer": ((Ddb2Component) component).setLazyStartProducer((boolean) value); return true;
            case "region": ((Ddb2Component) component).setRegion((java.lang.String) value); return true;
            case "secretKey": ((Ddb2Component) component).setSecretKey((java.lang.String) value); return true;
            case "basicPropertyBinding": ((Ddb2Component) component).setBasicPropertyBinding((boolean) value); return true;
            case "configuration": ((Ddb2Component) component).setConfiguration((org.apache.camel.component.aws2.ddb.Ddb2Configuration) value); return true;
            default: return false;
            }
        }
    }
}