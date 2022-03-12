package com.kvvssut.interviews.java.java8.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ProcessingDataWithJava8Streams {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Srimant", 25));
        personList.add(new Person("Sangita", 27));
        personList.add(new Person("Smita", 30));
        personList.add(new Person("Srikant", 32));
        personList.add(new Person("Maa", 57));
        personList.add(new Person("Bapa", 65));

        Predicate<Person> nameStartsWithSPredicate = (person) -> !person
                .getName().startsWith("S");

        System.out
                .println("Java 8 way - with explicit predicate check inside implementation");
        personList.forEach(p -> {
            if (nameStartsWithSPredicate.test(p)) {
                System.out.println(p.printDefault());
            }
        });

        System.out.println("\nJava 8 streams - better implementation");
        personList.stream().filter(nameStartsWithSPredicate)
                .forEach(p -> System.out.println(p.printDefault()));

        System.out
                .println("\nJava 8 paralel streams - better implementation - executes the collection in parallel - Type 1");
        personList.parallelStream().filter(nameStartsWithSPredicate)
                .forEach(p -> System.out.println(p.printDefault()));

        System.out
                .println("\nJava 8 paralel streams - better implementation - executes the collection in parallel - Type 2");
        personList.stream().parallel().filter(nameStartsWithSPredicate)
                .forEach(p -> System.out.println(p.printDefault()));

        Person[] personArray = personList.toArray(new Person[0]);

        System.out
                .println("\nConverting arrays to streams for use of lambda expressions - Type 1");
        Stream<Person> stream1 = Stream.of(personArray);
        stream1.filter(nameStartsWithSPredicate).forEach(
                p -> System.out.println(p.printDefault()));

        System.out
                .println("\nConverting arrays to streams for use of lambda expressions - Type 2");
        Stream<Person> stream2 = Arrays.stream(personArray);
        stream2.parallel().filter(nameStartsWithSPredicate)
                .forEach(p -> System.out.println(p.printDefault()));

        System.out.println("\nCreating List - ");
        List<String> strings = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            strings.add("Item : " + i + " ");
        }

        System.out.println("\nPrinting list sequentially with stream - ");
        strings.stream().forEach(str -> System.out.print(str));

        System.out.println("\n\nPrinting list with parallel stream - ");
        strings.parallelStream().forEach(str -> System.out.print(str));

        System.out.println("\n\nCounting items in list -");

        Long count = strings.stream().count();
        System.out.println("List count is : " + count);

        int sum = personList.stream().mapToInt(person -> person.getAge()).sum();
        System.out.println("\nSum of ages is : " + sum);

        OptionalDouble avg = personList.stream().mapToInt(p -> p.getAge())
                .average();
        if (avg.isPresent()) {
            System.out.println("\nAverage of all ages is : "
                    + avg.getAsDouble());
        } else {
            System.out
                    .println("\nAverage is not calculated - error is - divide / 0");
        }
    }

}
