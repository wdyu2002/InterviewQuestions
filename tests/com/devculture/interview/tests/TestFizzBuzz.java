package com.devculture.interview.tests;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestFizzBuzz {

    @Test
    public void testFizz() {
        assertTrue(FizzBuzz.fizzBuzz(3).contains("fizz"));
        assertTrue(FizzBuzz.fizzBuzz(9).contains("fizz"));
        assertTrue(FizzBuzz.fizzBuzz(300).contains("fizz"));
    }

    @Test
    public void testBuzz() {
        assertTrue(FizzBuzz.fizzBuzz(5).contains("buzz"));
        assertTrue(FizzBuzz.fizzBuzz(20).contains("buzz"));
        assertTrue(FizzBuzz.fizzBuzz(300).contains("buzz"));
    }

    @Test
    public void testFizzBuzz() {
        assertTrue(FizzBuzz.fizzBuzz(15).contains("fizzbuzz"));
        assertTrue(FizzBuzz.fizzBuzz(300).contains("fizzbuzz"));
        assertTrue(FizzBuzz.fizzBuzz(1500).contains("fizzbuzz"));
    }

    @Test
    public void testNoResults() {
        assertTrue(FizzBuzz.fizzBuzz(0).length() == 0);
        assertTrue(FizzBuzz.fizzBuzz(1).length() == 0);
        assertTrue(FizzBuzz.fizzBuzz(29).length() == 0);
        assertTrue(FizzBuzz.fizzBuzz(59).length() == 0);
    }
}
