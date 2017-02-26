package com.devculture.katas.patterns;

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
