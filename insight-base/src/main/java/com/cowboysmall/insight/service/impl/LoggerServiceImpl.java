package com.cowboysmall.insight.service.impl;

import com.cowboysmall.insight.LogLevel;
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
    public void log(LogLevel level, Class<?> clazz, String message) {

        try {

            switch (level) {

                case TRACE:
                    getLogger(clazz).trace(message);
                    break;

                case DEBUG:
                    getLogger(clazz).debug(message);
                    break;

                case ERROR:
                    getLogger(clazz).error(message);
                    break;

                case WARN:
                    getLogger(clazz).warn(message);
                    break;

                default:
                    getLogger(clazz).info(message);
            }

        } catch (Exception e) {

            throw new LoggerServiceException(e);
        }
    }

    @Override
    public void log(LogLevel level, Class<?> clazz, String message, Throwable throwable) {

        try {

            switch (level) {

                case TRACE:
                    getLogger(clazz).trace(message, throwable);
                    break;

                case DEBUG:
                    getLogger(clazz).debug(message, throwable);
                    break;

                case ERROR:
                    getLogger(clazz).error(message, throwable);
                    break;

                case WARN:
                    getLogger(clazz).warn(message, throwable);
                    break;

                default:
                    getLogger(clazz).info(message, throwable);
            }

        } catch (Exception e) {

            throw new LoggerServiceException(e);
        }
    }
}
