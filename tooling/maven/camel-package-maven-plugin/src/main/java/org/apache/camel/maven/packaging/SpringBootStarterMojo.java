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
package org.apache.camel.maven.packaging;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

import org.apache.commons.io.IOUtils;
import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.factory.ArtifactFactory;
import org.apache.maven.artifact.metadata.ArtifactMetadataSource;
import org.apache.maven.artifact.repository.ArtifactRepository;
import org.apache.maven.artifact.resolver.ArtifactCollector;
import org.apache.maven.artifact.resolver.filter.ArtifactFilter;
import org.apache.maven.artifact.resolver.filter.ScopeArtifactFilter;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;
import org.apache.maven.shared.dependency.tree.DependencyNode;
import org.apache.maven.shared.dependency.tree.DependencyTreeBuilder;
import org.apache.maven.shared.dependency.tree.DependencyTreeBuilderException;
import org.apache.maven.shared.dependency.tree.traversal.CollectingDependencyNodeVisitor;

import freemarker.cache.URLTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * Generate Spring Boot starter for the component
 *
 * @goal prepare-spring-boot-starter
 */
public class SpringBootStarterMojo extends AbstractMojo {

    // TO ADD?: "camel-chronicle", "camel-guava-eventbus" ?, "camel-johnzon", "camel-ribbon"
    private static final String[] IGNORE_MODULES = {/* OSGi -> */ "camel-core-osgi", "camel-eventadmin", "camel-paxlogging",  /* deprecated (and not working perfectly) -> */"camel-swagger", "camel-mina",
            /* others (not managed) -> */ "camel-zipkin"};

    private static final boolean IGNORE_TEST_MODULES = true;

    /**
     * The maven project.
     *
     * @parameter property="project"
     * @required
     * @readonly
     */
    protected MavenProject project;


    /**
     * The project directory
     *
     * @parameter default-value="${basedir}"
     */
    protected File baseDir;

    /**
     * @component
     * @required
     * @readonly
     */
    protected ArtifactFactory artifactFactory;

    /**
     * @component
     * @required
     * @readonly
     */
    protected ArtifactMetadataSource artifactMetadataSource;

    /**
     * @component
     * @required
     * @readonly
     */
    protected ArtifactCollector artifactCollector;

    /**
     * @component
     * @required
     * @readonly
     */
    protected DependencyTreeBuilder treeBuilder;

    /**
     * @parameter default-value="${localRepository}"
     * @readonly
     * @required
     */
    protected ArtifactRepository localRepository;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {

        if (!isStarterAllowed()) {
            getLog().info("Spring-Boot-Starter: starter not allowed for module " + project.getArtifactId() + ": skipping.");
            return;
        }

        try {
            // create the starter directory
            File starterDir = starterDir();
            getLog().info("Spring-Boot-Starter: starter dir for the component is: " + starterDir.getAbsolutePath());

            if (!starterDir.exists()) {
                starterDir.mkdirs();
            }

            // create the base pom.xml
            Document pom = createBasePom();

            // Apply changes to the starter pom
            fixLoggingDependencies(pom);
            includeAdditionalDependencies(pom);

            // Write the starter pom
            File pomFile = new File(starterDir, "pom.xml");
            writeXmlFormatted(pom, pomFile);

            // write LICENSE, USAGE and spring.provides files
            writeStaticFiles();
            writeSpringProvides();

            // synchronized all starters with their parent pom 'modules' section
            synchronizeParentPom();

        } catch (Exception e) {
            throw new MojoFailureException("Unable to create starter", e);
        }

    }

    private File starterDir() throws IOException {
        return SpringBootHelper.starterDir(baseDir, project.getArtifactId());
    }

    private File allStartersDir() throws IOException {
        return SpringBootHelper.allStartersDir(baseDir);
    }

    private void includeAdditionalDependencies(Document pom) throws Exception {

        Properties properties = new Properties();
        properties.load(getClass().getResourceAsStream("/spring-boot-additional-dependencies.properties"));

        String deps = properties.getProperty(project.getArtifactId());
        if (deps != null && deps.trim().length() > 0) {
            getLog().info("Spring-Boot-Starter: the following dependencies will be added to the starter: " + deps);

            XPath xpath = XPathFactory.newInstance().newXPath();
            Node dependencies = ((NodeList) xpath.compile("/project/dependencies").evaluate(pom, XPathConstants.NODESET)).item(0);

            for (String dep : deps.split(",")) {
                Element dependency = pom.createElement("dependency");
                dependencies.appendChild(dependency);

                String[] comps = dep.split("\\:");
                String groupIdStr = comps[0];
                String artifactIdStr = comps[1];
                String versionStr = comps.length > 2 ? comps[2] : null;

                Element groupId = pom.createElement("groupId");
                groupId.setTextContent(groupIdStr);
                dependency.appendChild(groupId);

                Element artifactId = pom.createElement("artifactId");
                artifactId.setTextContent(artifactIdStr);
                dependency.appendChild(artifactId);

                if (versionStr != null) {
                    Element version = pom.createElement("version");
                    version.setTextContent(versionStr);
                    dependency.appendChild(version);
                }

            }

        }

    }

