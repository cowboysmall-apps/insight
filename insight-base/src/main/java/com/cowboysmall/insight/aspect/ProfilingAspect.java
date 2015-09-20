package com.cowboysmall.insight.aspect;

import com.cowboysmall.insight.Profilable;
import com.cowboysmall.insight.service.MessageService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * jerry
 */

@Aspect
@Component
public class ProfilingAspect {

    @Autowired
    private MessageService messageService;


    //_________________________________________________________________________

    @Around(value = "@annotation(insightProfiling)", argNames = "proceedingJoinPoint, insightProfiling")
    public Object around(ProceedingJoinPoint proceedingJoinPoint, Profilable profilable) throws Throwable {

        long start = System.currentTimeMillis();
        try {

            return proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());

        } finally {

            long end = System.currentTimeMillis();

            messageService.message(
                    profilable.value(),
                    proceedingJoinPoint.getTarget().getClass(),
                    String.format(
                            "[ time taken to execute < %s > = %s ]",
                            proceedingJoinPoint.getSignature().getName(),
                            (end - start)
                    )
            );
        }
    }
}
