package org.springframework.cloud.sleuth;

public interface TraceOperations {

    <T> T trace(String spanName, TraceCallback<T> action) throws Exception;

    <T> T trace(String spanName, Span parent, TraceCallback<T> action) throws Exception;

    <T, X> T trace(String spanName, Sampler<X> xSampler, X xInfo, TraceCallback<T> action) throws Exception;
}
