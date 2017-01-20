package com.devculture.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dyu on 1/18/17.
 */
public class LambdaExpressionsExample implements Runnable {

    public void run() {
        // populate list.
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        // basic lambda notation example.
        System.out.println("-- example 1 --");
        list.stream().forEach((x) -> System.out.println(x));

        // even simpler.
        System.out.println("-- example 2 --");
        list.stream().forEach(System.out::println);

        // even simpler.
        System.out.println("-- example 3 --");
        list.forEach(System.out::println);

        // basic lambda notation run example.
        new Thread(() -> System.out.println(1)).start();

        // multiple lines example.
        System.out.println("-- blast off example --");
        new Thread(() -> {
            int count = 10;
            do {
                System.out.print(count + "..");
            } while (--count >= 0);
            System.out.println("Blast off!");
        }).start();
    }
}
