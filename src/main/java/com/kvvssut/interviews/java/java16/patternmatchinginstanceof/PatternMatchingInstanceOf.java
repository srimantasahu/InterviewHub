package com.kvvssut.interviews.java.java16.patternmatchinginstanceof;

/*
Java 14 introduces instanceof operator to have type test pattern as is a preview feature.
Type test pattern has a predicate to specify a type with a single binding variable.
It continues to be a preview feature in Java 15 as well. With Java 16, this feature is now a part of standard delivery.
 */
public class PatternMatchingInstanceOf {

    public static void main(String[] args) {
        Object animal = new Cat();

        // Traditional instanceof
        if (animal instanceof Cat) {
            Cat cat = (Cat) animal;
            cat.meow();
            // other cat operations
        }

        // Modern instanceof
        if (animal instanceof Cat cat) {
            cat.meow();
        }
    }

    private static class Cat {
        public void meow() {
            System.out.println("meow meow..");
        }
    }

}
