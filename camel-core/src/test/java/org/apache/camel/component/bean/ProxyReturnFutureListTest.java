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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.apache.camel.ContextTestSupport;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

/**
 * @version 
 */
public class ProxyReturnFutureListTest extends ContextTestSupport {

    @Test
    public void testFutureList() throws Exception {
        Users service = ProxyHelper.createProxy(context.getEndpoint("direct:echo"), Users.class);

        Future<List<String>> future = service.getUsers(true);
        log.info("Got future");
        assertFalse("Should not be done", future.isDone());
        log.info("Waiting for future to be done ...");

        List<String> users = future.get(2, TimeUnit.SECONDS);
        assertEquals("Claus", users.get(0));
        assertEquals("Jonathan", users.get(1));
    }

    @Test
    public void testFutureListCallTwoTimes() throws Exception {
        Users service = ProxyHelper.createProxy(context.getEndpoint("direct:echo"), Users.class);

        Future<List<String>> future = service.getUsers(true);
        log.info("Got future");
        assertFalse("Should not be done", future.isDone());
        log.info("Waiting for future to be done ...");

        List<String> users = future.get(2, TimeUnit.SECONDS);
        assertEquals("Claus", users.get(0));
        assertEquals("Jonathan", users.get(1));

        future = service.getUsers(true);
        log.info("Got future");
        assertFalse("Should not be done", future.isDone());
        log.info("Waiting for future to be done ...");

        users = future.get(2, TimeUnit.SECONDS);
        assertEquals("Claus", users.get(0));
        assertEquals("Jonathan", users.get(1));
    }

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:echo")
                    .delay(50)
                    .process(new Processor() {
                        public void process(Exchange exchange) throws Exception {
                            List<String> users = new ArrayList<>();
                            users.add("Claus");
                            users.add("Jonathan");
                            exchange.getIn().setBody(users);
                        }
                    });
            }
        };
    }

    public interface Users {
        Future<List<String>> getUsers(boolean gold);
    }

}
