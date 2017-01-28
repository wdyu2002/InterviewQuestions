package com.devculture.katas.syntax;

import java.util.ArrayList;
import java.util.List;

/**
 * Sample demonstrating new java 8 syntax for lambda expressions.
 */
public class LambdaExpressionsExample {

    public static void main(String[] args) {
        // populate list.
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        // basic lambda notation example.
        list.forEach((x) -> System.out.println(x));

        // even simpler.
        list.forEach(System.out::println);

        // even simpler.
        list.forEach(System.out::println);

        // basic lambda notation run example.
        new Thread(() -> System.out.println(1)).start();

        // multiple lines example.
        new Thread(() -> {
            int count = 10;
            do {
                System.out.print(count + "..");
            } while (--count >= 0);
            System.out.println("Blast off!");
        }).start();
    }
}
