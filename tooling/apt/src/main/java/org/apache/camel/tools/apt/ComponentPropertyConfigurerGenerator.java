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
package org.apache.camel.tools.apt;

import java.io.IOException;
import java.io.Writer;
import java.util.Set;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import javax.tools.FileObject;
import javax.tools.JavaFileObject;
import javax.tools.StandardLocation;

import org.apache.camel.tools.apt.helper.IOHelper;
import org.apache.camel.tools.apt.model.ComponentOption;
import org.apache.camel.tools.apt.model.EndpointOption;

import static org.apache.camel.tools.apt.AnnotationProcessorHelper.dumpExceptionToErrorFile;

public final class ComponentPropertyConfigurerGenerator {

    private ComponentPropertyConfigurerGenerator() {
    }

    public static void generateExtendConfigurer(ProcessingEnvironment processingEnv, TypeElement parent,
                                                String pn, String cn, String fqn) {

        Writer w = null;
        try {
            JavaFileObject src = processingEnv.getFiler().createSourceFile(fqn, parent);
            w = src.openWriter();

            w.write("/* Generated by org.apache.camel:apt */\n");
            w.write("package " + pn + ";\n");
            w.write("\n");
            w.write("import " + parent.getQualifiedName().toString() + ";\n");
            w.write("\n");
            w.write("/**\n");
            w.write(" * Source code generated by org.apache.camel:apt\n");
            w.write(" */\n");
            w.write("public class " + cn + " extends " + parent.getSimpleName().toString() + " {\n");
            w.write("\n");
            w.write("}\n");
            w.write("\n");
        } catch (Exception e) {
            processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Unable to generate source code file: " + fqn + ": " + e.getMessage());
            dumpExceptionToErrorFile("camel-apt-error.log", "Unable to generate source code file: " + fqn, e);
        } finally {
            IOHelper.close(w);
        }
    }

    public static void generatePropertyConfigurer(ProcessingEnvironment processingEnv, TypeElement parent,
                                                  String pn, String cn, String fqn, String en,
                                                  Set<ComponentOption> options) {

        Writer w = null;
        try {
            JavaFileObject src = processingEnv.getFiler().createSourceFile(fqn, parent);
            w = src.openWriter();

            int size = options.size();

            w.write("/* Generated by org.apache.camel:apt */\n");
            w.write("package " + pn + ";\n");
            w.write("\n");
            w.write("import java.util.HashMap;\n");
            w.write("import java.util.Map;\n");
            w.write("\n");
            w.write("import org.apache.camel.CamelContext;\n");
            w.write("import org.apache.camel.spi.TriPropertyConfigurer;\n");
            w.write("import org.apache.camel.support.component.PropertyConfigurerSupport;\n");
            w.write("import org.apache.camel.util.function.TriConsumer;\n");
            w.write("\n");
            w.write("/**\n");
            w.write(" * Source code generated by org.apache.camel:apt\n");
            w.write(" */\n");
            w.write("public class " + cn + " extends PropertyConfigurerSupport implements TriPropertyConfigurer {\n");
            w.write("\n");
            w.write("    private static final Map<String, TriConsumer<CamelContext, Object, Object>> WRITES;\n");
            w.write("    static {\n");
            w.write("        Map<String, TriConsumer<CamelContext, Object, Object>> map = new HashMap<>(" + size + ");\n");
            for (ComponentOption option : options) {
                String getOrSet = option.getName();
                getOrSet = Character.toUpperCase(getOrSet.charAt(0)) + getOrSet.substring(1);
                String setterLambda = setterLambda(en, getOrSet, option.getType(), option.getConfigurationField());
                w.write("        map.put(\"" + option.getName() + "\", (camelContext, component, value) -> " + setterLambda + ");\n");
            }
            w.write("        WRITES = map;\n");
            w.write("    }\n");
            w.write("\n");
            w.write("    @Override\n");
            w.write("    public Map<String, TriConsumer<CamelContext, Object, Object>> getWriteOptions(CamelContext camelContext) {\n");
            w.write("        return WRITES;\n");
            w.write("    }\n");
            w.write("\n");
            w.write("}\n");
            w.write("\n");
        } catch (Exception e) {
            processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Unable to generate source code file: " + fqn + ": " + e.getMessage());
            dumpExceptionToErrorFile("camel-apt-error.log", "Unable to generate source code file: " + fqn, e);
        } finally {
            IOHelper.close(w);
        }
    }

    private static String setterLambda(String en, String getOrSet, String type, String configurationField) {
        // type may contain generics so remove those
        if (type.indexOf('<') != -1) {
            type = type.substring(0, type.indexOf('<'));
        }
        if (configurationField != null) {
            getOrSet = "get" + Character.toUpperCase(configurationField.charAt(0)) + configurationField.substring(1) + "().set" + getOrSet;
        } else {
            getOrSet = "set" + getOrSet;
        }

        // ((LogEndpoint) endpoint).setGroupSize(property(camelContext, java.lang.Integer.class, value))
        return String.format("((%s) component).%s(property(camelContext, %s.class, value))", en, getOrSet, type);
    }

    public static void generateMetaInfConfigurer(ProcessingEnvironment processingEnv, String name, String fqn) {
        try {
            FileObject resource = processingEnv.getFiler().createResource(StandardLocation.CLASS_OUTPUT, "",
                    "META-INF/services/org/apache/camel/configurer/" + name);
            try (Writer w = resource.openWriter()) {
                w.append("# Generated by camel annotation processor\n");
                w.append("class=").append(fqn).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
