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
package org.apache.camel.model;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.camel.Expression;
import org.apache.camel.Predicate;
import org.apache.camel.Processor;
import org.apache.camel.builder.ExpressionBuilder;
import org.apache.camel.builder.ExpressionClause;
import org.apache.camel.model.language.ExpressionDefinition;
import org.apache.camel.processor.FilterProcessor;
import org.apache.camel.processor.Throttler;
import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.RouteContext;

/**
 * Controls the rate at which messages are passed to the next node in the route
 *
 * @version 
 */
@Metadata(label = "eip,routing")
@XmlRootElement(name = "throttle")
@XmlAccessorType(XmlAccessType.FIELD)
public class ThrottleDefinition extends NoOutputDefinition<ThrottleDefinition> implements ExecutorServiceAwareDefinition<ThrottleDefinition> {

    @XmlElement(name = "correlationExpression")
    private ExpressionSubElementDefinition correlationExpression;
    @XmlTransient
    private ExecutorService executorService;
    @XmlTransient
    private ExpressionDefinition expression;
    @XmlAttribute
    private String executorServiceRef;
    @XmlAttribute @Metadata(defaultValue = "1000")
    private Long timePeriodMillis;
    @XmlAttribute
    private Boolean asyncDelayed;
    @XmlAttribute @Metadata(defaultValue = "true")
    private Boolean callerRunsWhenRejected;
    @XmlAttribute
    private Boolean rejectExecution;
    
    public ThrottleDefinition() {
    }
    
    public ThrottleDefinition(Predicate predicate) {
        if (predicate != null) {
            setExpression(ExpressionNodeHelper.toExpressionDefinition(predicate));
        }
    }

    public ThrottleDefinition(Expression maximumRequestsPerPeriod) {
    	if (maximumRequestsPerPeriod != null) {
            setExpression(ExpressionNodeHelper.toExpressionDefinition(maximumRequestsPerPeriod));
        }
    }

    public ThrottleDefinition(Expression maximumRequestsPerPeriod, Expression correlationExpression) {
        this(ExpressionNodeHelper.toExpressionDefinition(maximumRequestsPerPeriod), correlationExpression);
    }

    private ThrottleDefinition(ExpressionDefinition maximumRequestsPerPeriod, Expression correlationExpression) {
    	if (maximumRequestsPerPeriod != null) {
            setExpression(maximumRequestsPerPeriod);
        }

        ExpressionSubElementDefinition cor = new ExpressionSubElementDefinition();
        cor.setExpressionType(ExpressionNodeHelper.toExpressionDefinition(correlationExpression));
        setCorrelationExpression(cor);
    }

    @Override
    public String toString() {
        return "Throttle[" + description() + " -> " + getOutputs() + "]";
    }
    
    protected String description() {
        return getExpression() + " request per " + getTimePeriodMillis() + " millis";
    }

    @Override
    public String getLabel() {
        return "throttle[" + description() + "]";
    }

    @Override
    public Processor createProcessor(RouteContext routeContext) throws Exception {
        Processor childProcessor = this.createChildProcessor(routeContext, true);

        boolean async = getAsyncDelayed() != null && getAsyncDelayed();
        boolean shutdownThreadPool = ProcessorDefinitionHelper.willCreateNewThreadPool(routeContext, this, async);
        ScheduledExecutorService threadPool = ProcessorDefinitionHelper.getConfiguredScheduledExecutorService(routeContext, "Throttle", this, async);
        
        // should be default 1000 millis
        long period = getTimePeriodMillis() != null ? getTimePeriodMillis() : 1000L;

        // max requests per period is mandatory
        Expression maxRequestsExpression = createMaxRequestsPerPeriodExpression(routeContext);
        if (maxRequestsExpression == null) {
            throw new IllegalArgumentException("MaxRequestsPerPeriod expression must be provided on " + this);
        }
        
        Expression correlation = null;
        if (correlationExpression != null) {
            correlation = correlationExpression.createExpression(routeContext);
        }

        boolean reject = getRejectExecution() != null && getRejectExecution();
        Throttler answer = new Throttler(routeContext.getCamelContext(), childProcessor, maxRequestsExpression, period, threadPool, shutdownThreadPool, reject, correlation);

        answer.setAsyncDelayed(async);
        if (getCallerRunsWhenRejected() == null) {
            // should be true by default
            answer.setCallerRunsWhenRejected(true);
        } else {
            answer.setCallerRunsWhenRejected(getCallerRunsWhenRejected());
        }

        return answer;
    }

