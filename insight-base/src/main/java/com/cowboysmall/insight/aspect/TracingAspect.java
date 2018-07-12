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

import static com.cowboysmall.insight.util.ExceptionUtils.rootCause;
import static java.lang.String.format;

/**
 * jerry
 */

@Aspect
@Component
public class TracingAspect {

    private Set<Throwable> throwables = Collections.newSetFromMap(new WeakHashMap<>());


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

        loggerService.log(
                traceable.value(),
                joinPoint.getTarget().getClass(),
                format(
                        beforeString,
                        joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs())
                )
        );
    }

    @AfterThrowing(value = "@annotation(traceable)", throwing = "throwable", argNames = "joinPoint, traceable, throwable")
    public void afterThrowing(JoinPoint joinPoint, Traceable traceable, Throwable throwable) {

        Throwable rootCause = rootCause(throwable);

        if (throwables.contains(rootCause))
            loggerService.log(
                    traceable.value(),
                    joinPoint.getTarget().getClass(),
                    format(
                            afterThrowingString,
                            joinPoint.getSignature().getName(),
                            Arrays.toString(joinPoint.getArgs()),
                            throwable.getMessage()
                    )
            );
        else
            loggerService.log(
                    traceable.value(),
                    joinPoint.getTarget().getClass(),
                    format(
                            afterThrowingString,
                            joinPoint.getSignature().getName(),
                            Arrays.toString(joinPoint.getArgs()),
                            throwable.getMessage()
                    ),
                    throwable
            );

        throwables.add(rootCause);
    }

    @AfterReturning(value = "@annotation(traceable)", returning = "returnValue", argNames = "joinPoint, traceable, returnValue")
    public void afterReturning(JoinPoint joinPoint, Traceable traceable, Object returnValue) {

        loggerService.log(
                traceable.value(),
                joinPoint.getTarget().getClass(),
                format(
                        afterReturningString,
                        joinPoint.getSignature().getName(),
                        returnValue != null && returnValue.getClass().isArray()
                                ? Arrays.toString((Object[]) returnValue)
                                : returnValue
                )
        );
    }
}
