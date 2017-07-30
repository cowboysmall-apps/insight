package com.cowboysmall.insight.service.impl;

import com.cowboysmall.insight.Level;
import com.cowboysmall.insight.service.LoggerService;
import com.cowboysmall.insight.service.LoggerServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * jerry
 */

@Component
public class LoggerServiceImpl implements LoggerService {

    private Map<Class<?>, Logger> loggers = new HashMap<>();


    //_________________________________________________________________________

    @Override
    public Logger getLogger(Class<?> clazz) {

        try {

            if (!loggers.containsKey(clazz))
                loggers.put(clazz, LoggerFactory.getLogger(clazz));

            return loggers.get(clazz);

        } catch (Exception e) {

            throw new LoggerServiceException(e);
        }
    }


    //_________________________________________________________________________

    @Override
    public void log(Level level, Class<?> clazz, String message, Throwable throwable) {

        try {

            Logger logger = getLogger(clazz);

            if (throwable == null)
                logger.getClass()
                        .getMethod(level.name().toLowerCase(), String.class)
                        .invoke(logger, message);
            else
                logger.getClass()
                        .getMethod(level.name().toLowerCase(), String.class, Throwable.class)
                        .invoke(logger, message, throwable);

        } catch (Exception e) {

            throw new LoggerServiceException(e);
        }
    }
}
