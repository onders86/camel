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
package org.apache.camel.component.robotframework;

import java.io.File;

import org.apache.camel.RuntimeCamelException;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriParams;

@UriParams
public class RobotFrameworkCamelConfiguration implements Cloneable {

    /**
     * Sets the name of the top-level tests suites.
     */
    @UriParam
    private String name;

    /**
     * Sets the documentation of the top-level tests suites.
     */
    @UriParam
    private String document;

    /**
     * Sets free metadata for the top level tests suites.
     * List<String>
     */
    @UriParam
    private String metadata;

    /**
     * Sets the tags(s) to all executed tests cases.
     * List<String>
     */
    @UriParam
    private String tags;

    /**
     * Selects the tests cases by name.
     * List<String>
     */
    @UriParam
    private String tests;

    /**
     * Selects the tests suites by name.
     * List<String>
     */
    @UriParam
    private String suites;

    /**
     * Selects the tests cases by tags.
     * List<String>
     */
    @UriParam
    private String includes;

    /**
     * Selects the tests cases by tags.
     * List<String>
     */
    @UriParam
    private String excludes;
    
    /**
     * Tests that have the given tags are considered critical.
     * List<String>
     */
    @UriParam
    private String criticalTags;

    /**
     * Tests that have the given tags are not critical.
     * List<String>
     */
    @UriParam
    private String nonCriticalTags;

    /**
     * Sets the execution mode for this tests run. Note that this setting has
     * been deprecated in Robot Framework 2.8. Use separate dryryn,
     * skipTeardownOnExit, exitOnFailure, and randomize settings instead.
     */
    @UriParam
    private String runMode;

    /**
     * Sets dryrun mode on use. In the dry run mode tests are run without
     * executing keywords originating from test libraries. Useful for
     * validating test data syntax.
     */
    @UriParam(defaultValue = "false")
    private boolean dryrun;

    /**
     * Sets whether the teardowns are skipped if the test
     * execution is prematurely stopped.
     */
    @UriParam(defaultValue = "false")
    private boolean skipTeardownOnExit;

    /**
     * Sets robot to stop execution immediately if a critical test fails.
     */
    @UriParam(defaultValue = "false")
    private boolean exitOnFailure;

    /**
     * Sets the test execution order to be randomized. Valid values are all,
     * suite, and test
     */
    @UriParam
    private String randomize;

    /**
     * Sets individual variables. Use the format "name:value"
     * List<String>
     */
    @UriParam
    private String variables;

    /**
     * Sets variables using variables files. Use the format "path:args"
     * List<String>
     */
    private String variableFiles;
    
    /**
     * Configures where generated reports are to be placed.
     */
    @UriParam
    private File outputDirectory;

    /**
     * Sets the path to the generated output file.
     */
    @UriParam
    private File output;

    /**
     * Sets the path to the generated log file.
     */
    @UriParam
    private File log;

    /**
     * Sets the path to the generated report file.
     */
    @UriParam
    private File report;

    /**
     * Sets the path to the generated XUnit compatible result file, relative to outputDirectory. The
     * file is in xml format. By default, the file name is derived from the testCasesDirectory
     * parameter, replacing blanks in the directory name by underscores.
     */
    @UriParam
    private File xunitFile;

    /**
     * A debug file that is written during execution.
     */
    @UriParam
    private File debugFile;

    /**
     * Adds a timestamp to all output files.
     */
    @UriParam
    private boolean timestampOutputs;

    /**
     * Splits output and log files.
     */
    @UriParam
    private String splitOutputs;

    /**
     * Sets a title for the generated tests log.
     */
    @UriParam
    private String logTitle;

    /**
     * Sets a title for the generated tests report.
     */
    @UriParam
    private String reportTitle;

    /**
     * Sets a title for the generated summary report.
     */
    @UriParam
    private String summaryTitle;

    /**
     * Sets background colors for the generated report and summary.
     */
    @UriParam
    private String reportBackground;

    /**
     * Sets the threshold level for logging.
     */
    @UriParam
    private String logLevel;

    /**
     * Defines how many levels to show in the Statistics by Suite table in outputs.
     */
    @UriParam
    private String suiteStatLevel;

    /**
     * Includes only these tags in the Statistics by Tag and Test Details by Tag tables in outputs.
     * List<String>
     */
    @UriParam
    private String tagStatIncludes;

    /**
     * Excludes these tags from the Statistics by Tag and Test Details by Tag tables in outputs.
     * List<String>
     */
    @UriParam
    private String tagStatExcludes;

