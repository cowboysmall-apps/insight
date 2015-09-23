package com.cowboysmall.insight.demo.service.impl;

import com.cowboysmall.insight.Loggable;
import com.cowboysmall.insight.LogLevel;
import com.cowboysmall.insight.Profilable;
import com.cowboysmall.insight.demo.service.DemoService;
import com.cowboysmall.insight.demo.service.DemoServiceException;
import org.springframework.stereotype.Component;

/**
 * jerry
 */

@Component
public class DemoServiceImpl implements DemoService {

    @Override
    @Loggable(LogLevel.INFO)
    public String logging(String value1, Long value2) {

        try {

            Thread.sleep((long) (Math.random() * 1000));
            return "Test Logging...";

        } catch (Exception e) {

            throw new DemoServiceException(e);
        }
    }

    @Override
    @Profilable(LogLevel.INFO)
    public String profiling(String value1, Long value2) {

        try {

            Thread.sleep((long) (Math.random() * 1000));
            return "Test Profiling...";

        } catch (Exception e) {

            throw new DemoServiceException(e);
        }
    }

    @Override
    @Profilable(LogLevel.INFO)
    public void scheduled(String value1, Long value2) {

        try {

            Thread.sleep((long) (Math.random() * 1000));

        } catch (Exception e) {

            throw new DemoServiceException(e);
        }
    }
}
