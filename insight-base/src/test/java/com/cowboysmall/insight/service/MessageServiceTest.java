package com.cowboysmall.insight.service;

import com.cowboysmall.insight.LogLevel;
import com.cowboysmall.insight.service.impl.MessageServiceImpl;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * jerry
 * 9/19/15
 */

public class MessageServiceTest {

    @Test
    public void testInsightMessageService_Info() {

        MockLoggerService loggerService = new MockLoggerService();

        MessageServiceImpl insightMessageService = new MessageServiceImpl();
        ReflectionTestUtils.setField(insightMessageService, "loggerService", loggerService);

        insightMessageService.message(LogLevel.INFO, MessageServiceImpl.class, "Testes!");

        assertTrue(loggerService.logger.infoCalled);
        assertEquals("Testes!", loggerService.logger.message);
    }

    @Test
    public void testInsightMessageService_Info_Exception() {

        MockLoggerService loggerService = new MockLoggerService();

        MessageServiceImpl insightMessageService = new MessageServiceImpl();
        ReflectionTestUtils.setField(insightMessageService, "loggerService", loggerService);

        insightMessageService.message(LogLevel.INFO, MessageServiceImpl.class, "Testes!", new Exception("Testes!"));

        assertTrue(loggerService.logger.infoCalled);
        assertEquals("Testes!", loggerService.logger.message);
        assertEquals("Testes!", loggerService.logger.throwable.getMessage());
    }


    @Test
    public void testInsightMessageService_Debug() {

        MockLoggerService loggerService = new MockLoggerService();

        MessageServiceImpl insightMessageService = new MessageServiceImpl();
        ReflectionTestUtils.setField(insightMessageService, "loggerService", loggerService);

        insightMessageService.message(LogLevel.DEBUG, MessageServiceImpl.class, "Testes!");

        assertTrue(loggerService.logger.debugCalled);
        assertEquals("Testes!", loggerService.logger.message);
    }

    @Test
    public void testInsightMessageService_Debug_Exception() {

        MockLoggerService loggerService = new MockLoggerService();

        MessageServiceImpl insightMessageService = new MessageServiceImpl();
        ReflectionTestUtils.setField(insightMessageService, "loggerService", loggerService);

        insightMessageService.message(LogLevel.DEBUG, MessageServiceImpl.class, "Testes!", new Exception("Testes!"));

        assertTrue(loggerService.logger.debugCalled);
        assertEquals("Testes!", loggerService.logger.message);
        assertEquals("Testes!", loggerService.logger.throwable.getMessage());
    }


    @Test
    public void testInsightMessageService_Error() {

        MockLoggerService loggerService = new MockLoggerService();

        MessageServiceImpl insightMessageService = new MessageServiceImpl();
        ReflectionTestUtils.setField(insightMessageService, "loggerService", loggerService);

        insightMessageService.message(LogLevel.ERROR, MessageServiceImpl.class, "Testes!");

        assertTrue(loggerService.logger.errorCalled);
        assertEquals("Testes!", loggerService.logger.message);
    }

    @Test
    public void testInsightMessageService_Error_Exception() {

        MockLoggerService loggerService = new MockLoggerService();

        MessageServiceImpl insightMessageService = new MessageServiceImpl();
        ReflectionTestUtils.setField(insightMessageService, "loggerService", loggerService);

        insightMessageService.message(LogLevel.ERROR, MessageServiceImpl.class, "Testes!", new Exception("Testes!"));

        assertTrue(loggerService.logger.errorCalled);
        assertEquals("Testes!", loggerService.logger.message);
        assertEquals("Testes!", loggerService.logger.throwable.getMessage());
    }


    @Test
    public void testInsightMessageService_Trace() {

        MockLoggerService loggerService = new MockLoggerService();

        MessageServiceImpl insightMessageService = new MessageServiceImpl();
        ReflectionTestUtils.setField(insightMessageService, "loggerService", loggerService);

        insightMessageService.message(LogLevel.TRACE, MessageServiceImpl.class, "Testes!");

        assertTrue(loggerService.logger.traceCalled);
        assertEquals("Testes!", loggerService.logger.message);
    }

    @Test
    public void testInsightMessageService_Trace_Exception() {

        MockLoggerService loggerService = new MockLoggerService();

        MessageServiceImpl insightMessageService = new MessageServiceImpl();
        ReflectionTestUtils.setField(insightMessageService, "loggerService", loggerService);

        insightMessageService.message(LogLevel.TRACE, MessageServiceImpl.class, "Testes!", new Exception("Testes!"));

        assertTrue(loggerService.logger.traceCalled);
        assertEquals("Testes!", loggerService.logger.message);
        assertEquals("Testes!", loggerService.logger.throwable.getMessage());
    }


    @Test
    public void testInsightMessageService_Warn() {

        MockLoggerService loggerService = new MockLoggerService();

        MessageServiceImpl insightMessageService = new MessageServiceImpl();
        ReflectionTestUtils.setField(insightMessageService, "loggerService", loggerService);

        insightMessageService.message(LogLevel.WARN, MessageServiceImpl.class, "Testes!");

        assertTrue(loggerService.logger.warnCalled);
        assertEquals("Testes!", loggerService.logger.message);
    }

    @Test
    public void testInsightMessageService_Warn_Exception() {

        MockLoggerService loggerService = new MockLoggerService();

        MessageServiceImpl insightMessageService = new MessageServiceImpl();
        ReflectionTestUtils.setField(insightMessageService, "loggerService", loggerService);

        insightMessageService.message(LogLevel.WARN, MessageServiceImpl.class, "Testes!", new Exception("Testes!"));

        assertTrue(loggerService.logger.warnCalled);
        assertEquals("Testes!", loggerService.logger.message);
        assertEquals("Testes!", loggerService.logger.throwable.getMessage());
    }
}
