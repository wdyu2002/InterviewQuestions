package com.devculture.interview;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestFizzBuzz {

    @Test
    public void testFizz() {
        assertTrue(FizzBuzzExample.fizzBuzz(3).contains("fizz"));
        assertTrue(FizzBuzzExample.fizzBuzz(9).contains("fizz"));
        assertTrue(FizzBuzzExample.fizzBuzz(300).contains("fizz"));
    }

    @Test
    public void testBuzz() {
        assertTrue(FizzBuzzExample.fizzBuzz(5).contains("buzz"));
        assertTrue(FizzBuzzExample.fizzBuzz(20).contains("buzz"));
        assertTrue(FizzBuzzExample.fizzBuzz(300).contains("buzz"));
    }

    @Test
    public void testFizzBuzz() {
        assertTrue(FizzBuzzExample.fizzBuzz(15).contains("fizzbuzz"));
        assertTrue(FizzBuzzExample.fizzBuzz(300).contains("fizzbuzz"));
        assertTrue(FizzBuzzExample.fizzBuzz(1500).contains("fizzbuzz"));
    }

    @Test
    public void testNoResults() {
        assertTrue(FizzBuzzExample.fizzBuzz(0).length() == 0);
        assertTrue(FizzBuzzExample.fizzBuzz(1).length() == 0);
        assertTrue(FizzBuzzExample.fizzBuzz(29).length() == 0);
        assertTrue(FizzBuzzExample.fizzBuzz(59).length() == 0);
    }
}
