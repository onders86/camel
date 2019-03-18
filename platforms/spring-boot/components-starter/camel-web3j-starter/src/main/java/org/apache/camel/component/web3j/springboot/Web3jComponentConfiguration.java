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
package org.apache.camel.component.web3j.springboot;

import java.math.BigInteger;
import java.util.List;
import javax.annotation.Generated;
import org.apache.camel.spring.boot.ComponentConfigurationPropertiesCommon;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.web3j.protocol.Web3j;

/**
 * The web3j component uses the Web3j client API and allows you to add/read
 * nodes to/from a web3j compliant content repositories.
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@Generated("org.apache.camel.maven.packaging.SpringBootAutoConfigurationMojo")
@ConfigurationProperties(prefix = "camel.component.web3j")
public class Web3jComponentConfiguration
        extends
            ComponentConfigurationPropertiesCommon {

    /**
     * Whether to enable auto configuration of the web3j component. This is
     * enabled by default.
     */
    private Boolean enabled;
    /**
     * Default configuration
     */
    private Web3jConfigurationNestedConfiguration configuration;
    /**
     * Whether the component should resolve property placeholders on itself when
     * starting. Only properties which are of String type can use property
     * placeholders.
     */
    private Boolean resolvePropertyPlaceholders = true;

    public Web3jConfigurationNestedConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(
            Web3jConfigurationNestedConfiguration configuration) {
        this.configuration = configuration;
    }

    public Boolean getResolvePropertyPlaceholders() {
        return resolvePropertyPlaceholders;
    }

    public void setResolvePropertyPlaceholders(
            Boolean resolvePropertyPlaceholders) {
        this.resolvePropertyPlaceholders = resolvePropertyPlaceholders;
    }

    public static class Web3jConfigurationNestedConfiguration {
        public static final Class CAMEL_NESTED_CLASS = org.apache.camel.component.web3j.Web3jConfiguration.class;
        /**
         * A transaction privateFor nodes with public keys in a Quorum network
         */
        private List privateFor;
        /**
         * If true, this will support Quorum API.
         */
        private Boolean quorumAPI = false;
        /**
         * The preconfigured Web3j object.
         */
        private Web3j web3j;
        /**
         * The priority of a whisper message.
         */
        private BigInteger priority;
        /**
         * The time to live in seconds of a whisper message.
         */
        private BigInteger ttl;
        /**
         * Gas price used for each paid gas.
         */
        private BigInteger gasPrice;
        /**
         * The maximum gas allowed in this block.
         */
        private BigInteger gasLimit;
        /**
         * The value sent within a transaction.
         */
        private BigInteger value;
        /**
         * The compiled code of a contract OR the hash of the invoked method
         * signature and encoded parameters.
         */
        private String data;
        /**
         * The address the transaction is send from
         */
        private String fromAddress;
        /**
         * The address the transaction is directed to.
         */
        private String toAddress;
        /**
         * A random hexadecimal(32 bytes) ID identifying the client.
         */
        private String clientId;
        /**
         * A hexadecimal string representation (32 bytes) of the hash rate.
         */
        private String hashrate;
        /**
         * The mix digest (256 bits) used for submitting a proof-of-work
         * solution.
         */
        private String mixDigest;
        /**
         * The header's pow-hash (256 bits) used for submitting a proof-of-work
         * solution.
         */
        private String headerPowHash;
        /**
         * The nonce found (64 bits) used for submitting a proof-of-work
         * solution.
         */
        private String nonce;
        /**
         * The source code to compile.
         */
        private String sourceCode;
        /**
         * The information about a transaction requested by transaction hash.
         */
        private String transactionHash;
        /**
         * The local database name.
         */
        private String databaseName;
        /**
         * The key name in the database.
         */
        private String keyName;
        /**
         * The filter id to use.
         */
        private BigInteger filterId;
        /**
         * The transactions/uncle index position in the block.
         */
        private BigInteger index;
        /**
         * The signed transaction data for a new message call transaction or a
         * contract creation for signed transactions.
         */
        private String signedTransactionData;
        /**
         * Hash of the block where this transaction was in.
         */
        private String blockHash;
        /**
         * Message to sign by calculating an Ethereum specific signature.
         */
        private String sha3HashOfDataToSign;
        /**
         * The transaction index position withing a block.
         */
        private BigInteger position;
        /**
         * The block number, or the string "latest" for the last mined block or
         * "pending", "earliest" for not yet mined transactions.
         */
        private String fromBlock = "latest";
        /**
         * The block number, or the string "latest" for the last mined block or
         * "pending", "earliest" for not yet mined transactions.
         */
        private String toBlock = "latest";
        /**
         * The block number, or the string "latest" for the last mined block or
         * "pending", "earliest" for not yet mined transactions.
         */
        private String atBlock = "latest";
        /**
         * Contract address or a list of addresses.
         */
        private List addresses;
        /**
         * Topics are order-dependent. Each topic can also be a list of topics.
         * Specify multiple topics separated by comma.
         */
        private List topics;
        /**
         * Contract address.
         */
        private String address;
        /**
         * If true it returns the full transaction objects, if false only the
         * hashes of the transactions.
         */
        private Boolean fullTransactionObjects = false;
        /**
         * Operation to use.
         */
        private String operation = "transaction";

        public List getPrivateFor() {
            return privateFor;
        }

        public void setPrivateFor(List privateFor) {
            this.privateFor = privateFor;
        }

        public Boolean getQuorumAPI() {
            return quorumAPI;
        }

        public void setQuorumAPI(Boolean quorumAPI) {
            this.quorumAPI = quorumAPI;
        }

        public Web3j getWeb3j() {
            return web3j;
        }

        public void setWeb3j(Web3j web3j) {
            this.web3j = web3j;
        }

        public BigInteger getPriority() {
            return priority;
        }

        public void setPriority(BigInteger priority) {
            this.priority = priority;
        }

        public BigInteger getTtl() {
            return ttl;
        }

        public void setTtl(BigInteger ttl) {
            this.ttl = ttl;
        }

        public BigInteger getGasPrice() {
            return gasPrice;
        }

        public void setGasPrice(BigInteger gasPrice) {
            this.gasPrice = gasPrice;
        }

        public BigInteger getGasLimit() {
            return gasLimit;
        }

        public void setGasLimit(BigInteger gasLimit) {
            this.gasLimit = gasLimit;
        }

        public BigInteger getValue() {
            return value;
        }

        public void setValue(BigInteger value) {
            this.value = value;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String getFromAddress() {
            return fromAddress;
        }

        public void setFromAddress(String fromAddress) {
            this.fromAddress = fromAddress;
        }

        public String getToAddress() {
            return toAddress;
        }

        public void setToAddress(String toAddress) {
            this.toAddress = toAddress;
        }

        public String getClientId() {
            return clientId;
        }

        public void setClientId(String clientId) {
            this.clientId = clientId;
        }

        public String getHashrate() {
            return hashrate;
        }

        public void setHashrate(String hashrate) {
            this.hashrate = hashrate;
        }

        public String getMixDigest() {
            return mixDigest;
        }

        public void setMixDigest(String mixDigest) {
            this.mixDigest = mixDigest;
        }

        public String getHeaderPowHash() {
            return headerPowHash;
        }

        public void setHeaderPowHash(String headerPowHash) {
            this.headerPowHash = headerPowHash;
        }

        public String getNonce() {
            return nonce;
        }

        public void setNonce(String nonce) {
            this.nonce = nonce;
        }

        public String getSourceCode() {
            return sourceCode;
        }

        public void setSourceCode(String sourceCode) {
            this.sourceCode = sourceCode;
        }

        public String getTransactionHash() {
            return transactionHash;
        }

        public void setTransactionHash(String transactionHash) {
            this.transactionHash = transactionHash;
        }

        public String getDatabaseName() {
            return databaseName;
        }

        public void setDatabaseName(String databaseName) {
            this.databaseName = databaseName;
        }

        public String getKeyName() {
            return keyName;
        }

        public void setKeyName(String keyName) {
            this.keyName = keyName;
        }

        public BigInteger getFilterId() {
            return filterId;
        }

        public void setFilterId(BigInteger filterId) {
            this.filterId = filterId;
        }

        public BigInteger getIndex() {
            return index;
        }

        public void setIndex(BigInteger index) {
            this.index = index;
        }

        public String getSignedTransactionData() {
            return signedTransactionData;
        }

        public void setSignedTransactionData(String signedTransactionData) {
            this.signedTransactionData = signedTransactionData;
        }

        public String getBlockHash() {
            return blockHash;
        }

        public void setBlockHash(String blockHash) {
            this.blockHash = blockHash;
        }

        public String getSha3HashOfDataToSign() {
            return sha3HashOfDataToSign;
        }

        public void setSha3HashOfDataToSign(String sha3HashOfDataToSign) {
            this.sha3HashOfDataToSign = sha3HashOfDataToSign;
        }

        public BigInteger getPosition() {
            return position;
        }

        public void setPosition(BigInteger position) {
            this.position = position;
        }

        public String getFromBlock() {
            return fromBlock;
        }

        public void setFromBlock(String fromBlock) {
            this.fromBlock = fromBlock;
        }

        public String getToBlock() {
            return toBlock;
        }

        public void setToBlock(String toBlock) {
            this.toBlock = toBlock;
        }

        public String getAtBlock() {
            return atBlock;
        }

        public void setAtBlock(String atBlock) {
            this.atBlock = atBlock;
        }

        public List getAddresses() {
            return addresses;
        }

        public void setAddresses(List addresses) {
            this.addresses = addresses;
        }

        public List getTopics() {
            return topics;
        }

        public void setTopics(List topics) {
            this.topics = topics;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public Boolean getFullTransactionObjects() {
            return fullTransactionObjects;
        }

        public void setFullTransactionObjects(Boolean fullTransactionObjects) {
            this.fullTransactionObjects = fullTransactionObjects;
        }

        public String getOperation() {
            return operation;
        }

        public void setOperation(String operation) {
            this.operation = operation;
        }
    }
}