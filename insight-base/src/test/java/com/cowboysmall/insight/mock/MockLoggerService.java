package com.cowboysmall.insight.mock;

import com.cowboysmall.insight.LogLevel;
import com.cowboysmall.insight.service.LoggerService;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * jerry
 */

public class MockLoggerService implements LoggerService {

    private List<String> messageList = new ArrayList<>();
    private List<Throwable> exceptionList = new ArrayList<>();

    public MockLogger logger = new MockLogger();

    //_________________________________________________________________________

    public MockLoggerService() {
    }


    //_________________________________________________________________________

    public List<String> getMessageList() {

        return messageList;
    }

    public List<Throwable> getExceptionList() {

        return exceptionList;
    }

    public void clear() {

        messageList.clear();
        exceptionList.clear();
    }


    //_________________________________________________________________________

    @Override
    public Logger getLogger(Class<?> clazz) {

        return logger;
    }

    @Override
    public void log(LogLevel level, Class<?> clazz, String message) {

        messageList.add(message);
    }

    @Override
    public void log(LogLevel level, Class<?> clazz, String message, Throwable throwable) {

        messageList.add(message);
        exceptionList.add(throwable);
    }
}
