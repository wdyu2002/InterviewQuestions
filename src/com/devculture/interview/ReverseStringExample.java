package com.devculture.interview;

import java.util.Stack;

/**
 * Created by dyu on 1/19/17.
 */
public class ReverseStringExample implements Runnable {

    public String reverseStringUsingStack(String input) {
        // utilizing stack's FILO property.
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<input.length(); i++) {
            stack.push(input.charAt(i));
        }

        StringBuffer stringBuffer = new StringBuffer();
        while (!stack.empty()) {
            stringBuffer.append(stack.pop());
        }
        return stringBuffer.toString();
    }

    public String reverseStringSimple(String input) {
        // simple reverse string.
        StringBuffer buffer = new StringBuffer();
        for (int i=input.length()-1; i>=0; i--) {
            buffer.append(input.charAt(i));
        }
        return buffer.toString();
    }

    public void run() {
        System.out.println(reverseStringUsingStack("abcdefg"));
        System.out.println(reverseStringSimple("abcdefg"));
    }
}
