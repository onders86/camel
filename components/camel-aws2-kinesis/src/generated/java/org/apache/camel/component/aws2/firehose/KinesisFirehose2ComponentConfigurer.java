/* Generated by camel build tools - do NOT edit this file! */
package org.apache.camel.component.aws2.firehose;

import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.spi.GeneratedPropertyConfigurer;
import org.apache.camel.spi.PropertyConfigurerGetter;
import org.apache.camel.util.CaseInsensitiveMap;
import org.apache.camel.support.component.PropertyConfigurerSupport;

/**
 * Generated by camel build tools - do NOT edit this file!
 */
@SuppressWarnings("unchecked")
public class KinesisFirehose2ComponentConfigurer extends PropertyConfigurerSupport implements GeneratedPropertyConfigurer, PropertyConfigurerGetter {

    private org.apache.camel.component.aws2.firehose.KinesisFirehose2Configuration getOrCreateConfiguration(KinesisFirehose2Component target) {
        if (target.getConfiguration() == null) {
            target.setConfiguration(new org.apache.camel.component.aws2.firehose.KinesisFirehose2Configuration());
        }
        return target.getConfiguration();
    }

    @Override
    public boolean configure(CamelContext camelContext, Object obj, String name, Object value, boolean ignoreCase) {
        KinesisFirehose2Component target = (KinesisFirehose2Component) obj;
        switch (ignoreCase ? name.toLowerCase() : name) {
        case "accesskey":
        case "accessKey": getOrCreateConfiguration(target).setAccessKey(property(camelContext, java.lang.String.class, value)); return true;
        case "amazonkinesisfirehoseclient":
        case "amazonKinesisFirehoseClient": getOrCreateConfiguration(target).setAmazonKinesisFirehoseClient(property(camelContext, software.amazon.awssdk.services.firehose.FirehoseClient.class, value)); return true;
        case "basicpropertybinding":
        case "basicPropertyBinding": target.setBasicPropertyBinding(property(camelContext, boolean.class, value)); return true;
        case "configuration": target.setConfiguration(property(camelContext, org.apache.camel.component.aws2.firehose.KinesisFirehose2Configuration.class, value)); return true;
        case "lazystartproducer":
        case "lazyStartProducer": target.setLazyStartProducer(property(camelContext, boolean.class, value)); return true;
        case "proxyhost":
        case "proxyHost": getOrCreateConfiguration(target).setProxyHost(property(camelContext, java.lang.String.class, value)); return true;
        case "proxyport":
        case "proxyPort": getOrCreateConfiguration(target).setProxyPort(property(camelContext, java.lang.Integer.class, value)); return true;
        case "proxyprotocol":
        case "proxyProtocol": getOrCreateConfiguration(target).setProxyProtocol(property(camelContext, software.amazon.awssdk.core.Protocol.class, value)); return true;
        case "region": getOrCreateConfiguration(target).setRegion(property(camelContext, java.lang.String.class, value)); return true;
        case "secretkey":
        case "secretKey": getOrCreateConfiguration(target).setSecretKey(property(camelContext, java.lang.String.class, value)); return true;
        default: return false;
        }
    }

    @Override
    public Map<String, Object> getAllOptions(Object target) {
        Map<String, Object> answer = new CaseInsensitiveMap();
        answer.put("accessKey", java.lang.String.class);
        answer.put("amazonKinesisFirehoseClient", software.amazon.awssdk.services.firehose.FirehoseClient.class);
        answer.put("basicPropertyBinding", boolean.class);
        answer.put("configuration", org.apache.camel.component.aws2.firehose.KinesisFirehose2Configuration.class);
        answer.put("lazyStartProducer", boolean.class);
        answer.put("proxyHost", java.lang.String.class);
        answer.put("proxyPort", java.lang.Integer.class);
        answer.put("proxyProtocol", software.amazon.awssdk.core.Protocol.class);
        answer.put("region", java.lang.String.class);
        answer.put("secretKey", java.lang.String.class);
        return answer;
    }

    @Override
    public Object getOptionValue(Object obj, String name, boolean ignoreCase) {
        KinesisFirehose2Component target = (KinesisFirehose2Component) obj;
        switch (ignoreCase ? name.toLowerCase() : name) {
        case "accesskey":
        case "accessKey": return getOrCreateConfiguration(target).getAccessKey();
        case "amazonkinesisfirehoseclient":
        case "amazonKinesisFirehoseClient": return getOrCreateConfiguration(target).getAmazonKinesisFirehoseClient();
        case "basicpropertybinding":
        case "basicPropertyBinding": return target.isBasicPropertyBinding();
        case "configuration": return target.getConfiguration();
        case "lazystartproducer":
        case "lazyStartProducer": return target.isLazyStartProducer();
        case "proxyhost":
        case "proxyHost": return getOrCreateConfiguration(target).getProxyHost();
        case "proxyport":
        case "proxyPort": return getOrCreateConfiguration(target).getProxyPort();
        case "proxyprotocol":
        case "proxyProtocol": return getOrCreateConfiguration(target).getProxyProtocol();
        case "region": return getOrCreateConfiguration(target).getRegion();
        case "secretkey":
        case "secretKey": return getOrCreateConfiguration(target).getSecretKey();
        default: return null;
        }
    }
}

