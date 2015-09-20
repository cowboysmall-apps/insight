package com.cowboysmall.insight.service;

import com.cowboysmall.insight.LogLevel;

import java.util.ArrayList;
import java.util.List;

/**
 * jerry
 */

public class MockMessageService implements MessageService {

    private List<String> messageList = new ArrayList<>();
    private List<Throwable> exceptionList = new ArrayList<>();


    //_________________________________________________________________________

    public MockMessageService() {
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
    public void message(LogLevel level, Class<?> clazz, String message) {

        messageList.add(message);
    }

    @Override
    public void message(LogLevel level, Class<?> clazz, String message, Throwable throwable) {

        messageList.add(message);
        exceptionList.add(throwable);
    }
}
