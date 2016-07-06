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
package org.apache.camel.dataformat.xmlsecurity.springboot;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Camel Partial XML Encryption/Decryption and XML Signature support
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@ConfigurationProperties(prefix = "camel.dataformat.securexml")
public class XMLSecurityDataFormatConfiguration {

    /**
     * The cipher algorithm to be used for encryption/decryption of the XML
     * message content. The available choices are: XMLCipher.TRIPLEDES
     * XMLCipher.AES_128 XMLCipher.AES_128_GCM XMLCipher.AES_192
     * XMLCipher.AES_192_GCM XMLCipher.AES_256 XMLCipher.AES_256_GCM
     * XMLCipher.SEED_128 XMLCipher.CAMELLIA_128 XMLCipher.CAMELLIA_192
     * XMLCipher.CAMELLIA_256 The default value is MLCipher.TRIPLEDES
     */
    private String xmlCipherAlgorithm;
    /**
     * A String used as passPhrase to encrypt/decrypt content. The passPhrase
     * has to be provided. If no passPhrase is specified a default passPhrase is
     * used. The passPhrase needs to be put together in conjunction with the
     * appropriate encryption algorithm. For example using TRIPLEDES the
     * passPhase can be a Only another 24 Byte key
     */
    private String passPhrase;
    /**
     * The XPath reference to the XML Element selected for
     * encryption/decryption. If no tag is specified the entire payload is
     * encrypted/decrypted.
     */
    private String secureTag;
    /**
     * A boolean value to specify whether the XML Element is to be encrypted or
     * the contents of the XML Element false = Element Level true = Element
     * Content Level
     */
    private Boolean secureTagContents = false;
    /**
     * The cipher algorithm to be used for encryption/decryption of the
     * asymmetric key. The available choices are: XMLCipher.RSA_v1dot5
     * XMLCipher.RSA_OAEP XMLCipher.RSA_OAEP_11 The default value is
     * XMLCipher.RSA_OAEP
     */
    private String keyCipherAlgorithm;
    /**
     * The key alias to be used when retrieving the recipient's public or
     * private key from a KeyStore when performing asymmetric key encryption or
     * decryption.
     */
    private String recipientKeyAlias;
    /**
     * Refers to a KeyStore instance to lookup in the registry which is used for
     * configuration options for creating and loading a KeyStore instance that
     * represents the sender's trustStore or recipient's keyStore.
     */
    private String keyOrTrustStoreParametersId;
    /**
     * The password to be used for retrieving the private key from the KeyStore.
     * This key is used for asymmetric decryption.
     */
    private String keyPassword;
    /**
     * The digest algorithm to use with the RSA OAEP algorithm. The available
     * choices are: XMLCipher.SHA1 XMLCipher.SHA256 XMLCipher.SHA512 The default
     * value is XMLCipher.SHA1
     */
    private String digestAlgorithm;
    /**
     * The MGF Algorithm to use with the RSA OAEP algorithm. The available
     * choices are: EncryptionConstants.MGF1_SHA1
     * EncryptionConstants.MGF1_SHA256 EncryptionConstants.MGF1_SHA512 The
     * default value is EncryptionConstants.MGF1_SHA1
     */
    private String mgfAlgorithm;
    /**
     * Whether to add the public key used to encrypt the session key as a
     * KeyValue in the EncryptedKey structure or not.
     */
    private Boolean addKeyValueForEncryptedKey = true;

    public String getXmlCipherAlgorithm() {
        return xmlCipherAlgorithm;
    }

    public void setXmlCipherAlgorithm(String xmlCipherAlgorithm) {
        this.xmlCipherAlgorithm = xmlCipherAlgorithm;
    }

    public String getPassPhrase() {
        return passPhrase;
    }

    public void setPassPhrase(String passPhrase) {
        this.passPhrase = passPhrase;
    }

    public String getSecureTag() {
        return secureTag;
    }

    public void setSecureTag(String secureTag) {
        this.secureTag = secureTag;
    }

    public Boolean getSecureTagContents() {
        return secureTagContents;
    }

    public void setSecureTagContents(Boolean secureTagContents) {
        this.secureTagContents = secureTagContents;
    }

    public String getKeyCipherAlgorithm() {
        return keyCipherAlgorithm;
    }

    public void setKeyCipherAlgorithm(String keyCipherAlgorithm) {
        this.keyCipherAlgorithm = keyCipherAlgorithm;
    }

    public String getRecipientKeyAlias() {
        return recipientKeyAlias;
    }

    public void setRecipientKeyAlias(String recipientKeyAlias) {
        this.recipientKeyAlias = recipientKeyAlias;
    }

    public String getKeyOrTrustStoreParametersId() {
        return keyOrTrustStoreParametersId;
    }

    public void setKeyOrTrustStoreParametersId(
            String keyOrTrustStoreParametersId) {
        this.keyOrTrustStoreParametersId = keyOrTrustStoreParametersId;
    }

    public String getKeyPassword() {
        return keyPassword;
    }

    public void setKeyPassword(String keyPassword) {
        this.keyPassword = keyPassword;
    }

    public String getDigestAlgorithm() {
        return digestAlgorithm;
    }

    public void setDigestAlgorithm(String digestAlgorithm) {
        this.digestAlgorithm = digestAlgorithm;
    }

    public String getMgfAlgorithm() {
        return mgfAlgorithm;
    }

    public void setMgfAlgorithm(String mgfAlgorithm) {
        this.mgfAlgorithm = mgfAlgorithm;
    }

    public Boolean getAddKeyValueForEncryptedKey() {
        return addKeyValueForEncryptedKey;
    }

    public void setAddKeyValueForEncryptedKey(Boolean addKeyValueForEncryptedKey) {
        this.addKeyValueForEncryptedKey = addKeyValueForEncryptedKey;
    }
}