package com.example.demo.common.trace.logtrace;

import com.example.demo.common.trace.logtrace.domain.TraceId;
import com.example.demo.common.trace.logtrace.domain.TraceStatus;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MdcLogTrace implements LogTrace {

    private static final String START_PREFIX = "-->";
    private static final String COMPLETE_PREFIX = "<--";
    private static final String EX_PREFIX = "<x-";
    private ThreadLocal<TraceId> traceHolder = new ThreadLocal<>();

    @Override
    public TraceStatus begin(String message) {
        syncTraceId();
        TraceId traceId = traceHolder.get();
        long startTimeMs = System.currentTimeMillis();
        log.info("{}{}", addSpace(START_PREFIX, traceId.getLevel()), message);
        return new TraceStatus(traceId, startTimeMs, message);
    }
    @Override
    public void end(TraceStatus status) {
        complete(status, null);
    }
    @Override
    public void exception(TraceStatus status, Exception e) {
        complete(status,e);
    }
    private void complete(TraceStatus status, Exception e){
        long endTimeMs = System.currentTimeMillis();
        long elapsedTimeMs = endTimeMs - status.getStartTimeMs();
        TraceId traceId = status.getTraceId();
        if (e==null){
            log.info("{}{} time={}ms", addSpace(COMPLETE_PREFIX, traceId.getLevel()), status.getMessage(), elapsedTimeMs);
        }else{
            log.error("{}{} ex={} time={}ms ", addSpace(EX_PREFIX, traceId.getLevel()), status.getMessage(), e.toString(), elapsedTimeMs);
        }
        releaseTraceId();
    }

    private void syncTraceId(){
        TraceId traceId = traceHolder.get();
        if(traceId ==null){
            TraceId newTraceId = new TraceId();
            traceHolder.set(newTraceId);
            MDC.put("traceId",newTraceId.getId());
        }else{
            traceHolder.set(traceId.createNextId());
        }
    }
    private void releaseTraceId(){
        TraceId traceId = traceHolder.get();
        if(traceId.isFirstLevel()){
            traceHolder.remove();
            MDC.clear();
        }else{
            traceHolder.set(traceId.createPreviousId());
        }
    }

    private static String addSpace(String prefix, int level) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<level;i++){
            stringBuilder.append((i == level - 1) ? "|" + prefix : "|   ");
        }
        return stringBuilder.toString();
    }
}
