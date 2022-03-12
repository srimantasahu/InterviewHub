package com.kvvssut.interviews.java.java8.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateFIDemo {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<Person>();
        people.add(new Person("Sam", 26));
        people.add(new Person("Joe", 70));
        people.add(new Person("Mike", 42));

        // 1. Using Inner class syntax
        Predicate<Person> predOlder = new Predicate<Person>() {

            @Override
            public boolean test(Person person) {
                return person.getAge() >= 60;
            }
        };

        System.out.println("Printing all old persons - ");
        displayPeople(people, predOlder);

        // 2. Using Lambda expression
        Predicate<Person> predYounger = (person) -> person.getAge() <= 30;

        System.out.println("\nPrinting all young persons -");
        displayPeople(people, predYounger);
    }

    private static void displayPeople(List<Person> people, Predicate<Person> predicate) {
        people.forEach(p -> {
            if (predicate.test(p)) {
                System.out.println(p);
            }
        });
    }

}