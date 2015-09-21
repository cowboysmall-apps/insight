package com.cowboysmall.insight.sample.service.impl;

import com.cowboysmall.insight.Loggable;
import com.cowboysmall.insight.LogLevel;
import com.cowboysmall.insight.Profilable;
import com.cowboysmall.insight.sample.service.SampleService;
import com.cowboysmall.insight.sample.service.SampleServiceException;
import org.springframework.stereotype.Component;

/**
 * jerry
 */

@Component
public class SampleServiceImpl implements SampleService {

    @Override
    @Loggable(LogLevel.INFO)
    public String logging(String value1, Long value2) {

        try {

            Thread.sleep((long) (Math.random() * 1000));
            return "Test Logging...";

        } catch (Exception e) {

            throw new SampleServiceException(e);
        }
    }

    @Override
    @Profilable(LogLevel.INFO)
    public String profiling(String value1, Long value2) {

        try {

            Thread.sleep((long) (Math.random() * 1000));
            return "Test Profiling...";

        } catch (Exception e) {

            throw new SampleServiceException(e);
        }
    }

    @Override
    @Profilable(LogLevel.INFO)
    public void scheduled(String value1, Long value2) {

        try {

            Thread.sleep((long) (Math.random() * 1000));

        } catch (Exception e) {

            throw new SampleServiceException(e);
        }
    }
}