    private void fixLoggingDependencies(Document pom) throws Exception {

        Set<String> loggingImpl = new HashSet<>();

        loggingImpl.add("commons-logging:commons-logging");

        loggingImpl.add("log4j:log4j");
        loggingImpl.add("log4j:apache-log4j-extras");

        // removing also the default implementation
        loggingImpl.add("ch.qos.logback:logback-core");
        loggingImpl.add("ch.qos.logback:logback-classic");

        loggingImpl.add("org.apache.logging.log4j:log4j");

        loggingImpl.add("org.slf4j:slf4j-jcl");
        loggingImpl.add("org.slf4j:slf4j-jdk14");
        loggingImpl.add("org.slf4j:slf4j-log4j12");
        loggingImpl.add("org.slf4j:slf4j-log4j13");
        loggingImpl.add("org.slf4j:slf4j-nop");
        loggingImpl.add("org.slf4j:slf4j-simple");


        Set<String> includedLibs = filterIncludedArtifacts(loggingImpl);

        if (includedLibs.size() > 0) {
            getLog().info("Spring-Boot-Starter: the following dependencies will be removed from the starter: " + includedLibs);

            XPath xpath = XPathFactory.newInstance().newXPath();
            Node dependency = ((NodeList) xpath.compile("/project/dependencies/dependency[artifactId/text() = '" + project.getArtifactId() + "']").evaluate(pom, XPathConstants.NODESET)).item(0);

            Element exclusions = pom.createElement("exclusions");

            dependency.appendChild(exclusions);

            for (String lib : includedLibs) {
                String groupIdStr = lib.split("\\:")[0];
                String artifactIdStr = lib.split("\\:")[1];

                Element exclusion = pom.createElement("exclusion");

                Element groupId = pom.createElement("groupId");
                groupId.setTextContent(groupIdStr);
                exclusion.appendChild(groupId);

                Element artifactId = pom.createElement("artifactId");
                artifactId.setTextContent(artifactIdStr);
                exclusion.appendChild(artifactId);

                exclusions.appendChild(exclusion);
            }
        }

    }

    private Set<String> filterIncludedArtifacts(Set<String> artifacts) throws DependencyTreeBuilderException {
        Set<String> included = new TreeSet<>();

        ArtifactFilter artifactFilter = new ScopeArtifactFilter(null);

        DependencyNode node = treeBuilder.buildDependencyTree(project, localRepository, artifactFactory, artifactMetadataSource, artifactFilter, artifactCollector);

        CollectingDependencyNodeVisitor visitor = new CollectingDependencyNodeVisitor();

        node.accept(visitor);

        List<DependencyNode> nodes = visitor.getNodes();
        for (DependencyNode dependencyNode : nodes) {
            int state = dependencyNode.getState();
            Artifact artifact = dependencyNode.getArtifact();

            if (state == DependencyNode.INCLUDED && !Artifact.SCOPE_TEST.equals(artifact.getScope())) {
                String canonicalName = artifact.getGroupId() + ":" + artifact.getArtifactId();
                if (artifacts.contains(canonicalName)) {
                    included.add(canonicalName);
                }
            }
        }

        return included;
    }

    private void synchronizeParentPom() throws Exception {
        File pomFile = new File(allStartersDir(), "pom.xml");
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document pom = builder.parse(pomFile);

        XPath xpath = XPathFactory.newInstance().newXPath();
        Node modules = ((NodeList) xpath.compile("/project/modules").evaluate(pom, XPathConstants.NODESET)).item(0);

        // cleanup current modules
        while (modules.hasChildNodes()) {
            modules.removeChild(modules.getFirstChild());
        }

        for (File starterDir : Arrays.asList(allStartersDir().listFiles((f, n) -> f.isDirectory() && n.endsWith(SpringBootHelper.STARTER_SUFFIX))).stream().sorted().collect(Collectors.toList())) {
            Node module = pom.createElement("module");
            module.setTextContent(starterDir.getName());
            modules.appendChild(module);
        }

        writeXmlFormatted(pom, pomFile);
    }

