package com.devculture.interview;

/**
 * FizzBuzz should print fizz when the number passed in is divisible by 3.
 * FizzBuzz should print buzz when the number passed in is divisible by 5.
 * FizzBuzz should print fizzbuzz when the number passed in is divisible by both 3 and 5.
 */
class FizzBuzzExample {

    static String fizzBuzz(int n) {
        StringBuffer buffer = new StringBuffer();
        if (n == 0) {
            return "";
        }
        if (n%3 == 0) {
            buffer.append("fizz");
        }
        if (n%5 == 0) {
            buffer.append("buzz");
        }
        return buffer.toString();
    }

}
