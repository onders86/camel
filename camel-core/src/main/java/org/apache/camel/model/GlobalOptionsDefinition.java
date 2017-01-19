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
package org.apache.camel.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.spi.Metadata;

/**
 * Models a series of string key/value pairs for configuring some global options
 * on {@link CamelContext} such as {@link Exchange#LOG_DEBUG_BODY_MAX_CHARS}.
 */
@Metadata(label = "configuration")
@XmlRootElement(name = "globalOptions")
@XmlAccessorType(XmlAccessType.FIELD)
public class GlobalOptionsDefinition {
    @XmlElement(name = "globalOption")
    private List<GlobalOptionDefinition> globalOptions;

    public GlobalOptionsDefinition() {
    }

    public void setGlobalOptions(List<GlobalOptionDefinition> globalOptions) {
        this.globalOptions = globalOptions;
    }

    public List<GlobalOptionDefinition> getGlobalOptions() {
        return globalOptions;
    }

    public Map<String, String> asMap() {
        Map<String, String> globalOptionsAsMap = new HashMap<>();
        for (GlobalOptionDefinition globalOption : getGlobalOptions()) {
            globalOptionsAsMap.put(globalOption.getKey(), globalOption.getValue());
        }
        return globalOptionsAsMap;
    }

}
