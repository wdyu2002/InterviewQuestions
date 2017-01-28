package com.devculture.katas.tests;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestToLowerString {

    @Test
    public void canConvertStringsToLowerCase() {
        assertEquals("abc", UpperToLower.toLower("ABC"));
        assertEquals("hello world", UpperToLower.toLower("HellO wORLd"));
        assertEquals("h3ll0 w0rld", UpperToLower.toLower("H3LL0 W0RLD"));
    }
}
