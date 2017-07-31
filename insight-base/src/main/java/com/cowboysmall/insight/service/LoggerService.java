package com.cowboysmall.insight.service;

import com.cowboysmall.insight.Level;
import org.slf4j.Logger;

/**
 * jerry
 */

public interface LoggerService {

    Logger getLogger(Class<?> clazz);

    void log(Level level, Class<?> clazz, String message, Throwable throwable);
}
