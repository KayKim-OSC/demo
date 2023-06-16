package com.example.demo.common.aspect;

import com.example.demo.common.trace.logtrace.LogTrace;
import com.example.demo.common.trace.logtrace.domain.TraceStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class LogTraceAspect {

    private final LogTrace logTrace;

    @Around("execution(* com.example.demo.bankApp..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        TraceStatus traceStatus = null;
        try{
            String message = joinPoint.getSignature().toShortString();
            traceStatus = logTrace.begin(message);
            Object result = joinPoint.proceed();
            logTrace.end(traceStatus);
            return result;

        }catch(Exception e){
            logTrace.exception(traceStatus, e);
            throw e;
        }
    }
}