    private Document createBasePom() throws Exception {
        Template pomTemplate = getTemplate("spring-boot-starter-template-pom.template");
        Map<String, String> props = new HashMap<>();
        props.put("version", project.getVersion());
        props.put("componentId", getComponentId());
        props.put("componentName", project.getName());
        props.put("componentDescription", project.getDescription());

        StringWriter sw = new StringWriter();
        pomTemplate.process(props, sw);

        String xml = sw.toString();
        ByteArrayInputStream bin = new ByteArrayInputStream(xml.getBytes("UTF-8"));

        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document pom = builder.parse(bin);
        return pom;
    }

    private void writeStaticFiles() throws IOException, TemplateException {
        try (InputStream isNotice = getClass().getResourceAsStream("/spring-boot-starter-NOTICE.txt");
             FileWriter outNotice = new FileWriter(new File(starterDir(), "src/main/resources/META-INF/NOTICE.txt"));
             InputStream isLicense = getClass().getResourceAsStream("/spring-boot-starter-LICENSE.txt");
             FileWriter outLicense = new FileWriter(new File(starterDir(), "src/main/resources/META-INF/LICENSE.txt"))
        ) {
            IOUtils.copy(isNotice, outNotice);
            IOUtils.copy(isLicense, outLicense);
        }
    }

    private void writeSpringProvides() throws IOException, TemplateException {
        Template fileTemplate = getTemplate("spring-boot-starter-template-spring.provides");
        Map<String, String> props = new HashMap<>();
        props.put("artifactId", project.getArtifactId());

        File outDir = new File(starterDir(), "src/main/resources/META-INF");
        outDir.mkdirs();
        File outFile = new File(outDir, "spring.provides");

        try (FileWriter outWriter = new FileWriter(outFile)) {
            fileTemplate.process(props, outWriter);
        }
    }


    private Template getTemplate(String name) throws IOException {
        Configuration cfg = new Configuration(Configuration.getVersion());

        cfg.setTemplateLoader(new URLTemplateLoader() {
            @Override
            protected URL getURL(String name) {
                return SpringBootStarterMojo.class.getResource("/" + name);
            }
        });

        cfg.setDefaultEncoding("UTF-8");
        Template template = cfg.getTemplate(name);
        return template;
    }


    private boolean isStarterAllowed() {

        for (String ignored : IGNORE_MODULES) {
            if (ignored.equals(project.getArtifactId())) {
                getLog().info("Spring-Boot-Starter: component inside ignore list");
                return false;
            }
        }

        if (IGNORE_TEST_MODULES && project.getArtifactId().startsWith("camel-test-")) {
            getLog().info("Spring-Boot-Starter: test components are ignored");
            return false;
        }

        if (project.getPackaging() != null && !project.getPackaging().equals("jar")) {
            getLog().info("Spring-Boot-Starter: ignored for wrong packaging");
            return false;
        }

        // include 'camel-core'
        if (baseDir.getName().equals("camel-core")) {
            return true;
        }

        // Build a starter for all components under the 'components' dir and include submodules ending with '-component'
        if (baseDir.getParentFile().getName().equals("components") || baseDir.getName().endsWith("-component")) {
            return true;
        }

        getLog().info("Spring-Boot-Starter: component directory mismatch");
        return false;
    }


    private String getComponentId() {
        String componentName = project.getArtifact().getArtifactId();
        String componentId = componentName.replace("camel-", "");
        return componentId;
    }

    private void writeXmlFormatted(Document xml, File destination) throws Exception {

        OutputFormat format = new OutputFormat(xml);
        format.setLineWidth(200);
        format.setIndenting(true);
        format.setIndent(4);

        StringWriter sw = new StringWriter();
        XMLSerializer serializer = new XMLSerializer(sw, format);
        serializer.serialize(xml);

        // Fix the output (cannot find a good serializer)
        // The apache header is put in the wrong location
        StringBuilder b = new StringBuilder(sw.toString());
        int lastTagLoc = b.lastIndexOf("<");
        int lastCloseHeaderLoc = b.lastIndexOf("-->");
        if (lastCloseHeaderLoc > lastTagLoc) {
            // The apache header has been put at the end
            int headerLoc = b.lastIndexOf("<!--");
            String apacheHeader = b.substring(headerLoc, lastCloseHeaderLoc + 3);
            b.delete(headerLoc, lastCloseHeaderLoc + 3);

            int pos = b.indexOf("?>");
            if (pos > 0) {
                b.insert(pos + 2, "\n" + apacheHeader);
            } else {
                b.insert(0, apacheHeader);
            }
        }


        try (Writer out = new FileWriter(destination)) {
            IOUtils.write(b.toString(), out);
        }

    }

}
