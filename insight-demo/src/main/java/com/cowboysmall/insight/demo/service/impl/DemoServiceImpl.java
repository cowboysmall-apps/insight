package com.cowboysmall.insight.demo.service.impl;

import com.cowboysmall.insight.LogLevel;
import com.cowboysmall.insight.Loggable;
import com.cowboysmall.insight.Profilable;
import com.cowboysmall.insight.demo.service.DemoService;
import com.cowboysmall.insight.demo.service.DemoServiceException;
import com.cowboysmall.insight.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * jerry
 */

@Component
public class DemoServiceImpl implements DemoService {

    @Autowired
    private LoggerService loggerService;

    @Override
    @Loggable(LogLevel.INFO)
    public String logging(String value1, Long value2) {

        try {

            long sleepDuration = (long) (Math.random() * 1000);
            loggerService.log(LogLevel.DEBUG, DemoServiceImpl.class, String.format("[ logging: sleeping for %d seconds ]", sleepDuration));
            Thread.sleep(sleepDuration);
            loggerService.log(LogLevel.DEBUG, DemoServiceImpl.class, String.format("[ logging: waking after %d seconds ]", sleepDuration));
            return "Test Logging...";

        } catch (Exception e) {

            throw new DemoServiceException(e);
        }
    }

    @Override
    @Profilable(LogLevel.INFO)
    public String profiling(String value1, Long value2) {

        try {

            long sleepDuration = (long) (Math.random() * 1000);
            loggerService.log(LogLevel.DEBUG, DemoServiceImpl.class, String.format("[ profiling: sleeping for %d seconds ]", sleepDuration));
            Thread.sleep(sleepDuration);
            loggerService.log(LogLevel.DEBUG, DemoServiceImpl.class, String.format("[ profiling: waking after %d seconds ]", sleepDuration));
            return "Test Profiling...";

        } catch (Exception e) {

            throw new DemoServiceException(e);
        }
    }

    @Override
    @Profilable(LogLevel.INFO)
    public void scheduled(String value1, Long value2) {

        try {

            long sleepDuration = (long) (Math.random() * 1000);
            loggerService.log(LogLevel.DEBUG, DemoServiceImpl.class, String.format("[ scheduled: sleeping for %d seconds ]", sleepDuration));
            Thread.sleep(sleepDuration);
            loggerService.log(LogLevel.DEBUG, DemoServiceImpl.class, String.format("[ scheduled: waking after %d seconds ]", sleepDuration));

        } catch (Exception e) {

            throw new DemoServiceException(e);
        }
    }
}
