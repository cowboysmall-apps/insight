package com.cowboysmall.insight.util;

import static java.lang.String.format;

/**
 * jerry
 * 19/04/18
 */
public class StringUtils {

    public static String truncate(String string, int length) {

        return truncate(string, length, true);
    }

    public static String truncate(String string, int length, boolean elipsis) {

        if (string == null)
            throw new IllegalArgumentException("string was null");

        if (length < 0)
            throw new IllegalArgumentException("length was less than 0");

        if (string.length() < length)
            return string;

        return elipsis && length > 3
                ? format("%s...", string.substring(0, length - 3))
                : string.substring(0, length);
    }
}
