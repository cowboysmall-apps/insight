package com.cowboysmall.insight.service;

import com.cowboysmall.insight.Level;
import com.cowboysmall.insight.mock.MockLogger;
import com.cowboysmall.insight.service.impl.LoggerServiceImpl;
import org.junit.Test;
import org.slf4j.Logger;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * jerry
 * 9/19/15
 */

public class LoggerServiceTest {

    @Test
    public void testLoggerService_GetLogger() {

        Map<Class<?>, Logger> loggers = new HashMap<>();

        LoggerServiceImpl loggerService = new LoggerServiceImpl();
        ReflectionTestUtils.setField(loggerService, "loggers", loggers);

        loggerService.getLogger(LoggerServiceImpl.class);
        assertEquals(1, loggers.size());
    }

    @Test
    public void testLoggerService_GetLogger_Truncated() {

        MockLogger logger = new MockLogger();

        Map<Class<?>, Logger> loggers = new HashMap<>();
        loggers.put(LoggerServiceImpl.class, logger);

        LoggerServiceImpl loggerService = new LoggerServiceImpl();
        ReflectionTestUtils.setField(loggerService, "loggers", loggers);
        ReflectionTestUtils.setField(loggerService, "truncateMessage", true);
        ReflectionTestUtils.setField(loggerService, "truncateMessageLength", 5);

        loggerService.getLogger(LoggerServiceImpl.class);
        assertEquals(1, loggers.size());

        loggerService.log(Level.TRACE, LoggerServiceImpl.class, "123456", null);

        assertEquals("12...", logger.message);
    }

    @Test(expected = LoggerServiceException.class)
    public void testLoggerService_GetLogger_ExceptionRaised() {

        Map<Class<?>, Logger> loggers = new HashMap<Class<?>, Logger>() {

            @Override
            public Logger put(Class<?> key, Logger value) {

                throw new RuntimeException("Exception Raised");
            }
        };

        LoggerServiceImpl loggerService = new LoggerServiceImpl();
        ReflectionTestUtils.setField(loggerService, "loggers", loggers);

        loggerService.getLogger(LoggerServiceImpl.class);
    }


    @Test
    public void testLoggerService_Trace() {

        MockLogger logger = new MockLogger();

        Map<Class<?>, Logger> loggers = new HashMap<>();
        loggers.put(LoggerServiceImpl.class, logger);

        LoggerServiceImpl loggerService = new LoggerServiceImpl();
        ReflectionTestUtils.setField(loggerService, "loggers", loggers);

        loggerService.log(Level.TRACE, LoggerServiceImpl.class, "Testes!", null);

        assertTrue(logger.traceCalled);
        assertEquals("Testes!", logger.message);
    }

    @Test
    public void testLoggerService_Trace_Exception() {

        MockLogger logger = new MockLogger();

        Map<Class<?>, Logger> loggers = new HashMap<>();
        loggers.put(LoggerServiceImpl.class, logger);

        LoggerServiceImpl loggerService = new LoggerServiceImpl();
        ReflectionTestUtils.setField(loggerService, "loggers", loggers);

        loggerService.log(Level.TRACE, LoggerServiceImpl.class, "Testes!", new Exception("Testes!"));

        assertTrue(logger.traceCalled);
        assertEquals("Testes!", logger.message);
        assertEquals("Testes!", logger.throwable.getMessage());
    }


    @Test
    public void testLoggerService_Debug() {

        MockLogger logger = new MockLogger();

        Map<Class<?>, Logger> loggers = new HashMap<>();
        loggers.put(LoggerServiceImpl.class, logger);

        LoggerServiceImpl loggerService = new LoggerServiceImpl();
        ReflectionTestUtils.setField(loggerService, "loggers", loggers);

        loggerService.log(Level.DEBUG, LoggerServiceImpl.class, "Testes!", null);

        assertTrue(logger.debugCalled);
        assertEquals("Testes!", logger.message);
    }

    @Test
    public void testLoggerService_Debug_Exception() {

        MockLogger logger = new MockLogger();

        Map<Class<?>, Logger> loggers = new HashMap<>();
        loggers.put(LoggerServiceImpl.class, logger);

        LoggerServiceImpl loggerService = new LoggerServiceImpl();
        ReflectionTestUtils.setField(loggerService, "loggers", loggers);

        loggerService.log(Level.DEBUG, LoggerServiceImpl.class, "Testes!", new Exception("Testes!"));

        assertTrue(logger.debugCalled);
        assertEquals("Testes!", logger.message);
        assertEquals("Testes!", logger.throwable.getMessage());
    }


