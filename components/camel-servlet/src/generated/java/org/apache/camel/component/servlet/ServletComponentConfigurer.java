/* Generated by camel build tools - do NOT edit this file! */
package org.apache.camel.component.servlet;

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
public class ServletComponentConfigurer extends PropertyConfigurerSupport implements GeneratedPropertyConfigurer, PropertyConfigurerGetter {

    @Override
    public boolean configure(CamelContext camelContext, Object obj, String name, Object value, boolean ignoreCase) {
        ServletComponent target = (ServletComponent) obj;
        switch (ignoreCase ? name.toLowerCase() : name) {
        case "allowjavaserializedobject":
        case "allowJavaSerializedObject": target.setAllowJavaSerializedObject(property(camelContext, boolean.class, value)); return true;
        case "attachmentmultipartbinding":
        case "attachmentMultipartBinding": target.setAttachmentMultipartBinding(property(camelContext, boolean.class, value)); return true;
        case "basicpropertybinding":
        case "basicPropertyBinding": target.setBasicPropertyBinding(property(camelContext, boolean.class, value)); return true;
        case "bridgeerrorhandler":
        case "bridgeErrorHandler": target.setBridgeErrorHandler(property(camelContext, boolean.class, value)); return true;
        case "filenameextwhitelist":
        case "fileNameExtWhitelist": target.setFileNameExtWhitelist(property(camelContext, java.lang.String.class, value)); return true;
        case "headerfilterstrategy":
        case "headerFilterStrategy": target.setHeaderFilterStrategy(property(camelContext, org.apache.camel.spi.HeaderFilterStrategy.class, value)); return true;
        case "httpbinding":
        case "httpBinding": target.setHttpBinding(property(camelContext, org.apache.camel.http.common.HttpBinding.class, value)); return true;
        case "httpconfiguration":
        case "httpConfiguration": target.setHttpConfiguration(property(camelContext, org.apache.camel.http.common.HttpConfiguration.class, value)); return true;
        case "httpregistry":
        case "httpRegistry": target.setHttpRegistry(property(camelContext, org.apache.camel.http.common.HttpRegistry.class, value)); return true;
        case "servletname":
        case "servletName": target.setServletName(property(camelContext, java.lang.String.class, value)); return true;
        default: return false;
        }
    }

    @Override
    public Map<String, Object> getAllOptions(Object target) {
        Map<String, Object> answer = new CaseInsensitiveMap();
        answer.put("allowJavaSerializedObject", boolean.class);
        answer.put("attachmentMultipartBinding", boolean.class);
        answer.put("basicPropertyBinding", boolean.class);
        answer.put("bridgeErrorHandler", boolean.class);
        answer.put("fileNameExtWhitelist", java.lang.String.class);
        answer.put("headerFilterStrategy", org.apache.camel.spi.HeaderFilterStrategy.class);
        answer.put("httpBinding", org.apache.camel.http.common.HttpBinding.class);
        answer.put("httpConfiguration", org.apache.camel.http.common.HttpConfiguration.class);
        answer.put("httpRegistry", org.apache.camel.http.common.HttpRegistry.class);
        answer.put("servletName", java.lang.String.class);
        return answer;
    }

    @Override
    public Object getOptionValue(Object obj, String name, boolean ignoreCase) {
        ServletComponent target = (ServletComponent) obj;
        switch (ignoreCase ? name.toLowerCase() : name) {
        case "allowjavaserializedobject":
        case "allowJavaSerializedObject": return target.isAllowJavaSerializedObject();
        case "attachmentmultipartbinding":
        case "attachmentMultipartBinding": return target.isAttachmentMultipartBinding();
        case "basicpropertybinding":
        case "basicPropertyBinding": return target.isBasicPropertyBinding();
        case "bridgeerrorhandler":
        case "bridgeErrorHandler": return target.isBridgeErrorHandler();
        case "filenameextwhitelist":
        case "fileNameExtWhitelist": return target.getFileNameExtWhitelist();
        case "headerfilterstrategy":
        case "headerFilterStrategy": return target.getHeaderFilterStrategy();
        case "httpbinding":
        case "httpBinding": return target.getHttpBinding();
        case "httpconfiguration":
        case "httpConfiguration": return target.getHttpConfiguration();
        case "httpregistry":
        case "httpRegistry": return target.getHttpRegistry();
        case "servletname":
        case "servletName": return target.getServletName();
        default: return null;
        }
    }
}

