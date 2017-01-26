package com.devculture.interview.syntax;

/**
 * Sample demonstrating new java 8 syntax allowing interfaces with default methods.
 */
public class DefaultMethodsExample {

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

    private static class Elephant implements AnimalThatSleeps {

    }

    private static class Kangaroo implements AnimalThatJumps, AnimalThatSleeps {

    }

    public static void main(String[] args) {
        Elephant e = new Elephant();
        e.sleep();

        Kangaroo k = new Kangaroo();
        k.sleep();
        k.jump();
    }
}
