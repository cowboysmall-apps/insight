package com.cowboysmall.insight.sample.service;

import com.cowboysmall.insight.Loggable;
import com.cowboysmall.insight.LogLevel;
import com.cowboysmall.insight.Profilable;
import org.springframework.stereotype.Component;

/**
 * jerry
 */

@Component
public class SampleServiceImpl implements SampleService {

    @Override
    @Loggable(LogLevel.INFO)
    public String logging() {

        try {

            Thread.sleep((long) (Math.random() * 1000));
            return "Test Logging...";

        } catch (Exception e) {

            throw new SampleServiceException(e);
        }
    }

    @Override
    @Profilable(LogLevel.INFO)
    public String profiling() {

        try {

            Thread.sleep((long) (Math.random() * 1000));
            return "Test Profiling...";

        } catch (Exception e) {

            throw new SampleServiceException(e);
        }
    }

    @Override
    @Profilable(LogLevel.INFO)
    public void scheduled() {

        try {

            Thread.sleep((long) (Math.random() * 1000));

        } catch (Exception e) {

            throw new SampleServiceException(e);
        }
    }
}