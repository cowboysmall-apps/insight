package com.cowboysmall.insight.aspect;

import com.cowboysmall.insight.Profilable;
import com.cowboysmall.insight.service.LoggerService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.cowboysmall.insight.util.StringUtils.truncate;
import static java.lang.String.format;
import static java.lang.System.currentTimeMillis;

/**
 * jerry
 */

@Aspect
@Component
public class ProfilingAspect {

    @Autowired
    private LoggerService loggerService;

    @Value("${insight.profiling.around:time taken to execute < %s > = %sms}")
    private String aroundString;


    //_________________________________________________________________________

    @Around(value = "@annotation(profilable)", argNames = "proceedingJoinPoint, profilable")
    public Object around(ProceedingJoinPoint proceedingJoinPoint, Profilable profilable) throws Throwable {

        long start = currentTimeMillis();

        try {

            return proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());

        } finally {

            long end = currentTimeMillis();

            String message = format(aroundString, proceedingJoinPoint.getSignature().getName(), end - start);

            loggerService.log(
                    profilable.value(),
                    proceedingJoinPoint.getTarget().getClass(),
                    message,
                    null
            );
        }
    }
}
