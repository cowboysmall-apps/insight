package com.cowboysmall.insight.aspect;

import com.cowboysmall.insight.Traceable;
import com.cowboysmall.insight.service.LoggerService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/**
 * jerry
 */

@Aspect
@Component
public class TracingAspect {

    private Set<Throwable> exceptions = Collections.newSetFromMap(new WeakHashMap<>());


    @Autowired
    private LoggerService loggerService;

    @Value("${tracing.before:entering < %s > with args %s}")
    private String beforeString;

    @Value("${tracing.afterThrowing:exception thrown by < %s > with args %s with message '%s'}")
    private String afterThrowingString;

    @Value("${tracing.afterReturning:leaving < %s > returning %s}")
    private String afterReturningString;


    //_________________________________________________________________________

    @Before(value = "@annotation(traceable)", argNames = "joinPoint, traceable")
    public void before(JoinPoint joinPoint, Traceable traceable) {

        loggerService.log(
                traceable.value(),
                joinPoint.getTarget().getClass(),
                String.format(
                        beforeString,
                        joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs())
                ),
                null
        );
    }

    @AfterThrowing(value = "@annotation(traceable)", throwing = "throwable", argNames = "joinPoint, traceable, throwable")
    public void afterThrowing(JoinPoint joinPoint, Traceable traceable, Throwable throwable) {

        loggerService.log(
                traceable.value(),
                joinPoint.getTarget().getClass(),
                String.format(
                        afterThrowingString,
                        joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()),
                        throwable.getMessage()
                ),
                exceptions.contains(throwable) || exceptions.contains(throwable.getCause())
                        ? null
                        : throwable
        );

        exceptions.add(throwable);
    }

    @AfterReturning(value = "@annotation(traceable)", returning = "returnValue", argNames = "joinPoint, traceable, returnValue")
    public void afterReturning(JoinPoint joinPoint, Traceable traceable, Object returnValue) {

        loggerService.log(
                traceable.value(),
                joinPoint.getTarget().getClass(),
                String.format(
                        afterReturningString,
                        joinPoint.getSignature().getName(),
                        returnValue != null && returnValue.getClass().isArray()
                                ? Arrays.toString((Object[]) returnValue)
                                : returnValue
                ),
                null
        );
    }
}
