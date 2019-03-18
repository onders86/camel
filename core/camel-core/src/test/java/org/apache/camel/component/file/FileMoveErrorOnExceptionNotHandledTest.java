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
package org.apache.camel.component.file;
import org.apache.camel.ContextTestSupport;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class FileMoveErrorOnExceptionNotHandledTest extends ContextTestSupport {

    @Override
    @Before
    public void setUp() throws Exception {
        deleteDirectory("target/data/move");
        super.setUp();
    }

    @Test
    public void testMoveError() throws Exception {
        getMockEndpoint("mock:before").expectedMessageCount(1);
        getMockEndpoint("mock:after").expectedMessageCount(0);
        getMockEndpoint("mock:damn").expectedMessageCount(1);
        getMockEndpoint("mock:damn").expectedFileExists("target/data/move/error/hello.txt");

        template.sendBodyAndHeader("file:target/data/move", "Hello World", Exchange.FILE_NAME, "hello.txt");

        assertMockEndpointsSatisfied();
    }

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("file:target/data/move?moveFailed=error&initialDelay=0&delay=10")
                    .onException(IllegalArgumentException.class)
                        .to("mock:damn")
                    .end()
                    .to("mock:before")
                    .throwException(new IllegalArgumentException("Damn"))
                    .to("mock:after");
            }
        };
    }
}
