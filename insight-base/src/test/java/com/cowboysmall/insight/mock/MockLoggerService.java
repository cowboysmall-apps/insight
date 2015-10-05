package com.cowboysmall.insight.mock;

import com.cowboysmall.insight.service.LoggerService;
import org.slf4j.Logger;

/**
 * jerry
 */

public class MockLoggerService implements LoggerService {

    public boolean raiseException = false;

    public MockLogger logger = new MockLogger();

    @Override
    public Logger getLogger(Class<?> clazz) {

        if (raiseException)
            throw new RuntimeException("Exception Raised");

        return logger;
    }
}
