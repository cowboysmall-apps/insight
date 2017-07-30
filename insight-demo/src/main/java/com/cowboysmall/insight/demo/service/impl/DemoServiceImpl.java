package com.cowboysmall.insight.demo.service.impl;

import com.cowboysmall.insight.Level;
import com.cowboysmall.insight.Profilable;
import com.cowboysmall.insight.Traceable;
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
    @Traceable(Level.INFO)
    public String tracing(String value1, Long value2) {

        try {

            long sleepDuration = (long) (Math.random() * 1000);
            loggerService.log(Level.DEBUG, DemoServiceImpl.class, String.format("[ logging from tracing: sleeping for %d seconds ]", sleepDuration), null);
            Thread.sleep(sleepDuration);
            loggerService.log(Level.DEBUG, DemoServiceImpl.class, String.format("[ logging from tracing: waking after %d seconds ]", sleepDuration), null);
            return "Test Tracing...";

        } catch (Exception e) {

            throw new DemoServiceException(e);
        }
    }

    @Override
    @Profilable(Level.INFO)
    public String profiling(String value1, Long value2) {

        try {

            long sleepDuration = (long) (Math.random() * 1000);
            loggerService.log(Level.DEBUG, DemoServiceImpl.class, String.format("[ logging from profiling: sleeping for %d seconds ]", sleepDuration), null);
            Thread.sleep(sleepDuration);
            loggerService.log(Level.DEBUG, DemoServiceImpl.class, String.format("[ logging from profiling: waking after %d seconds ]", sleepDuration), null);
            return "Test Profiling...";

        } catch (Exception e) {

            throw new DemoServiceException(e);
        }
    }

    @Override
    @Profilable(Level.INFO)
    public void scheduled(String value1, Long value2) {

        try {

            long sleepDuration = (long) (Math.random() * 1000);
            loggerService.log(Level.DEBUG, DemoServiceImpl.class, String.format("[ logging from scheduled: sleeping for %d seconds ]", sleepDuration), null);
            Thread.sleep(sleepDuration);
            loggerService.log(Level.DEBUG, DemoServiceImpl.class, String.format("[ logging from scheduled: waking after %d seconds ]", sleepDuration), null);

        } catch (Exception e) {

            throw new DemoServiceException(e);
        }
    }
}
