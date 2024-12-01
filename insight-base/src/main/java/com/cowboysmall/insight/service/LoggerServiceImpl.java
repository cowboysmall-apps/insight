package com.cowboysmall.insight.service;

import com.cowboysmall.insight.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.cowboysmall.insight.util.StringUtils.truncate;

/**
 * jerry
 */

@Component
public class LoggerServiceImpl implements LoggerService {

    private Map<Class<?>, Logger> loggers = new HashMap<>();


    @Value("${insight.logging.truncateMessage:false}")
    private boolean truncateMessage;

    @Value("${insight.logging.truncateMessageLength:250}")
    private int truncateMessageLength;


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
    public void log(Level level, Class<?> clazz, String message) {

        try {

            Logger logger = getLogger(clazz);

            logger.getClass()
                    .getMethod(level.name().toLowerCase(), String.class)
                    .invoke(
                            logger,
                            truncateMessage
                                    ? truncate(message, truncateMessageLength)
                                    : message
                    );

        } catch (Exception e) {

            throw new LoggerServiceException(e);
        }
    }

    @Override
    public void log(Level level, Class<?> clazz, String message, Throwable throwable) {

        try {

            Logger logger = getLogger(clazz);

            logger.getClass()
                    .getMethod(level.name().toLowerCase(), String.class, Throwable.class)
                    .invoke(
                            logger,
                            truncateMessage
                                    ? truncate(message, truncateMessageLength)
                                    : message,
                            throwable
                    );


        } catch (Exception e) {

            throw new LoggerServiceException(e);
        }
    }
}
