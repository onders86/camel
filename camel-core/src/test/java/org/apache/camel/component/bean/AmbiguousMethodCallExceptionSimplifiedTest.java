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
package org.apache.camel.component.bean;

import org.junit.Test;

import org.apache.camel.ContextTestSupport;
import org.apache.camel.builder.ExchangeBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;

public class AmbiguousMethodCallExceptionSimplifiedTest extends ContextTestSupport {

    public interface InterfaceSize {
        int size();
    }

    public abstract static class AbstractClassSize {
        public abstract int size();
    }

    public static class SuperClazz extends AbstractClassSize implements InterfaceSize {
        public int size() {
            return 1;
        }
    }

    public static class Clazz extends SuperClazz {
    }

    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:in").choice().when(simple("${headers.bean.size} != 0")).to("mock:out");
            }
        };
    }

    @Test
    public void testAmbiguousMethodCallException() throws Exception {
        MockEndpoint out = getMockEndpoint("mock:out");
        out.expectedMessageCount(1);

        ExchangeBuilder exchangeBuilder = new ExchangeBuilder(context).withHeader("bean", new Clazz());
        template.send("direct:in", exchangeBuilder.build());

        out.assertIsSatisfied();
    }
}