    private Expression createMaxRequestsPerPeriodExpression(RouteContext routeContext) {
        ExpressionDefinition expr = getExpression();
        if (expr != null) {
            return expr.createExpression(routeContext);
        }
        return null;
    }
    
    // Fluent API
    // -------------------------------------------------------------------------
    /**
     * Sets the time period during which the maximum request count is valid for
     *
     * @param timePeriodMillis  period in millis
     * @return the builder
     */
    public ThrottleDefinition timePeriodMillis(long timePeriodMillis) {
        setTimePeriodMillis(timePeriodMillis);
        return this;
    }
    
    /**
     * Sets the time period during which the maximum request count per period
     *
     * @param maximumRequestsPerPeriod  the maximum request count number per time period
     * @return the builder
     */
    public ThrottleDefinition maximumRequestsPerPeriod(long maximumRequestsPerPeriod) {
        setExpression(ExpressionNodeHelper.toExpressionDefinition(ExpressionBuilder.constantExpression(maximumRequestsPerPeriod)));
        return this;
    }

    /**
     * Whether or not the caller should run the task when it was rejected by the thread pool.
     * <p/>
     * Is by default <tt>true</tt>
     *
     * @param callerRunsWhenRejected whether or not the caller should run
     * @return the builder
     */
    public ThrottleDefinition callerRunsWhenRejected(boolean callerRunsWhenRejected) {
        setCallerRunsWhenRejected(callerRunsWhenRejected);
        return this;
    }

    /**
     * Enables asynchronous delay which means the thread will <b>not</b> block while delaying.
     *
     * @return the builder
     */
    public ThrottleDefinition asyncDelayed() {
        setAsyncDelayed(true);
        return this;
    }
    
    /**
     * Whether or not throttler throws the ThrottlerRejectedExecutionException when the exchange exceeds the request limit
     * <p/>
     * Is by default <tt>false</tt>
     *
     * @param rejectExecution throw the RejectExecutionException if the exchange exceeds the request limit 
     * @return the builder
     */
    public ThrottleDefinition rejectExecution(boolean rejectExecution) {
        setRejectExecution(rejectExecution);
        return this;
    }

    /**
     * To use a custom thread pool (ScheduledExecutorService) by the throttler.
     *
     * @param executorService  the custom thread pool (must be scheduled)
     * @return the builder
     */
    public ThrottleDefinition executorService(ExecutorService executorService) {
        setExecutorService(executorService);
        return this;
    }

    /**
     * To use a custom thread pool (ScheduledExecutorService) by the throttler.
     *
     * @param executorServiceRef the reference id of the thread pool (must be scheduled)
     * @return the builder
     */
    public ThrottleDefinition executorServiceRef(String executorServiceRef) {
        setExecutorServiceRef(executorServiceRef);
        return this;
    }

    // Properties
    // -------------------------------------------------------------------------

    public Long getTimePeriodMillis() {
        return timePeriodMillis;
    }

    public void setTimePeriodMillis(Long timePeriodMillis) {
        this.timePeriodMillis = timePeriodMillis;
    }

    public Boolean getAsyncDelayed() {
        return asyncDelayed;
    }

    public void setAsyncDelayed(Boolean asyncDelayed) {
        this.asyncDelayed = asyncDelayed;
    }

