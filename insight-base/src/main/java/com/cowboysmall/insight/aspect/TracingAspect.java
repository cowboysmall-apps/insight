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

import static java.lang.String.format;

/**
 * jerry
 */

@Aspect
@Component
public class TracingAspect {

    private Set<Throwable> exceptions = Collections.newSetFromMap(new WeakHashMap<>());


    @Autowired
    private LoggerService loggerService;


    @Value("${insight.tracing.before:entering < %s > with args %s}")
    private String beforeString;

    @Value("${insight.tracing.afterThrowing:exception thrown by < %s > with args %s with message '%s'}")
    private String afterThrowingString;

    @Value("${insight.tracing.afterReturning:leaving < %s > returning %s}")
    private String afterReturningString;


    //_________________________________________________________________________

    @Before(value = "@annotation(traceable)", argNames = "joinPoint, traceable")
    public void before(JoinPoint joinPoint, Traceable traceable) {

        String message = format(
                beforeString,
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs())
        );

        loggerService.log(
                traceable.value(),
                joinPoint.getTarget().getClass(),
                message,
                null
        );
    }

    @AfterThrowing(value = "@annotation(traceable)", throwing = "throwable", argNames = "joinPoint, traceable, throwable")
    public void afterThrowing(JoinPoint joinPoint, Traceable traceable, Throwable throwable) {

        String message = format(
                afterThrowingString,
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs()),
                throwable.getMessage()
        );

        loggerService.log(
                traceable.value(),
                joinPoint.getTarget().getClass(),
                message,
                exceptions.contains(throwable) || exceptions.contains(throwable.getCause()) ? null : throwable
        );

        exceptions.add(throwable);
    }

    @AfterReturning(value = "@annotation(traceable)", returning = "returnValue", argNames = "joinPoint, traceable, returnValue")
    public void afterReturning(JoinPoint joinPoint, Traceable traceable, Object returnValue) {

        String message = format(
                afterReturningString,
                joinPoint.getSignature().getName(),
                returnValue != null && returnValue.getClass().isArray() ? Arrays.toString((Object[]) returnValue) : returnValue
        );

        loggerService.log(
                traceable.value(),
                joinPoint.getTarget().getClass(),
                message,
                null
        );
    }
}
