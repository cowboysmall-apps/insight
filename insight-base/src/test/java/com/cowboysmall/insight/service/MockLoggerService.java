package com.cowboysmall.insight.service;

import org.slf4j.Logger;

/**
 * jerry
 */

public class MockLoggerService implements LoggerService {

    public MockLogger logger = new MockLogger();

    @Override
    public Logger getLogger(Class<?> clazz) {

        return logger;
    }
}
