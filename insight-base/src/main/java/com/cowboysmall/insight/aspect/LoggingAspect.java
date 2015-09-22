package com.cowboysmall.insight.aspect;

import com.cowboysmall.insight.Loggable;
import com.cowboysmall.insight.service.MessageService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
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
public class LoggingAspect {

    private Set<Throwable> exceptions = Collections.newSetFromMap(new WeakHashMap<>());


    @Autowired
    private MessageService messageService;


    //_________________________________________________________________________

    @Before(value = "@annotation(insightLogging)", argNames = "joinPoint, insightLogging")
    public void before(JoinPoint joinPoint, Loggable loggable) {

        messageService.message(
                loggable.value(),
                joinPoint.getTarget().getClass(),
                String.format(
                        "[ entering < %s > with args %s ]",
                        joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs())
                )
        );
    }

    @AfterThrowing(value = "@annotation(insightLogging)", throwing = "throwable", argNames = "joinPoint, insightLogging, throwable")
    public void afterThrowing(JoinPoint joinPoint, Loggable loggable, Throwable throwable) {

        if (!exceptions.contains(throwable) && !exceptions.contains(throwable.getCause())) {

            messageService.message(
                    loggable.value(),
                    joinPoint.getTarget().getClass(),
                    String.format(
                            "[ exception thrown by < %s > with args %s with message %s ]",
                            joinPoint.getSignature().getName(),
                            Arrays.toString(joinPoint.getArgs()),
                            throwable.getMessage()
                    ),
                    throwable
            );
            exceptions.add(throwable);

        } else {

            messageService.message(
                    loggable.value(),
                    joinPoint.getTarget().getClass(),
                    String.format(
                            "[ exception thrown by < %s > with args %s with message %s ]",
                            joinPoint.getSignature().getName(),
                            Arrays.toString(joinPoint.getArgs()),
                            throwable.getMessage()
                    )
            );
        }
    }

    @AfterReturning(value = "@annotation(insightLogging)", returning = "returnValue", argNames = "joinPoint, insightLogging, returnValue")
    public void afterReturning(JoinPoint joinPoint, Loggable loggable, Object returnValue) {

        messageService.message(
                loggable.value(),
                joinPoint.getTarget().getClass(),
                String.format(
                        "[ leaving < %s > returning %s ]",
                        joinPoint.getSignature().getName(),
                        returnValue != null && returnValue.getClass().isArray()
                                ? Arrays.toString((Object[]) returnValue)
                                : returnValue
                )
        );
    }
}
