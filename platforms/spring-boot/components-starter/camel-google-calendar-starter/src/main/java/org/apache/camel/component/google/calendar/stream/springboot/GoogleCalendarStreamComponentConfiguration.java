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
package org.apache.camel.component.google.calendar.stream.springboot;

import java.util.List;
import javax.annotation.Generated;
import org.apache.camel.spring.boot.ComponentConfigurationPropertiesCommon;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * The google-mail component provides access to Google Mail.
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@Generated("org.apache.camel.maven.packaging.SpringBootAutoConfigurationMojo")
@ConfigurationProperties(prefix = "camel.component.google-calendar-stream")
public class GoogleCalendarStreamComponentConfiguration
        extends
            ComponentConfigurationPropertiesCommon {

    /**
     * Whether to enable auto configuration of the google-calendar-stream
     * component. This is enabled by default.
     */
    private Boolean enabled;
    /**
     * The configuration
     */
    private GoogleCalendarStreamConfigurationNestedConfiguration configuration;
    /**
     * The client Factory. The option is a
     * org.apache.camel.component.google.calendar.GoogleCalendarClientFactory
     * type.
     */
    private String clientFactory;
    /**
     * Whether the component should resolve property placeholders on itself when
     * starting. Only properties which are of String type can use property
     * placeholders.
     */
    private Boolean resolvePropertyPlaceholders = true;

    public GoogleCalendarStreamConfigurationNestedConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(
            GoogleCalendarStreamConfigurationNestedConfiguration configuration) {
        this.configuration = configuration;
    }

    public String getClientFactory() {
        return clientFactory;
    }

    public void setClientFactory(String clientFactory) {
        this.clientFactory = clientFactory;
    }

    public Boolean getResolvePropertyPlaceholders() {
        return resolvePropertyPlaceholders;
    }

    public void setResolvePropertyPlaceholders(
            Boolean resolvePropertyPlaceholders) {
        this.resolvePropertyPlaceholders = resolvePropertyPlaceholders;
    }

    public static class GoogleCalendarStreamConfigurationNestedConfiguration {
        public static final Class CAMEL_NESTED_CLASS = org.apache.camel.component.google.calendar.stream.GoogleCalendarStreamConfiguration.class;
        /**
         * Client ID of the mail application
         */
        private String clientId;
        /**
         * Client secret of the mail application
         */
        private String clientSecret;
        /**
         * OAuth 2 access token. This typically expires after an hour so
         * refreshToken is recommended for long term usage.
         */
        private String accessToken;
        /**
         * OAuth 2 refresh token. Using this, the Google Calendar component can
         * obtain a new accessToken whenever the current one expires - a
         * necessity if the application is long-lived.
         */
        private String refreshToken;
        /**
         * Google mail application name. Example would be camel-google-mail/1.0
         */
        private String applicationName;
        /**
         * Specifies the level of permissions you want a mail application to
         * have to a user account. See
         * https://developers.google.com/gmail/api/auth/scopes for more info.
         */
        private List scopes;
        /**
         * Specifies an index for the endpoint
         */
        private String index;
        /**
         * The query to execute on gmail box
         */
        private String query;
        /**
         * Max results to be returned
         */
        private Integer maxResults = 10;

        public String getClientId() {
            return clientId;
        }

        public void setClientId(String clientId) {
            this.clientId = clientId;
        }

        public String getClientSecret() {
            return clientSecret;
        }

        public void setClientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public String getRefreshToken() {
            return refreshToken;
        }

        public void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }

        public String getApplicationName() {
            return applicationName;
        }

        public void setApplicationName(String applicationName) {
            this.applicationName = applicationName;
        }

        public List getScopes() {
            return scopes;
        }

        public void setScopes(List scopes) {
            this.scopes = scopes;
        }

        public String getIndex() {
            return index;
        }

        public void setIndex(String index) {
            this.index = index;
        }

        public String getQuery() {
            return query;
        }

        public void setQuery(String query) {
            this.query = query;
        }

        public Integer getMaxResults() {
            return maxResults;
        }

        public void setMaxResults(Integer maxResults) {
            this.maxResults = maxResults;
        }
    }
}