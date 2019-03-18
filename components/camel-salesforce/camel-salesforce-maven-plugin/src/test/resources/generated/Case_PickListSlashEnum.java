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
/*
 * Salesforce DTO generated by camel-salesforce-maven-plugin
 */
package $packageName;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Salesforce Enumeration DTO for picklist PickListSlash
 */
@Generated("org.apache.camel.maven.CamelSalesforceMojo")
public enum Case_PickListSlashEnum {

    // Acciones relacionadas con cotizaciones y/o avisos de entrega
    ACCIONES_RELACIONADAS_CON_COTIZACIONES_Y_O_AVISOS_DE_ENTREGA("Acciones relacionadas con cotizaciones y/o avisos de entrega");

    final String value;

    private Case_PickListSlashEnum(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return this.value;
    }

    @JsonCreator
    public static Case_PickListSlashEnum fromValue(String value) {
        for (Case_PickListSlashEnum e : Case_PickListSlashEnum.values()) {
            if (e.value.equals(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException(value);
    }

}
