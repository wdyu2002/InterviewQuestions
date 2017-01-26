package com.devculture.interview.tests;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestToLowerString {

    @Test
    public void canConvertStringsToLowerCase() {
        assertEquals("abc", UpperToLowerExample.toLower("ABC"));
        assertEquals("hello world", UpperToLowerExample.toLower("HellO wORLd"));
        assertEquals("h3ll0 w0rld", UpperToLowerExample.toLower("H3LL0 W0RLD"));
    }
}