    public Boolean getCallerRunsWhenRejected() {
        return callerRunsWhenRejected;
    }

    public void setCallerRunsWhenRejected(Boolean callerRunsWhenRejected) {
        this.callerRunsWhenRejected = callerRunsWhenRejected;
    }

    public ExecutorService getExecutorService() {
        return executorService;
    }

    public void setExecutorService(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public String getExecutorServiceRef() {
        return executorServiceRef;
    }

    public void setExecutorServiceRef(String executorServiceRef) {
        this.executorServiceRef = executorServiceRef;
    }
    
    public Boolean getRejectExecution() {
        return rejectExecution;
    }

    public void setRejectExecution(Boolean rejectExecution) {
        this.rejectExecution = rejectExecution;
    }

    /**
     * The expression used to calculate the correlation key to use for throttle grouping.
     * The Exchange which has the same correlation key is throttled together.
     */
    public void setCorrelationExpression(ExpressionSubElementDefinition correlationExpression) {
        this.correlationExpression = correlationExpression;
    }
    
    /**
     * Expression to configure the maximum number of messages to throttle per request
     */
    public void setExpression(ExpressionDefinition expression) {
    	// favour using the helper to set the expression as it can unwrap some unwanted builders when using Java DSL
        if (expression instanceof Expression) {
            this.expression = ExpressionNodeHelper.toExpressionDefinition((Expression) expression);
        } else if (expression instanceof Predicate) {
            this.expression = ExpressionNodeHelper.toExpressionDefinition((Predicate) expression);
        } else {
            this.expression = expression;
        }
    }
    
    public ExpressionDefinition getExpression() {
    	return expression;
    }
    
    public Expression getExpressionValue() {
    	return expression.getExpressionValue();
    }

    public ExpressionSubElementDefinition getCorrelationExpression() {
        return correlationExpression;
    }
	
	/**
     * Creates the {@link FilterProcessor} from the expression node.
     *
     * @param routeContext  the route context
     * @return the created {@link FilterProcessor}
     * @throws Exception is thrown if error creating the processor
     */
    protected FilterProcessor createFilterProcessor(RouteContext routeContext) throws Exception {
        Processor childProcessor = createOutputsProcessor(routeContext);
        return new FilterProcessor(createPredicate(routeContext), childProcessor);
    }

    /**
     * Creates the {@link Predicate} from the expression node.
     *
     * @param routeContext  the route context
     * @return the created predicate
     */
    protected Predicate createPredicate(RouteContext routeContext) {
        return getExpression().createPredicate(routeContext);
    }
	
	@Override
    public void configureChild(ProcessorDefinition<?> output) {
        // reuse the logic from pre create processor
        preCreateProcessor();
    }

    @Override
    protected void preCreateProcessor() {
        Expression exp = expression;
        if (expression != null && expression.getExpressionValue() != null) {
            exp = expression.getExpressionValue();
        }

        if (exp instanceof ExpressionClause) {
            ExpressionClause<?> clause = (ExpressionClause<?>) exp;
            if (clause.getExpressionType() != null) {
                // if using the Java DSL then the expression may have been set using the
                // ExpressionClause which is a fancy builder to define expressions and predicates
                // using fluent builders in the DSL. However we need afterwards a callback to
                // reset the expression to the expression type the ExpressionClause did build for us
                expression = clause.getExpressionType();
            }
        }

        if (expression != null && expression.getExpression() == null) {
            // use toString from predicate or expression so we have some information to show in the route model
            if (expression.getPredicate() != null) {
                expression.setExpression(expression.getPredicate().toString());
            } else if (expression.getExpressionValue() != null) {
                expression.setExpression(expression.getExpressionValue().toString());
            }
        }
    }
    
    @Override
    public void setKeyedExpression(ExpressionDefinition keyExpression) {
        setExpression(keyExpression);
    }
}
