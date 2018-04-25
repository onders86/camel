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
package org.apache.camel.component.web3j;

import org.apache.camel.Exchange;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.junit.Ignore;
import org.junit.Test;

import static org.apache.camel.component.web3j.Web3jConstants.*;

@Ignore("Integration test that requires a locally running synced ethereum node")
public class Web3jProducerIntegrationTest extends Web3jTestSupport {

    @Produce(uri = "direct:start")
    protected ProducerTemplate template;

    @Override
    protected String getUrl() {
        return "web3j://http://127.0.0.1:8545?";
    }

    @Test
    public void clientVersionTest() throws Exception {
        Exchange exchange = createExchangeWithBodyAndHeader(null, OPERATION, WEB3_CLIENT_VERSION);
        template.send(exchange);
        String body = exchange.getIn().getBody(String.class);
        assertTrue(body.startsWith("Geth"));
    }

    @Test
    public void netVersionTest() throws Exception {
        Exchange exchange = createExchangeWithBodyAndHeader(null, OPERATION, NET_VERSION);
        template.send(exchange);
        String body = exchange.getIn().getBody(String.class);
        assertTrue(body != null);
    }

    @Test
    public void netWeb3Sha3Test() throws Exception {
        Exchange exchange = createExchangeWithBodyAndHeader(null, OPERATION, WEB3_SHA3);
        exchange.getIn().setBody("0x68656c6c6f20776f726c64");
        template.send(exchange);
        String body = exchange.getIn().getBody(String.class);
        assertTrue(body.equals("0x47173285a8d7341e5e972fc677286384f802f8ef42a5ec5f03bbfa254cb01fad"));
    }

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            public void configure() {
                from("direct:start")
                        .to(getUrl() + OPERATION.toLowerCase() + "=" + TRANSACTION);
            }
        };
    }
}
