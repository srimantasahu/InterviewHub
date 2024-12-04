package com.kvvssut.interviews.java.versions.java8.streams;

import com.kvvssut.interviews.java.versions.java8.lambdas.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StreamDemo {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<Person>();
        people.add(new Person("Sam", 26));
        people.add(new Person("Joe", 70));
        people.add(new Person("Mike", 42));

        Predicate<Person> predOlder = (person) -> person.getAge() >= 60;

        System.out.println("Printing all old persons using lambda exp -");
        people.forEach(p -> {
            if (predOlder.test(p)) {
                System.out.println(p);
            }
        });

        System.out.println("\nPrinting all persons using sequential streams -");
        people.stream().forEach(p -> System.out.println(p));

        System.out.println("\nPrinting all old persons using sequential streams -");
        people.stream().filter(predOlder).forEach(p -> System.out.println(p));

        System.out.println("\nPrinting all old persons using parallel streams -");
        people.parallelStream().filter(predOlder).forEach(p -> System.out.println(p));

        System.out.println("\nPrinting all old persons by converting sequential stream into parallel stream -");
        people.stream().parallel().filter(predOlder).forEach(p -> System.out.println(p));
    }

}