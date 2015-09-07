package org.springframework.cloud.sleuth;

/**
 * @author Josh Long
 */
public class TraceTemplate implements TraceOperations {

    private final Trace trace;

    public TraceTemplate(Trace trace) {
        this.trace = trace;
    }

    public <T> T trace(String spanName, TraceCallback<T> action) throws Exception {
        try (TraceScope scope = this.trace.startSpan(spanName)) {
            return action.doInSpan(scope);
        }
    }

    public <T> T trace(String spanName, Span parent, TraceCallback<T> action) throws Exception {
        try (TraceScope scope = this.trace.startSpan(spanName, parent)) {
            return action.doInSpan(scope);
        }
    }

    public <T, X> T trace(String spanName, Sampler<X> xSampler, X xInfo, TraceCallback<T> action) throws Exception {
        try (TraceScope scope = this.trace.startSpan(spanName, xSampler, xInfo)) {
            return action.doInSpan(scope);
        }
    }
}
