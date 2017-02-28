package com.devculture.katas.patterns;

/**
 * Note: IMO there are 3 major issues with this pattern:
 *
 * 1. If handler's makeSound(cat/dog) method was private, you will definitely get stack overflow.
 * 2. If handler's makeSound(cat/dog) method was default, you may get stack overflow when the Vocal classes reside in a
 *    different package, but not when they reside in the same package.
 * 3. This means handler's makeSound(cat/dog) method MUST BE public, which might not be desired due to encapsulation
 *    requirements.
 *
 */
public class DispatchPatternExample {

    interface Vocal {
        void makeSound(Handler handler);
    }

    static class Cat implements Vocal {
        @Override
        public void makeSound(Handler handler) {
            handler.makeSound(this);
        }
    }

    static class Dog implements Vocal {
        @Override
        public void makeSound(Handler handler) {
            handler.makeSound(this);
        }
    }

    static class Handler {
        void makeSound(Vocal vocal) {
            vocal.makeSound(this);
        }

        void makeSound(Cat cat) {
            System.out.println("I'm a cat");
        }

        void makeSound(Dog dog) {
            System.out.println("I'm a dog");
        }
    }

    public static void main(String[] args) {
        Handler handler = new Handler();
        Vocal vocal;

        vocal = new Dog();
        handler.makeSound(vocal);
        handler.makeSound(new Dog());

        vocal = new Cat();
        handler.makeSound(vocal);
        handler.makeSound(new Cat());
    }

}
