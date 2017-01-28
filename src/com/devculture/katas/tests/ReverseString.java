package com.devculture.katas.tests;

import java.util.Stack;

/**
 * Basic string reversal test.
 */
class ReverseString {

    /**
     * First implementation utilizing a stack's First-In-Last-Out property.
     */
    static String reverseStringUsingStack(String input) {
        // utilizing stack's FILO property.
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<input.length(); i++) {
            stack.push(input.charAt(i));
        }
        StringBuilder buf = new StringBuilder();
        while (!stack.empty()) {
            buf.append(stack.pop());
        }
        return buf.toString();
    }

    /**
     * Basic reverse string implementation using a for-loop.
     */
    static String reverseStringSimple(String input) {
        // simple reverse string.
        StringBuilder buf = new StringBuilder();
        for (int i=input.length()-1; i>=0; i--) {
            buf.append(input.charAt(i));
        }
        return buf.toString();
    }
}
