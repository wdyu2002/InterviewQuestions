package com.devculture.interview;

/**
 * Created by dyu on 1/19/17.
 */
public class UpperToLowerExample implements Runnable {

    public String toLower(String string) {
        return string.toLowerCase();
    }

    public void run() {
        System.out.println(toLower("hello World"));
        System.out.println(toLower("WTF"));
        System.out.println(toLower("zOMG"));
    }
}
