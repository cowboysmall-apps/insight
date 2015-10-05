package com.cowboysmall.insight.service.impl;

import com.cowboysmall.insight.LogLevel;
import com.cowboysmall.insight.service.MessageService;
import com.cowboysmall.insight.service.MessageServiceException;
import com.cowboysmall.insight.service.LoggerService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * jerry
 */

@Component
public class MessageServiceImpl implements MessageService {

    @Autowired
    private LoggerService loggerService;


    //_________________________________________________________________________

    @Override
    public void message(LogLevel level, Class<?> clazz, String message) {

        try {

            Logger logger = loggerService.getLogger(clazz);

            switch (level) {

                case TRACE:
                    logger.trace(message);
                    break;

                case DEBUG:
                    logger.debug(message);
                    break;

                case ERROR:
                    logger.error(message);
                    break;

                case WARN:
                    logger.warn(message);
                    break;

                default:
                    logger.info(message);
            }

        } catch (Exception e) {

            throw new MessageServiceException(e);
        }
    }

    @Override
    public void message(LogLevel level, Class<?> clazz, String message, Throwable throwable) {

        try {

            Logger logger = loggerService.getLogger(clazz);

            switch (level) {

                case TRACE:
                    logger.trace(message, throwable);
                    break;

                case DEBUG:
                    logger.debug(message, throwable);
                    break;

                case ERROR:
                    logger.error(message, throwable);
                    break;

                case WARN:
                    logger.warn(message, throwable);
                    break;

                default:
                    logger.info(message, throwable);
            }

        } catch (Exception e) {

            throw new MessageServiceException(e);
        }
    }
}
