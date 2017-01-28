package com.devculture.katas.tests;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestReverseString {

    // helper method to test all 3 sorting algorithms.
    private void testReverseStringImpl(String input, String expectedResult) {
        assertEquals(expectedResult, ReverseString.reverseStringSimple(input));
        assertEquals(expectedResult, ReverseString.reverseStringUsingStack(input));
    }

    @Test
    public void canReverseStrings() {
        testReverseStringImpl("a", "a");
        testReverseStringImpl("ab", "ba");
        testReverseStringImpl("abc", "cba");
        testReverseStringImpl("dddd", "dddd");
        testReverseStringImpl("abcdefg", "gfedcba");
    }
}
