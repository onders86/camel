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
package org.apache.camel.model.cloud;

import java.util.Arrays;
import java.util.List;

final class ServiceCallConstants {
    public static final List<ServiceCallServiceDiscoveryConfiguration> SERVICE_DISCOVERY_CONFIGURATIONS = Arrays.asList(
        new CachingServiceCallServiceDiscoveryConfiguration(),
        new ChainedServiceCallServiceDiscoveryConfiguration(),
        new ConsulServiceCallServiceDiscoveryConfiguration(),
        new DnsServiceCallServiceDiscoveryConfiguration(),
        new EtcdServiceCallServiceDiscoveryConfiguration(),
        new KubernetesServiceCallServiceDiscoveryConfiguration()
    );

    public static final List<ServiceCallServiceFilterConfiguration> SERVICE_FILTER_CONFIGURATIONS = Arrays.asList(
        new BlacklistServiceCallServiceFilterConfiguration(),
        new ChainedServiceCallServiceFilterConfiguration(),
        new CustomServiceCallServiceFilterConfiguration(),
        new HealthyServiceCallServiceFilterConfiguration(),
        new PassThroughServiceCallServiceFilterConfiguration()
    );

    public static final List<ServiceCallLoadBalancerConfiguration> LOAD_BALANCER_CONFIGURATIONS = Arrays.asList(
        new RibbonServiceCallLoadBalancerConfiguration()
    );

    private ServiceCallConstants() {
    }
}
