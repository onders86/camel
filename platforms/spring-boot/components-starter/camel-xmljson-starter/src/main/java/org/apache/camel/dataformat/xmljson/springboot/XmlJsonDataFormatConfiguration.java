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
package org.apache.camel.dataformat.xmljson.springboot;

import java.util.List;
import javax.annotation.Generated;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Camel XML JSON Data Format
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@Generated("org.apache.camel.maven.packaging.SpringBootAutoConfigurationMojo")
@ConfigurationProperties(prefix = "camel.dataformat.xmljson")
public class XmlJsonDataFormatConfiguration {

    /**
     * Sets the encoding. Used for unmarshalling (JSON to XML conversion).
     */
    private String encoding;
    /**
     * Specifies the name of the XML elements representing each array element.
     * Used for unmarshalling (JSON to XML conversion).
     */
    private String elementName;
    /**
     * Specifies the name of the top-level XML element. Used for unmarshalling
     * (JSON to XML conversion). For example when converting 1 2 3 it will be
     * output by default as 123. By setting this option or rootName you can
     * alter the name of element 'a'.
     */
    private String arrayName;
    /**
     * Determines whether the resulting JSON will start off with a top-most
     * element whose name matches the XML root element. Used for marshalling
     * (XML to JSon conversion). If disabled XML string 12 turns into 'x: '1'
     * 'y': '2' . Otherwise it turns into 'a': 'x: '1' 'y': '2' .
     */
    private Boolean forceTopLevelObject = false;
    /**
     * Flag to be tolerant to incomplete namespace prefixes. Used for
     * unmarshalling (JSON to XML conversion). In most cases json-lib
     * automatically changes this flag at runtime to match the processing.
     */
    private Boolean namespaceLenient = false;
    /**
     * Specifies the name of the top-level element. Used for unmarshalling (JSON
     * to XML conversion). If not set json-lib will use arrayName or objectName
     * (default value: 'o' at the current time it is not configurable in this
     * data format). If set to 'root' the JSON string 'x': 'value1' 'y' :
     * 'value2' would turn into value1value2 otherwise the 'root' element would
     * be named 'o'.
     */
    private String rootName;
    /**
     * Determines whether white spaces between XML elements will be regarded as
     * text values or disregarded. Used for marshalling (XML to JSon
     * conversion).
     */
    private Boolean skipWhitespace = false;
    /**
     * Determines whether leading and trailing white spaces will be omitted from
     * String values. Used for marshalling (XML to JSon conversion).
     */
    private Boolean trimSpaces = false;
    /**
     * Signals whether namespaces should be ignored. By default they will be
     * added to the JSON output using xmlns elements. Used for marshalling (XML
     * to JSon conversion).
     */
    private Boolean skipNamespaces = false;
    /**
     * Removes the namespace prefixes from XML qualified elements so that the
     * resulting JSON string does not contain them. Used for marshalling (XML to
     * JSon conversion).
     */
    private Boolean removeNamespacePrefixes = false;
    /**
     * With expandable properties JSON array elements are converted to XML as a
     * sequence of repetitive XML elements with the local name equal to the JSON
     * key for example: number: 123 normally converted to: 123 (where e can be
     * modified by setting elementName) would instead translate to 123 if number
     * is set as an expandable property Used for unmarshalling (JSON to XML
     * conversion).
     */
    private List<String> expandableProperties;
    /**
     * Adds type hints to the resulting XML to aid conversion back to JSON. Used
     * for unmarshalling (JSON to XML conversion).
     */
    private String typeHints;
    /**
     * Whether the data format should set the Content-Type header with the type
     * from the data format if the data format is capable of doing so. For
     * example application/xml for data formats marshalling to XML or
     * application/json for data formats marshalling to JSon etc.
     */
    private Boolean contentTypeHeader = false;

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getArrayName() {
        return arrayName;
    }

    public void setArrayName(String arrayName) {
        this.arrayName = arrayName;
    }

    public Boolean getForceTopLevelObject() {
        return forceTopLevelObject;
    }

    public void setForceTopLevelObject(Boolean forceTopLevelObject) {
        this.forceTopLevelObject = forceTopLevelObject;
    }

    public Boolean getNamespaceLenient() {
        return namespaceLenient;
    }

    public void setNamespaceLenient(Boolean namespaceLenient) {
        this.namespaceLenient = namespaceLenient;
    }

    public String getRootName() {
        return rootName;
    }

    public void setRootName(String rootName) {
        this.rootName = rootName;
    }

    public Boolean getSkipWhitespace() {
        return skipWhitespace;
    }

    public void setSkipWhitespace(Boolean skipWhitespace) {
        this.skipWhitespace = skipWhitespace;
    }

    public Boolean getTrimSpaces() {
        return trimSpaces;
    }

    public void setTrimSpaces(Boolean trimSpaces) {
        this.trimSpaces = trimSpaces;
    }

    public Boolean getSkipNamespaces() {
        return skipNamespaces;
    }

    public void setSkipNamespaces(Boolean skipNamespaces) {
        this.skipNamespaces = skipNamespaces;
    }

    public Boolean getRemoveNamespacePrefixes() {
        return removeNamespacePrefixes;
    }

    public void setRemoveNamespacePrefixes(Boolean removeNamespacePrefixes) {
        this.removeNamespacePrefixes = removeNamespacePrefixes;
    }

    public List<String> getExpandableProperties() {
        return expandableProperties;
    }

    public void setExpandableProperties(List<String> expandableProperties) {
        this.expandableProperties = expandableProperties;
    }

    public String getTypeHints() {
        return typeHints;
    }

    public void setTypeHints(String typeHints) {
        this.typeHints = typeHints;
    }

    public Boolean getContentTypeHeader() {
        return contentTypeHeader;
    }

    public void setContentTypeHeader(Boolean contentTypeHeader) {
        this.contentTypeHeader = contentTypeHeader;
    }
}