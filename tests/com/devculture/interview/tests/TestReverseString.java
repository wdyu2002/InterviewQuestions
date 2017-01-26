package com.devculture.interview.tests;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestReverseString {

    // helper method to test all 3 sorting algorithms.
    private void testReverseStringImpl(String input, String expectedResult) {
        assertEquals(expectedResult, ReverseStringExample.reverseStringSimple(input));
        assertEquals(expectedResult, ReverseStringExample.reverseStringUsingStack(input));
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
