package com.cowboysmall.insight.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * jerry
 * 19/04/18
 */
public class StringUtilsTest {

    @Test
    public void testStringUtils_BaseCase() {

        assertEquals(
                StringUtils.truncate("abcdefghijklmnop", 12),
                "abcdefghi..."
        );
        assertEquals(
                StringUtils.truncate("abcdefghijklmnop", 12, true),
                "abcdefghi..."
        );
        assertEquals(
                StringUtils.truncate("abcdefghijklmnop", 12, false),
                "abcdefghijkl"
        );
    }

    @Test
    public void testStringUtils_EmptyString() {

        assertEquals(
                StringUtils.truncate("", 25),
                ""
        );
        assertEquals(
                StringUtils.truncate("", 25, true),
                ""
        );
        assertEquals(
                StringUtils.truncate("", 25, false),
                ""
        );
    }

    @Test
    public void testStringUtils_ZeroLength() {

        assertEquals(
                StringUtils.truncate("abcdefghijklmnop", 0),
                ""
        );
        assertEquals(
                StringUtils.truncate("abcdefghijklmnop", 0, true),
                ""
        );
        assertEquals(
                StringUtils.truncate("abcdefghijklmnop", 0, false),
                ""
        );
    }

    @Test
    public void testStringUtils_NullString() {

        assertThrows(IllegalArgumentException.class, () -> {

            StringUtils.truncate(null, 25);
        });
    }

    @Test
    public void testStringUtils_NegativeLength() {

        assertThrows(IllegalArgumentException.class, () -> {

            StringUtils.truncate("abcdefghijklmnop", -1);
        });
    }
}
