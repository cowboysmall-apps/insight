package com.cowboysmall.insight.service;

import com.cowboysmall.insight.service.impl.LoggerServiceImpl;
import org.junit.Test;
import org.slf4j.Logger;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * jerry
 * 9/25/15
 */
public class LoggerServiceTest {

    @Test
    public void testLoggerService() {

        Map<Class<?>, Logger> loggers = new HashMap<>();
        LoggerServiceImpl loggerService = new LoggerServiceImpl();

        ReflectionTestUtils.setField(loggerService, "loggers", loggers);

        loggerService.getLogger(LoggerServiceImpl.class);
        assertEquals(1, loggers.size());

        loggerService.getLogger(LoggerServiceImpl.class);
        assertEquals(1, loggers.size());
    }
}
