package com.cowboysmall.insight.mock;

import com.cowboysmall.insight.Level;
import com.cowboysmall.insight.service.LoggerService;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * jerry
 */

public class MockLoggerService implements LoggerService {

    private Set<Level> levels = new HashSet<>();
    private Set<Class<?>> classes = new HashSet<>();

    private List<String> messageList = new ArrayList<>();
    private List<Throwable> exceptionList = new ArrayList<>();

    private MockLogger logger = new MockLogger();

    //_________________________________________________________________________

    public MockLoggerService() {
    }


    //_________________________________________________________________________

    public Set<Level> getLevels() {

        return levels;
    }

    public Set<Class<?>> getClasses() {

        return classes;
    }

    public List<String> getMessageList() {

        return messageList;
    }

    public List<Throwable> getExceptionList() {

        return exceptionList;
    }


    //_________________________________________________________________________

    public void clear() {

        levels.clear();
        classes.clear();
        messageList.clear();
        exceptionList.clear();
    }


    //_________________________________________________________________________

    @Override
    public Logger getLogger(Class<?> clazz) {

        return logger;
    }

    @Override
    public void log(Level level, Class<?> clazz, String message, Throwable throwable) {

        levels.add(level);
        classes.add(clazz);
        messageList.add(message);
        if (throwable != null)
            exceptionList.add(throwable);
    }
}
