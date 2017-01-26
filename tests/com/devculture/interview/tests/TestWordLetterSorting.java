package com.devculture.interview.tests;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestWordLetterSorting {

    // helper method to test all 3 sorting algorithms.
    private void testSortStringsImpl(String input, String expectedResult) throws Exception {
        assertEquals(expectedResult, WordLetterSortingExample.sort1(input));
        assertEquals(expectedResult, WordLetterSortingExample.sort2(input));
        assertEquals(expectedResult, WordLetterSortingExample.sort3(input));
    }

    @Test
    public void canSortStrings() throws Exception {
        testSortStringsImpl("", "");
        testSortStringsImpl("apple", "alepp");
        testSortStringsImpl("apepe", "appee");
        testSortStringsImpl("appee", "appee");
        testSortStringsImpl("apppee", "apppee");
        testSortStringsImpl("appeee", "appeee");
        testSortStringsImpl("testing", "esingtt");
        testSortStringsImpl("mississippi", "miiiisssspp");
        testSortStringsImpl("aardvark", "dvkaaarr");
        testSortStringsImpl("aaaaaaaaaaaaaaaaaaaab", "baaaaaaaaaaaaaaaaaaaa");
    }

    @Test(expected = IllegalArgumentException.class)
    public void canAlg1ThrowExceptionOnNullInput() {
        WordLetterSortingExample.sort1(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canAlg2ThrowExceptionOnNullInput() {
        WordLetterSortingExample.sort2(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canAlg3ThrowExceptionOnNullInput() {
        WordLetterSortingExample.sort3(null);
    }
}
