package com.cowboysmall.insight.service;

import com.cowboysmall.insight.LogLevel;
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

        loggerService.getLogger(LoggerServiceImpl.class);
        assertEquals(1, loggers.size());
    }

    @Test(expected = LoggerServiceException.class)
    public void testLoggerService_GetLogger_ExceptionRaised() {

        Map<Class<?>, Logger> loggers = new HashMap<Class<?>, Logger>(){

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
    public void testLoggerService_Error() {

        MockLogger logger = new MockLogger();

        Map<Class<?>, Logger> loggers = new HashMap<>();
        loggers.put(LoggerServiceImpl.class, logger);

        LoggerServiceImpl loggerService = new LoggerServiceImpl();
        ReflectionTestUtils.setField(loggerService, "loggers", loggers);

        loggerService.log(LogLevel.ERROR, LoggerServiceImpl.class, "Testes!");

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

        loggerService.log(LogLevel.ERROR, LoggerServiceImpl.class, "Testes!", new Exception("Testes!"));

        assertTrue(logger.errorCalled);
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

        loggerService.log(LogLevel.DEBUG, LoggerServiceImpl.class, "Testes!");

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

        loggerService.log(LogLevel.DEBUG, LoggerServiceImpl.class, "Testes!", new Exception("Testes!"));

        assertTrue(logger.debugCalled);
        assertEquals("Testes!", logger.message);
        assertEquals("Testes!", logger.throwable.getMessage());
    }




    @Test
    public void testLoggerService_Trace() {

        MockLogger logger = new MockLogger();

        Map<Class<?>, Logger> loggers = new HashMap<>();
        loggers.put(LoggerServiceImpl.class, logger);

        LoggerServiceImpl loggerService = new LoggerServiceImpl();
        ReflectionTestUtils.setField(loggerService, "loggers", loggers);

        loggerService.log(LogLevel.TRACE, LoggerServiceImpl.class, "Testes!");

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

        loggerService.log(LogLevel.TRACE, LoggerServiceImpl.class, "Testes!", new Exception("Testes!"));

        assertTrue(logger.traceCalled);
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

        loggerService.log(LogLevel.WARN, LoggerServiceImpl.class, "Testes!");

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

        loggerService.log(LogLevel.WARN, LoggerServiceImpl.class, "Testes!", new Exception("Testes!"));

        assertTrue(logger.warnCalled);
        assertEquals("Testes!", logger.message);
        assertEquals("Testes!", logger.throwable.getMessage());
    }






    @Test
    public void testLoggerService_Default() {

        MockLogger logger = new MockLogger();

        Map<Class<?>, Logger> loggers = new HashMap<>();
        loggers.put(LoggerServiceImpl.class, logger);

        LoggerServiceImpl loggerService = new LoggerServiceImpl();
        ReflectionTestUtils.setField(loggerService, "loggers", loggers);

        loggerService.log(LogLevel.INFO, LoggerServiceImpl.class, "Testes!");

        assertTrue(logger.infoCalled);
        assertEquals("Testes!", logger.message);
    }

    @Test
    public void testLoggerService_Default_Exception() {

        MockLogger logger = new MockLogger();

        Map<Class<?>, Logger> loggers = new HashMap<>();
        loggers.put(LoggerServiceImpl.class, logger);

        LoggerServiceImpl loggerService = new LoggerServiceImpl();
        ReflectionTestUtils.setField(loggerService, "loggers", loggers);

        loggerService.log(LogLevel.INFO, LoggerServiceImpl.class, "Testes!", new Exception("Testes!"));

        assertTrue(logger.infoCalled);
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

        loggerService.log(LogLevel.INFO, LoggerServiceImpl.class, "Testes!");
    }

    @Test(expected = LoggerServiceException.class)
    public void testLoggerService_ExceptionRaised_Exception() {

        MockLogger logger = new MockLogger();
        logger.raiseException = true;

        Map<Class<?>, Logger> loggers = new HashMap<>();
        loggers.put(LoggerServiceImpl.class, logger);

        LoggerServiceImpl loggerService = new LoggerServiceImpl();
        ReflectionTestUtils.setField(loggerService, "loggers", loggers);

        loggerService.log(LogLevel.INFO, LoggerServiceImpl.class, "Testes!", new Exception("Testes!"));
    }
}
