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
import org.apache.camel.component.yammer.YammerComponent;

/**
 * The yammer component allows you to interact with the Yammer enterprise social
 * network.
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@Generated("org.apache.camel.maven.packaging.ComponentDslMojo")
public interface YammerComponentBuilderFactory {

    /**
     * Yammer (camel-yammer)
     * The yammer component allows you to interact with the Yammer enterprise
     * social network.
     * 
     * Category: social
     * Since: 2.12
     * Maven coordinates: org.apache.camel:camel-yammer
     */
    static YammerComponentBuilder yammer() {
        return new YammerComponentBuilderImpl();
    }

    /**
     * Builder for the Yammer component.
     */
    interface YammerComponentBuilder
            extends
                ComponentBuilder<YammerComponent> {
        /**
         * Set to true if you want to use raw JSON rather than converting to
         * POJOs.
         * 
         * The option is a: <code>boolean</code> type.
         * 
         * Default: false
         * Group: common
         */
        default YammerComponentBuilder useJson(boolean useJson) {
            doSetProperty("useJson", useJson);
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
        default YammerComponentBuilder bridgeErrorHandler(
                boolean bridgeErrorHandler) {
            doSetProperty("bridgeErrorHandler", bridgeErrorHandler);
            return this;
        }
        /**
         * Delay between polling in millis.
         * 
         * The option is a: <code>long</code> type.
         * 
         * Default: 5000
         * Group: consumer
         */
        default YammerComponentBuilder delay(long delay) {
            doSetProperty("delay", delay);
            return this;
        }
        /**
         * Return only the specified number of messages. Works for threaded set
         * to true and threaded set to extended.
         * 
         * The option is a: <code>int</code> type.
         * 
         * Default: -1
         * Group: consumer
         */
        default YammerComponentBuilder limit(int limit) {
            doSetProperty("limit", limit);
            return this;
        }
        /**
         * Returns messages newer than the message ID specified as a numeric
         * string. This should be used when polling for new messages. If you're
         * looking at messages, and the most recent message returned is 3516,
         * you can make a request with the parameter newerThan equals to 3516 to
         * ensure that you do not get duplicate copies of messages already on
         * your page.
         * 
         * The option is a: <code>long</code> type.
         * 
         * Default: -1
         * Group: consumer
         */
        default YammerComponentBuilder newerThan(long newerThan) {
            doSetProperty("newerThan", newerThan);
            return this;
        }
        /**
         * Returns messages older than the message ID specified as a numeric
         * string. This is useful for paginating messages. For example, if
         * you're currently viewing 20 messages and the oldest is number 2912,
         * you could append olderThan equals to 2912 to your request to get the
         * 20 messages prior to those you're seeing.
         * 
         * The option is a: <code>long</code> type.
         * 
         * Default: -1
         * Group: consumer
         */
        default YammerComponentBuilder olderThan(long olderThan) {
            doSetProperty("olderThan", olderThan);
            return this;
        }
        /**
         * threaded equals to true will only return the first message in each
         * thread. This parameter is intended for apps which display message
         * threads collapsed. threaded equals to extended will return the thread
         * starter messages in order of most recently active as well as the two
         * most recent messages, as they are viewed in the default view on the
         * Yammer web interface.
         * 
         * The option is a: <code>java.lang.String</code> type.
         * 
         * Group: consumer
         */
        default YammerComponentBuilder threaded(java.lang.String threaded) {
            doSetProperty("threaded", threaded);
            return this;
        }
        /**
         * The user id.
         * 
         * The option is a: <code>java.lang.String</code> type.
         * 
         * Group: consumer
         */
        default YammerComponentBuilder userId(java.lang.String userId) {
            doSetProperty("userId", userId);
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
        default YammerComponentBuilder lazyStartProducer(
                boolean lazyStartProducer) {
            doSetProperty("lazyStartProducer", lazyStartProducer);
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
        default YammerComponentBuilder basicPropertyBinding(
                boolean basicPropertyBinding) {
            doSetProperty("basicPropertyBinding", basicPropertyBinding);
            return this;
        }
        /**
         * Component configuration.
         * 
         * The option is a:
         * <code>org.apache.camel.component.yammer.YammerConfiguration</code>
         * type.
         * 
         * Group: advanced
         */
        default YammerComponentBuilder configuration(
                org.apache.camel.component.yammer.YammerConfiguration configuration) {
            doSetProperty("configuration", configuration);
            return this;
        }
        /**
         * To use a specific requester to communicate with Yammer.
         * 
         * The option is a:
         * <code>org.apache.camel.component.yammer.ApiRequestor</code> type.
         * 
         * Group: advanced
         */
        default YammerComponentBuilder requestor(
                org.apache.camel.component.yammer.ApiRequestor requestor) {
            doSetProperty("requestor", requestor);
            return this;
        }
        /**
         * The access token.
         * 
         * The option is a: <code>java.lang.String</code> type.
         * 
         * Group: security
         */
        default YammerComponentBuilder accessToken(java.lang.String accessToken) {
            doSetProperty("accessToken", accessToken);
            return this;
        }
        /**
         * The consumer key.
         * 
         * The option is a: <code>java.lang.String</code> type.
         * 
         * Group: security
         */
        default YammerComponentBuilder consumerKey(java.lang.String consumerKey) {
            doSetProperty("consumerKey", consumerKey);
            return this;
        }
        /**
         * The consumer secret.
         * 
         * The option is a: <code>java.lang.String</code> type.
         * 
         * Group: security
         */
        default YammerComponentBuilder consumerSecret(
                java.lang.String consumerSecret) {
            doSetProperty("consumerSecret", consumerSecret);
            return this;
        }
    }

    class YammerComponentBuilderImpl
            extends
                AbstractComponentBuilder<YammerComponent>
            implements
                YammerComponentBuilder {
        @Override
        protected YammerComponent buildConcreteComponent() {
            return new YammerComponent();
        }
        private org.apache.camel.component.yammer.YammerConfiguration getOrCreateConfiguration(
                org.apache.camel.component.yammer.YammerComponent component) {
            if (component.getConfiguration() == null) {
                component.setConfiguration(new org.apache.camel.component.yammer.YammerConfiguration());
            }
            return component.getConfiguration();
        }
        @Override
        protected boolean setPropertyOnComponent(
                Component component,
                String name,
                Object value) {
            switch (name) {
            case "useJson": getOrCreateConfiguration((YammerComponent) component).setUseJson((boolean) value); return true;
            case "bridgeErrorHandler": ((YammerComponent) component).setBridgeErrorHandler((boolean) value); return true;
            case "delay": getOrCreateConfiguration((YammerComponent) component).setDelay((long) value); return true;
            case "limit": getOrCreateConfiguration((YammerComponent) component).setLimit((int) value); return true;
            case "newerThan": getOrCreateConfiguration((YammerComponent) component).setNewerThan((long) value); return true;
            case "olderThan": getOrCreateConfiguration((YammerComponent) component).setOlderThan((long) value); return true;
            case "threaded": getOrCreateConfiguration((YammerComponent) component).setThreaded((java.lang.String) value); return true;
            case "userId": getOrCreateConfiguration((YammerComponent) component).setUserId((java.lang.String) value); return true;
            case "lazyStartProducer": ((YammerComponent) component).setLazyStartProducer((boolean) value); return true;
            case "basicPropertyBinding": ((YammerComponent) component).setBasicPropertyBinding((boolean) value); return true;
            case "configuration": ((YammerComponent) component).setConfiguration((org.apache.camel.component.yammer.YammerConfiguration) value); return true;
            case "requestor": getOrCreateConfiguration((YammerComponent) component).setRequestor((org.apache.camel.component.yammer.ApiRequestor) value); return true;
            case "accessToken": getOrCreateConfiguration((YammerComponent) component).setAccessToken((java.lang.String) value); return true;
            case "consumerKey": getOrCreateConfiguration((YammerComponent) component).setConsumerKey((java.lang.String) value); return true;
            case "consumerSecret": getOrCreateConfiguration((YammerComponent) component).setConsumerSecret((java.lang.String) value); return true;
            default: return false;
            }
        }
    }
}