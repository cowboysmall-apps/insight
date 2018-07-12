package com.cowboysmall.insight.util;

/**
 * jerry
 * 11/07/18
 */
public class ExceptionUtils {

    public static Throwable rootCause(Throwable throwable) {

        while (throwable.getCause() != null)
            throwable = throwable.getCause();

        return throwable;
    }
}
