package org.springframework.cloud.sleuth;

public interface TraceCallback<T> {
    T doInSpan(TraceScope scope) throws Exception;
}
