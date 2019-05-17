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
package org.apache.camel.component.robotframework;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class RobotFrameworkComponentTest extends CamelTestSupport {

    @Test
    public void testRobotFrameworkCamelBodyAsString() throws Exception {
        MockEndpoint mock = getMockEndpoint("mock:result");
        MockEndpoint mockString = getMockEndpoint("mock:resultString");
        mock.expectedMinimumMessageCount(1);
        mockString.expectedMinimumMessageCount(1);

        template.sendBody("direct:setVariableCamelBody", "hello foo");
        template.sendBody("direct:assertRobotCamelInputAsString", "hello foo");

        assertMockEndpointsSatisfied();
    }

    @Test
    public void testRobotFrameworkCamelBodyAsNumeric() throws Exception {
        MockEndpoint mock = getMockEndpoint("mock:result");
        MockEndpoint mockNumeric = getMockEndpoint("mock:resultNumeric");
        mock.expectedMinimumMessageCount(1);
        mockNumeric.expectedMinimumMessageCount(1);

        template.sendBody("direct:setVariableCamelBody", 1);
        template.sendBody("direct:assertRobotCamelInputAsNumeric", 1);

        assertMockEndpointsSatisfied();
    }

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            public void configure() {
                from("direct:setVariableCamelBody").to("robotframework:src/test/resources/org/apache/camel/component/robotframework/set_variable_camel_body.robot")
                    .to("mock:result");

                from("direct:assertRobotCamelInputAsString")
                    .to("robotframework:src/test/resources/org/apache/camel/component/robotframework/assert_string_robot_with_camel_exchange_value_as_string.robot")
                    .to("mock:resultString");

                from("direct:assertRobotCamelInputAsNumeric")
                    .to("robotframework:src/test/resources/org/apache/camel/component/robotframework/assert_string_robot_with_camel_exchange_value_as_numeric.robot")
                    .to("mock:resultNumeric");
            }
        };
    }
}