    @Test
    public void testLoggerService_Info() {

        MockLogger logger = new MockLogger();

        Map<Class<?>, Logger> loggers = new HashMap<>();
        loggers.put(LoggerServiceImpl.class, logger);

        LoggerServiceImpl loggerService = new LoggerServiceImpl();
        ReflectionTestUtils.setField(loggerService, "loggers", loggers);

        loggerService.log(Level.INFO, LoggerServiceImpl.class, "Testes!", null);

        assertTrue(logger.infoCalled);
        assertEquals("Testes!", logger.message);
    }

    @Test
    public void testLoggerService_Info_Exception() {

        MockLogger logger = new MockLogger();

        Map<Class<?>, Logger> loggers = new HashMap<>();
        loggers.put(LoggerServiceImpl.class, logger);

        LoggerServiceImpl loggerService = new LoggerServiceImpl();
        ReflectionTestUtils.setField(loggerService, "loggers", loggers);

        loggerService.log(Level.INFO, LoggerServiceImpl.class, "Testes!", new Exception("Testes!"));

        assertTrue(logger.infoCalled);
        assertEquals("Testes!", logger.message);
        assertEquals("Testes!", logger.throwable.getMessage());
    }


    @Test
    public void testLoggerService_Warn() {

        MockLogger logger = new MockLogger();

        Map<Class<?>, Logger> loggers = new HashMap<>();
        loggers.put(LoggerServiceImpl.class, logger);

        LoggerServiceImpl loggerService = new LoggerServiceImpl();
        ReflectionTestUtils.setField(loggerService, "loggers", loggers);

        loggerService.log(Level.WARN, LoggerServiceImpl.class, "Testes!", null);

        assertTrue(logger.warnCalled);
        assertEquals("Testes!", logger.message);
    }

    @Test
    public void testLoggerService_Warn_Exception() {

        MockLogger logger = new MockLogger();

        Map<Class<?>, Logger> loggers = new HashMap<>();
        loggers.put(LoggerServiceImpl.class, logger);

        LoggerServiceImpl loggerService = new LoggerServiceImpl();
        ReflectionTestUtils.setField(loggerService, "loggers", loggers);

        loggerService.log(Level.WARN, LoggerServiceImpl.class, "Testes!", new Exception("Testes!"));

        assertTrue(logger.warnCalled);
        assertEquals("Testes!", logger.message);
        assertEquals("Testes!", logger.throwable.getMessage());
    }


    @Test
    public void testLoggerService_Error() {

        MockLogger logger = new MockLogger();

        Map<Class<?>, Logger> loggers = new HashMap<>();
        loggers.put(LoggerServiceImpl.class, logger);

        LoggerServiceImpl loggerService = new LoggerServiceImpl();
        ReflectionTestUtils.setField(loggerService, "loggers", loggers);

        loggerService.log(Level.ERROR, LoggerServiceImpl.class, "Testes!", null);

        assertTrue(logger.errorCalled);
        assertEquals("Testes!", logger.message);
    }

    @Test
    public void testLoggerService_Error_Exception() {

        MockLogger logger = new MockLogger();

        Map<Class<?>, Logger> loggers = new HashMap<>();
        loggers.put(LoggerServiceImpl.class, logger);

        LoggerServiceImpl loggerService = new LoggerServiceImpl();
        ReflectionTestUtils.setField(loggerService, "loggers", loggers);

        loggerService.log(Level.ERROR, LoggerServiceImpl.class, "Testes!", new Exception("Testes!"));

        assertTrue(logger.errorCalled);
        assertEquals("Testes!", logger.message);
        assertEquals("Testes!", logger.throwable.getMessage());
    }


    @Test(expected = LoggerServiceException.class)
    public void testLoggerService_ExceptionRaised() {

        MockLogger logger = new MockLogger();
        logger.raiseException = true;

        Map<Class<?>, Logger> loggers = new HashMap<>();
        loggers.put(LoggerServiceImpl.class, logger);

        LoggerServiceImpl loggerService = new LoggerServiceImpl();
        ReflectionTestUtils.setField(loggerService, "loggers", loggers);

        loggerService.log(Level.INFO, LoggerServiceImpl.class, "Testes!", null);
    }

    @Test(expected = LoggerServiceException.class)
    public void testLoggerService_ExceptionRaised_Exception() {

        MockLogger logger = new MockLogger();
        logger.raiseException = true;

        Map<Class<?>, Logger> loggers = new HashMap<>();
        loggers.put(LoggerServiceImpl.class, logger);

        LoggerServiceImpl loggerService = new LoggerServiceImpl();
        ReflectionTestUtils.setField(loggerService, "loggers", loggers);

        loggerService.log(Level.INFO, LoggerServiceImpl.class, "Testes!", new Exception("Testes!"));
    }
}
