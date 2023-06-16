package com.example.demo.common.trace.logtrace;

import com.example.demo.common.trace.logtrace.domain.TraceStatus;

public interface LogTrace {
    TraceStatus begin(String message);
    void end(TraceStatus traceStatus);
    void exception(TraceStatus status, Exception e);
}
