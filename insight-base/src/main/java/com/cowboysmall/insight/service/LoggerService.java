package com.cowboysmall.insight.service;

import com.cowboysmall.insight.LogLevel;
import org.slf4j.Logger;

/**
 * jerry
 */

public interface LoggerService {

    Logger getLogger(Class<?> clazz);

    void log(LogLevel level, Class<?> clazz, String message);

    void log(LogLevel level, Class<?> clazz, String message, Throwable throwable);
}
