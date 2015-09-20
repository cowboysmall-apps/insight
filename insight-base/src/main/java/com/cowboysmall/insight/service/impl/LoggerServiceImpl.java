package com.cowboysmall.insight.service.impl;

import com.cowboysmall.insight.service.LoggerService;
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

        if (!loggers.containsKey(clazz))
            loggers.put(clazz, LoggerFactory.getLogger(clazz));

        return loggers.get(clazz);
    }
}
