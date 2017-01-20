package com.devculture.interview;

/**
 * Created by dyu on 1/18/17.
 */
public class DefaultMethodsExample implements Runnable {

    // interface default methods example.
    private interface AnimalThatJumps {
        default void jump() {
            System.out.println("I can jump");
        }
    }

    private interface AnimalThatSleeps {
        default void sleep() {
            System.out.println("I can sleep");
        }
    }

    private class Elephant implements AnimalThatSleeps {

    }

    private class Kangaroo implements AnimalThatJumps, AnimalThatSleeps {

    }

    public void run() {
        Elephant e = new Elephant();
        e.sleep();

        Kangaroo k = new Kangaroo();
        k.sleep();
        k.jump();
    }
}
