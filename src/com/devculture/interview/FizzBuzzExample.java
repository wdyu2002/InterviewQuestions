package com.devculture.interview;

/**
 * Created by dyu on 1/19/17.
 */
public class FizzBuzzExample implements Runnable {

    public String printFizzBuzz(int n) {
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

    public void run() {
        // fizz when %3 == 0
        // buzz when %5 == 0
        // fizzbuzz when %3 && %5 == 0
        for (int i=0; i<25; i++) {
            System.out.printf("%d %s\n", i, printFizzBuzz(i));
        }
    }
}