    /**
     * Creates combined statistics based on tags. Use the format "tags:title"
     * List<String>
     */
    @UriParam
    private String combinedTagStats;

    /**
     * Adds documentation to the specified tags.
     * List<String>
     */
    @UriParam
    private String tagDocs;

    /**
     * Adds external links to the Statistics by Tag table in outputs. Use the format
     * "pattern:link:title"
     * List<String>
     */
    @UriParam
    private String tagStatLinks;

    /**
     * Sets multiple listeners for monitoring tests execution. Use the format "ListenerWithArgs:arg1:arg2" or
     * simply "ListenerWithoutArgs"
     * List<String>
     */
    @UriParam
    private String listeners;

    /**
     * Sets a single listener for monitoring tests execution
     */
    @UriParam
    private String listener;

    /**
     * Show a warning when an invalid file is skipped.
     */
    @UriParam
    private boolean warnOnSkippedFiles;

    /**
     * Width of the monitor output. Default is 78.
     */
    @UriParam(defaultValue = "78")
    private String monitorWidth;

    /**
     * Using ANSI colors in console. Normally colors work in unixes but not in Windows. Default is
     * 'on'.
     * <ul>
     * <li>'on' - use colors in unixes but not in Windows</li>
     * <li>'off' - never use colors</li>
     * <li>'force' - always use colors (also in Windows)</li>
     * </ul>
     */
    @UriParam
    private String monitorColors;

    /**
     * A text file to read more arguments from.
     */
    @UriParam
    private File argumentFile;

    /**
     * Executes tests also if the top level test suite is empty. Useful e.g. with
     * --include/--exclude when it is not an error that no test matches the condition.
     */
    @UriParam(defaultValue = "false")
    private boolean runEmptySuite;

    /**
     * Re-run failed tests, based on output.xml file.
     */
    @UriParam
    private File runFailed;


    /**
     * If true, sets the return code to zero regardless of failures in test cases. Error codes are
     * returned normally.
     */
    @UriParam(defaultValue = "false")
    private boolean noStatusReturnCode;


    public String getName() {
        return name;
    }


    public String getDocument() {
        return document;
    }


    public String getMetadata() {
        return metadata;
    }


    public String getTags() {
        return tags;
    }


    public String getTests() {
        return tests;
    }


    public String getSuites() {
        return suites;
    }


    public String getIncludes() {
        return includes;
    }


    public String getExcludes() {
        return excludes;
    }


    public String getCriticalTags() {
        return criticalTags;
    }


    public String getNonCriticalTags() {
        return nonCriticalTags;
    }


    public String getRunMode() {
        return runMode;
    }


    public boolean isDryrun() {
        return dryrun;
    }


    public boolean isSkipTeardownOnExit() {
        return skipTeardownOnExit;
    }


    public boolean isExitOnFailure() {
        return exitOnFailure;
    }


    public String getRandomize() {
        return randomize;
    }


    public String getVariables() {
        return variables;
    }


    public String getVariableFiles() {
        return variableFiles;
    }

    public File getOutputDirectory() {
        return outputDirectory;
    }

    public File getOutput() {
        return output;
    }


    public File getLog() {
        return log;
    }


    public File getReport() {
        return report;
    }


    public File getXunitFile() {
        return xunitFile;
    }


    public File getDebugFile() {
        return debugFile;
    }


    public boolean isTimestampOutputs() {
        return timestampOutputs;
    }


    public String getSplitOutputs() {
        return splitOutputs;
    }


    public String getLogTitle() {
        return logTitle;
    }


    public String getReportTitle() {
        return reportTitle;
    }


    public String getSummaryTitle() {
        return summaryTitle;
    }


    public String getReportBackground() {
        return reportBackground;
    }


    public String getLogLevel() {
        return logLevel;
    }


    public String getSuiteStatLevel() {
        return suiteStatLevel;
    }


    public String getTagStatIncludes() {
        return tagStatIncludes;
    }


    public String getTagStatExcludes() {
        return tagStatExcludes;
    }


    public String getCombinedTagStats() {
        return combinedTagStats;
    }


    public String getTagDocs() {
        return tagDocs;
    }


    public String getTagStatLinks() {
        return tagStatLinks;
    }


    public String getListeners() {
        return listeners;
    }


    public String getListener() {
        return listener;
    }


    public boolean isWarnOnSkippedFiles() {
        return warnOnSkippedFiles;
    }


    public String getMonitorWidth() {
        return monitorWidth;
    }


