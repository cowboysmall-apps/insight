package com.cowboysmall.insight.aspect;

import com.cowboysmall.insight.Profilable;
import com.cowboysmall.insight.service.LoggerService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * jerry
 */

@Aspect
@Component
public class ProfilingAspect {

    @Autowired
    private LoggerService loggerService;

    @Value("${profiling.around:time taken to execute < %s > = %sms}")
    private String aroundString;


    //_________________________________________________________________________

    @Around(value = "@annotation(profilable)", argNames = "proceedingJoinPoint, profilable")
    public Object around(ProceedingJoinPoint proceedingJoinPoint, Profilable profilable) throws Throwable {

        long start = System.currentTimeMillis();
        try {

            return proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());

        } finally {

            long end = System.currentTimeMillis();

            loggerService.log(
                    profilable.value(),
                    proceedingJoinPoint.getTarget().getClass(),
                    String.format(
                            aroundString,
                            proceedingJoinPoint.getSignature().getName(),
                            (end - start)
                    ),
                    null
            );
        }
    }
}
