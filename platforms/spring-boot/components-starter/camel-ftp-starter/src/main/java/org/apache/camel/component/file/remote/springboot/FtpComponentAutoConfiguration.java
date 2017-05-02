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
package org.apache.camel.component.file.remote.springboot;

import javax.annotation.Generated;
import org.apache.camel.CamelContext;
import org.apache.camel.component.file.remote.FtpComponent;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionMessage;
import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@Generated("org.apache.camel.maven.packaging.SpringBootAutoConfigurationMojo")
@Configuration
@ConditionalOnBean(type = "org.apache.camel.spring.boot.CamelAutoConfiguration")
@Conditional(FtpComponentAutoConfiguration.Condition.class)
@AutoConfigureAfter(name = "org.apache.camel.spring.boot.CamelAutoConfiguration")
public class FtpComponentAutoConfiguration {

    @Lazy
    @Bean(name = "ftp-component")
    @ConditionalOnClass(CamelContext.class)
    @ConditionalOnMissingBean(FtpComponent.class)
    public FtpComponent configureFtpComponent(CamelContext camelContext)
            throws Exception {
        FtpComponent component = new FtpComponent();
        component.setCamelContext(camelContext);
        return component;
    }

    @Generated("org.apache.camel.maven.packaging.SpringBootAutoConfigurationMojo")
    public static class Condition extends SpringBootCondition {
        @Override
        public ConditionOutcome getMatchOutcome(
                ConditionContext conditionContext,
                AnnotatedTypeMetadata annotatedTypeMetadata) {
            boolean groupEnabled = isEnabled(conditionContext,
                    "camel.component.", true);
            ConditionMessage.Builder message = ConditionMessage
                    .forCondition("camel.component.ftp");
            if (isEnabled(conditionContext, "camel.component.ftp.",
                    groupEnabled)) {
                return ConditionOutcome.match(message.because("enabled"));
            }
            return ConditionOutcome.noMatch(message.because("not enabled"));
        }

        private boolean isEnabled(
                org.springframework.context.annotation.ConditionContext context,
                java.lang.String prefix, boolean defaultValue) {
            RelaxedPropertyResolver resolver = new RelaxedPropertyResolver(
                    context.getEnvironment(), prefix);
            return resolver.getProperty("enabled", Boolean.class, defaultValue);
        }
    }
}
