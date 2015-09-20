package com.cowboysmall.insight.service;

import com.cowboysmall.insight.LogLevel;

/**
 * jerry
 */

public interface MessageService {

    void message(LogLevel level, Class<?> clazz, String message);

    void message(LogLevel level, Class<?> clazz, String message, Throwable throwable);
}
