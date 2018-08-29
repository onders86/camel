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
package org.apache.camel.processor;

import org.junit.Test;

import org.apache.camel.ContextTestSupport;
import org.apache.camel.builder.RouteBuilder;

public class DefaultErrorHandlerLogExhaustedMessageHistoryTest extends ContextTestSupport {

    @Test
    public void testLogExhaustedMessageHistory() throws Exception {
        try {
            template.sendBody("direct:start", "Hello World");
            fail("Should fail");
        } catch (Exception e) {
            // ignore
        }
    }

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                // no delay to speedup test
                errorHandler(defaultErrorHandler().redeliveryDelay(0).maximumRedeliveries(3).logExhaustedMessageHistory(true));

                from("direct:start")
                    .log("Incoming ${body}")
                    .throwException(new IllegalArgumentException("Forced"));
            }
        };
    }
}
