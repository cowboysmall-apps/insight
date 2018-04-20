package com.cowboysmall.insight.demo.service.impl;

import com.cowboysmall.insight.Level;
import com.cowboysmall.insight.Profilable;
import com.cowboysmall.insight.Traceable;
import com.cowboysmall.insight.demo.service.DemoService;
import com.cowboysmall.insight.demo.service.DemoServiceException;
import com.cowboysmall.insight.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.lang.Math.random;
import static java.lang.String.format;
import static java.lang.Thread.sleep;

/**
 * jerry
 */

@Component
public class DemoServiceImpl implements DemoService {

    @Autowired
    private LoggerService loggerService;

    @Override
    @Traceable(Level.INFO)
    public String tracing(String value1, Long value2) {

        try {

            long sleepDuration = (long) (random() * 1000);

            loggerService.log(
                    Level.DEBUG,
                    DemoServiceImpl.class,
                    format("[ logging from tracing: sleeping for %d milliseconds ]", sleepDuration),
                    null
            );

            sleep(sleepDuration);

            loggerService.log(
                    Level.DEBUG,
                    DemoServiceImpl.class,
                    format("[ logging from tracing: waking after %d milliseconds ]", sleepDuration),
                    null
            );

            return "Test Tracing...";

        } catch (Exception e) {

            throw new DemoServiceException(e);
        }
    }

    @Override
    @Profilable(Level.INFO)
    public String profiling(String value1, Long value2) {

        try {

            long sleepDuration = (long) (random() * 1000);

            loggerService.log(
                    Level.DEBUG,
                    DemoServiceImpl.class,
                    format("[ logging from profiling: sleeping for %d milliseconds ]", sleepDuration),
                    null
            );

            sleep(sleepDuration);

            loggerService.log(
                    Level.DEBUG,
                    DemoServiceImpl.class,
                    format("[ logging from profiling: waking after %d milliseconds ]", sleepDuration),
                    null
            );

            return "Test Profiling...";

        } catch (Exception e) {

            throw new DemoServiceException(e);
        }
    }

    @Override
    @Profilable(Level.INFO)
    public void scheduled(String value1, Long value2) {

        try {

            long sleepDuration = (long) (random() * 1000);

            loggerService.log(
                    Level.DEBUG,
                    DemoServiceImpl.class,
                    format("[ logging from scheduled: sleeping for %d milliseconds ]", sleepDuration),
                    null
            );

            sleep(sleepDuration);

            loggerService.log(
                    Level.DEBUG,
                    DemoServiceImpl.class,
                    format("[ logging from scheduled: waking after %d milliseconds ]", sleepDuration),
                    null
            );

        } catch (Exception e) {

            throw new DemoServiceException(e);
        }
    }
}