    public String getMonitorColors() {
        return monitorColors;
    }


    public File getArgumentFile() {
        return argumentFile;
    }


    public boolean isRunEmptySuite() {
        return runEmptySuite;
    }


    public File getRunFailed() {
        return runFailed;
    }


    public boolean isNoStatusReturnCode() {
        return noStatusReturnCode;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setDocument(String document) {
        this.document = document;
    }


    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }


    public void setTags(String tags) {
        this.tags = tags;
    }


    public void setTests(String tests) {
        this.tests = tests;
    }


    public void setSuites(String suites) {
        this.suites = suites;
    }


    public void setIncludes(String includes) {
        this.includes = includes;
    }


    public void setExcludes(String excludes) {
        this.excludes = excludes;
    }


    public void setCriticalTags(String criticalTags) {
        this.criticalTags = criticalTags;
    }


    public void setNonCriticalTags(String nonCriticalTags) {
        this.nonCriticalTags = nonCriticalTags;
    }


    public void setRunMode(String runMode) {
        this.runMode = runMode;
    }


    public void setDryrun(boolean dryrun) {
        this.dryrun = dryrun;
    }


    public void setSkipTeardownOnExit(boolean skipTeardownOnExit) {
        this.skipTeardownOnExit = skipTeardownOnExit;
    }


    public void setExitOnFailure(boolean exitOnFailure) {
        this.exitOnFailure = exitOnFailure;
    }


    public void setRandomize(String randomize) {
        this.randomize = randomize;
    }


    public void setVariables(String variables) {
        this.variables = variables;
    }


    public void setVariableFiles(String variableFiles) {
        this.variableFiles = variableFiles;
    }

    public void setOutputDirectory(File outputDirectory) {
        this.outputDirectory = outputDirectory;
    }

    public void setOutput(File output) {
        this.output = output;
    }


    public void setLog(File log) {
        this.log = log;
    }


    public void setReport(File report) {
        this.report = report;
    }


    public void setXunitFile(File xunitFile) {
        this.xunitFile = xunitFile;
    }


    public void setDebugFile(File debugFile) {
        this.debugFile = debugFile;
    }


    public void setTimestampOutputs(boolean timestampOutputs) {
        this.timestampOutputs = timestampOutputs;
    }


    public void setSplitOutputs(String splitOutputs) {
        this.splitOutputs = splitOutputs;
    }


    public void setLogTitle(String logTitle) {
        this.logTitle = logTitle;
    }


    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }


    public void setSummaryTitle(String summaryTitle) {
        this.summaryTitle = summaryTitle;
    }


    public void setReportBackground(String reportBackground) {
        this.reportBackground = reportBackground;
    }


    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }


    public void setSuiteStatLevel(String suiteStatLevel) {
        this.suiteStatLevel = suiteStatLevel;
    }


    public void setTagStatIncludes(String tagStatIncludes) {
        this.tagStatIncludes = tagStatIncludes;
    }


    public void setTagStatExcludes(String tagStatExcludes) {
        this.tagStatExcludes = tagStatExcludes;
    }


    public void setCombinedTagStats(String combinedTagStats) {
        this.combinedTagStats = combinedTagStats;
    }


    public void setTagDocs(String tagDocs) {
        this.tagDocs = tagDocs;
    }


    public void setTagStatLinks(String tagStatLinks) {
        this.tagStatLinks = tagStatLinks;
    }


    public void setListeners(String listeners) {
        this.listeners = listeners;
    }


    public void setListener(String listener) {
        this.listener = listener;
    }


    public void setWarnOnSkippedFiles(boolean warnOnSkippedFiles) {
        this.warnOnSkippedFiles = warnOnSkippedFiles;
    }


    public void setMonitorWidth(String monitorWidth) {
        this.monitorWidth = monitorWidth;
    }


    public void setMonitorColors(String monitorColors) {
        this.monitorColors = monitorColors;
    }


    public void setArgumentFile(File argumentFile) {
        this.argumentFile = argumentFile;
    }


    public void setRunEmptySuite(boolean runEmptySuite) {
        this.runEmptySuite = runEmptySuite;
    }


    public void setRunFailed(File runFailed) {
        this.runFailed = runFailed;
    }


    public void setNoStatusReturnCode(boolean noStatusReturnCode) {
        this.noStatusReturnCode = noStatusReturnCode;
    }


    public RobotFrameworkCamelConfiguration copy() {
        try {
            return (RobotFrameworkCamelConfiguration)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeCamelException(e);
        }
    }

}
