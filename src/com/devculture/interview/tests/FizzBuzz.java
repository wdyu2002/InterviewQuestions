package com.devculture.interview.tests;

/**
 * FizzBuzz should print fizz when the number passed in is divisible by 3.
 * FizzBuzz should print buzz when the number passed in is divisible by 5.
 * FizzBuzz should print fizzbuzz when the number passed in is divisible by both 3 and 5.
 */
class FizzBuzz {

    static String fizzBuzz(int n) {
        StringBuilder buf = new StringBuilder();
        if (n == 0) {
            return "";
        }
        if (n%3 == 0) {
            buf.append("fizz");
        }
        if (n%5 == 0) {
            buf.append("buzz");
        }
        return buf.toString();
    }
}
