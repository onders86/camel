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
 * The webhook component allows other Camel components that can receive push
 * notifications to expose webhook endpoints and automatically register them
 * with their own webhook provider.
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@Generated("org.apache.camel.maven.packaging.EndpointDslMojo")
public interface WebhookEndpointBuilderFactory {


    /**
     * Builder for endpoint for the Webhook component.
     */
    public interface WebhookEndpointBuilder extends EndpointConsumerBuilder {
        default AdvancedWebhookEndpointBuilder advanced() {
            return (AdvancedWebhookEndpointBuilder) this;
        }
        /**
         * The delegate uri. Must belong to a component that supports webhooks.
         * The option is a <code>java.lang.String</code> type.
         * @group consumer
         */
        default WebhookEndpointBuilder endpointUri(String endpointUri) {
            setProperty("endpointUri", endpointUri);
            return this;
        }
        /**
         * Automatically register the webhook at startup and unregister it on
         * shutdown.
         * The option is a <code>boolean</code> type.
         * @group common
         */
        default WebhookEndpointBuilder webhookAutoRegister(
                boolean webhookAutoRegister) {
            setProperty("webhookAutoRegister", webhookAutoRegister);
            return this;
        }
        /**
         * Automatically register the webhook at startup and unregister it on
         * shutdown.
         * The option will be converted to a <code>boolean</code> type.
         * @group common
         */
        default WebhookEndpointBuilder webhookAutoRegister(
                String webhookAutoRegister) {
            setProperty("webhookAutoRegister", webhookAutoRegister);
            return this;
        }
        /**
         * The first (base) path element where the webhook will be exposed. It's
         * a good practice to set it to a random string, so that it cannot be
         * guessed by unauthorized parties.
         * The option is a <code>java.lang.String</code> type.
         * @group common
         */
        default WebhookEndpointBuilder webhookBasePath(String webhookBasePath) {
            setProperty("webhookBasePath", webhookBasePath);
            return this;
        }
        /**
         * The Camel Rest component to use for the REST transport, such as
         * netty4-http.
         * The option is a <code>java.lang.String</code> type.
         * @group common
         */
        default WebhookEndpointBuilder webhookComponentName(
                String webhookComponentName) {
            setProperty("webhookComponentName", webhookComponentName);
            return this;
        }
        /**
         * The URL of the current service as seen by the webhook provider.
         * The option is a <code>java.lang.String</code> type.
         * @group common
         */
        default WebhookEndpointBuilder webhookExternalUrl(
                String webhookExternalUrl) {
            setProperty("webhookExternalUrl", webhookExternalUrl);
            return this;
        }
        /**
         * The path where the webhook endpoint will be exposed (relative to
         * basePath, if any).
         * The option is a <code>java.lang.String</code> type.
         * @group common
         */
        default WebhookEndpointBuilder webhookPath(String webhookPath) {
            setProperty("webhookPath", webhookPath);
            return this;
        }
    }

    /**
     * Advanced builder for endpoint for the Webhook component.
     */
    public interface AdvancedWebhookEndpointBuilder
            extends
                EndpointConsumerBuilder {
        default WebhookEndpointBuilder basic() {
            return (WebhookEndpointBuilder) this;
        }
        /**
         * Whether the endpoint should use basic property binding (Camel 2.x) or
         * the newer property binding with additional capabilities.
         * The option is a <code>boolean</code> type.
         * @group advanced
         */
        default AdvancedWebhookEndpointBuilder basicPropertyBinding(
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
        default AdvancedWebhookEndpointBuilder basicPropertyBinding(
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
        default AdvancedWebhookEndpointBuilder synchronous(boolean synchronous) {
            setProperty("synchronous", synchronous);
            return this;
        }
        /**
         * Sets whether synchronous processing should be strictly used, or Camel
         * is allowed to use asynchronous processing (if supported).
         * The option will be converted to a <code>boolean</code> type.
         * @group advanced
         */
        default AdvancedWebhookEndpointBuilder synchronous(String synchronous) {
            setProperty("synchronous", synchronous);
            return this;
        }
    }
    /**
     * The webhook component allows other Camel components that can receive push
     * notifications to expose webhook endpoints and automatically register them
     * with their own webhook provider. Creates a builder to build endpoints for
     * the Webhook component.
     */
    default WebhookEndpointBuilder webhook(String path) {
        class WebhookEndpointBuilderImpl extends AbstractEndpointBuilder implements WebhookEndpointBuilder, AdvancedWebhookEndpointBuilder {
            public WebhookEndpointBuilderImpl(String path) {
                super("webhook", path);
            }
        }
        return new WebhookEndpointBuilderImpl(path);
    }
}