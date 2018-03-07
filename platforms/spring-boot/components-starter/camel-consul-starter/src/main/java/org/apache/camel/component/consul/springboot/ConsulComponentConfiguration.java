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
package org.apache.camel.component.consul.springboot;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import com.orbitz.consul.option.ConsistencyMode;
import org.apache.camel.spring.boot.ComponentConfigurationPropertiesCommon;
import org.apache.camel.util.jsse.SSLContextParameters;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.DeprecatedConfigurationProperty;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * The camel consul component allows you to work with Consul a distributed
 * highly available datacenter-aware service discovery and configuration system.
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@Generated("org.apache.camel.maven.packaging.SpringBootAutoConfigurationMojo")
@ConfigurationProperties(prefix = "camel.component.consul")
public class ConsulComponentConfiguration
        extends
            ComponentConfigurationPropertiesCommon {

    /**
     * The Consul agent URL
     */
    private String url;
    /**
     * The data center
     */
    private String datacenter;
    /**
     * SSL configuration using an
     * org.apache.camel.util.jsse.SSLContextParameters instance.
     */
    @NestedConfigurationProperty
    private SSLContextParameters sslContextParameters;
    /**
     * Enable usage of global SSL context parameters.
     */
    private Boolean useGlobalSslContextParameters = false;
    /**
     * Sets the ACL token to be used with Consul
     */
    private String aclToken;
    /**
     * Sets the username to be used for basic authentication
     */
    private String userName;
    /**
     * Sets the password to be used for basic authentication
     */
    private String password;
    /**
     * Sets the common configuration shared among endpoints
     */
    private ConsulConfigurationNestedConfiguration configuration;
    /**
     * Whether the component should resolve property placeholders on itself when
     * starting. Only properties which are of String type can use property
     * placeholders.
     */
    private Boolean resolvePropertyPlaceholders = true;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDatacenter() {
        return datacenter;
    }

    public void setDatacenter(String datacenter) {
        this.datacenter = datacenter;
    }

    public SSLContextParameters getSslContextParameters() {
        return sslContextParameters;
    }

    public void setSslContextParameters(
            SSLContextParameters sslContextParameters) {
        this.sslContextParameters = sslContextParameters;
    }

    public Boolean getUseGlobalSslContextParameters() {
        return useGlobalSslContextParameters;
    }

    public void setUseGlobalSslContextParameters(
            Boolean useGlobalSslContextParameters) {
        this.useGlobalSslContextParameters = useGlobalSslContextParameters;
    }

    public String getAclToken() {
        return aclToken;
    }

    public void setAclToken(String aclToken) {
        this.aclToken = aclToken;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ConsulConfigurationNestedConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(
            ConsulConfigurationNestedConfiguration configuration) {
        this.configuration = configuration;
    }

    public Boolean getResolvePropertyPlaceholders() {
        return resolvePropertyPlaceholders;
    }

    public void setResolvePropertyPlaceholders(
            Boolean resolvePropertyPlaceholders) {
        this.resolvePropertyPlaceholders = resolvePropertyPlaceholders;
    }

    public static class ConsulConfigurationNestedConfiguration {
        public static final Class CAMEL_NESTED_CLASS = org.apache.camel.component.consul.ConsulConfiguration.class;
        /**
         * The default action. Can be overridden by CamelConsulAction
         */
        private String action;
        /**
         * Default to transform values retrieved from Consul i.e. on KV endpoint
         * to string.
         */
        private Boolean valueAsString;
        /**
         * The default key. Can be overridden by CamelConsulKey
         */
        private String key;
        /**
         * The Consul agent URL
         */
        private String url;
        /**
         * The data center
         * 
         * @deprecated replaced by {@link #setDatacenter(String)} ()}
         */
        @Deprecated
        private String dc;
        /**
         * The data center
         */
        private String datacenter;
        /**
         * The near node to use for queries.
         */
        private String nearNode;
        /**
         * The note meta-data to use for queries.
         */
        private List nodeMeta;
        /**
         * The consistencyMode used for queries, default ConsistencyMode.DEFAULT
         */
        private ConsistencyMode consistencyMode;
        /**
         * Set tags. You can separate multiple tags by comma.
         */
        private Set tags;
        /**
         * SSL configuration using an
         * org.apache.camel.util.jsse.SSLContextParameters instance.
         */
        @NestedConfigurationProperty
        private SSLContextParameters sslContextParameters;
        /**
         * Sets the ACL token to be used with Consul
         */
        private String aclToken;
        /**
         * Sets the username to be used for basic authentication
         */
        private String userName;
        /**
         * Sets the password to be used for basic authentication
         */
        private String password;
        /**
         * Connect timeout for OkHttpClient
         */
        private Long connectTimeoutMillis;
        /**
         * Read timeout for OkHttpClient
         */
        private Long readTimeoutMillis;
        /**
         * Write timeout for OkHttpClient
         */
        private Long writeTimeoutMillis;
        /**
         * Configure if the AgentClient should attempt a ping before returning
         * the Consul instance
         */
        private Boolean pingInstance;
        /**
         * The second to wait for a watch event, default 10 seconds
         */
        private Integer blockSeconds;
        /**
         * The first index for watch for, default 0
         */
        private BigInteger firstIndex;
        /**
         * Recursively watch, default false
         */
        private Boolean recursive;

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public Boolean getValueAsString() {
            return valueAsString;
        }

        public void setValueAsString(Boolean valueAsString) {
            this.valueAsString = valueAsString;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Deprecated
        @DeprecatedConfigurationProperty
        public String getDc() {
            return dc;
        }

        @Deprecated
        public void setDc(String dc) {
            this.dc = dc;
        }

        public String getDatacenter() {
            return datacenter;
        }

        public void setDatacenter(String datacenter) {
            this.datacenter = datacenter;
        }

        public String getNearNode() {
            return nearNode;
        }

        public void setNearNode(String nearNode) {
            this.nearNode = nearNode;
        }

        public List getNodeMeta() {
            return nodeMeta;
        }

        public void setNodeMeta(List nodeMeta) {
            this.nodeMeta = nodeMeta;
        }

        public ConsistencyMode getConsistencyMode() {
            return consistencyMode;
        }

        public void setConsistencyMode(ConsistencyMode consistencyMode) {
            this.consistencyMode = consistencyMode;
        }

        public Set getTags() {
            return tags;
        }

        public void setTags(Set tags) {
            this.tags = tags;
        }

        public SSLContextParameters getSslContextParameters() {
            return sslContextParameters;
        }

        public void setSslContextParameters(
                SSLContextParameters sslContextParameters) {
            this.sslContextParameters = sslContextParameters;
        }

        public String getAclToken() {
            return aclToken;
        }

        public void setAclToken(String aclToken) {
            this.aclToken = aclToken;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Long getConnectTimeoutMillis() {
            return connectTimeoutMillis;
        }

        public void setConnectTimeoutMillis(Long connectTimeoutMillis) {
            this.connectTimeoutMillis = connectTimeoutMillis;
        }

        public Long getReadTimeoutMillis() {
            return readTimeoutMillis;
        }

        public void setReadTimeoutMillis(Long readTimeoutMillis) {
            this.readTimeoutMillis = readTimeoutMillis;
        }

        public Long getWriteTimeoutMillis() {
            return writeTimeoutMillis;
        }

        public void setWriteTimeoutMillis(Long writeTimeoutMillis) {
            this.writeTimeoutMillis = writeTimeoutMillis;
        }

        public Boolean getPingInstance() {
            return pingInstance;
        }

        public void setPingInstance(Boolean pingInstance) {
            this.pingInstance = pingInstance;
        }

        public Integer getBlockSeconds() {
            return blockSeconds;
        }

        public void setBlockSeconds(Integer blockSeconds) {
            this.blockSeconds = blockSeconds;
        }

        public BigInteger getFirstIndex() {
            return firstIndex;
        }

        public void setFirstIndex(BigInteger firstIndex) {
            this.firstIndex = firstIndex;
        }

        public Boolean getRecursive() {
            return recursive;
        }

        public void setRecursive(Boolean recursive) {
            this.recursive = recursive;
        }
    }
}