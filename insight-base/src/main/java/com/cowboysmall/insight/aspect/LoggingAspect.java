package com.cowboysmall.insight.aspect;

import com.cowboysmall.insight.Loggable;
import com.cowboysmall.insight.service.MessageService;
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
public class LoggingAspect {

    private Set<Throwable> exceptions = Collections.newSetFromMap(new WeakHashMap<>());


    @Autowired
    private MessageService messageService;

    @Value("${logging.before}")
    private String beforeString;

    @Value("${logging.afterThrowing}")
    private String afterThrowingString;

    @Value("${logging.afterReturning}")
    private String afterReturningString;


    //_________________________________________________________________________

    @Before(value = "@annotation(loggable)", argNames = "joinPoint, loggable")
    public void before(JoinPoint joinPoint, Loggable loggable) {

        messageService.message(
                loggable.value(),
                joinPoint.getTarget().getClass(),
                String.format(
                        beforeString,
                        joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs())
                )
        );
    }

    @AfterThrowing(value = "@annotation(loggable)", throwing = "throwable", argNames = "joinPoint, loggable, throwable")
    public void afterThrowing(JoinPoint joinPoint, Loggable loggable, Throwable throwable) {

        if (!exceptions.contains(throwable) && !exceptions.contains(throwable.getCause())) {

            messageService.message(
                    loggable.value(),
                    joinPoint.getTarget().getClass(),
                    String.format(
                            afterThrowingString,
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
                            afterThrowingString,
                            joinPoint.getSignature().getName(),
                            Arrays.toString(joinPoint.getArgs()),
                            throwable.getMessage()
                    )
            );
        }
    }

    @AfterReturning(value = "@annotation(loggable)", returning = "returnValue", argNames = "joinPoint, loggable, returnValue")
    public void afterReturning(JoinPoint joinPoint, Loggable loggable, Object returnValue) {

        messageService.message(
                loggable.value(),
                joinPoint.getTarget().getClass(),
                String.format(
                        afterReturningString,
                        joinPoint.getSignature().getName(),
                        returnValue != null && returnValue.getClass().isArray()
                                ? Arrays.toString((Object[]) returnValue)
                                : returnValue
                )
        );
    }
}
