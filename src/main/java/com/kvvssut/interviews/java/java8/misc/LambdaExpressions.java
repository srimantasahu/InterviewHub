package com.kvvssut.interviews.java.java8.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

@FunctionalInterface
interface SimpleFunctionalInterface {
    public void doSomething();
}

@FunctionalInterface
interface ComplexFunctionalInterfaceWithArguments {
    public void addName(String firstname, String lastname);
}

interface PersonInterface {
    /*
     * Java 8 static methods -
     */
    static String printStatic(Person person) {
        return "Person [name=" + person.getName() + ", age=" + person.getAge() + "]";
    }

    public String getName();

    public void setName(String name);

    public int getAge();

    public void setAge(int age);

    /*
     * Java 8 default methods -
     */
    default String printDefault() {
        return "Person [name=" + getName() + ", age=" + getAge() + "]";
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Old Way - creates a class!");
    }
}

class Person implements PersonInterface {
    private String name;
    private int age;

    protected Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static int compareAges(Person p1, Person p2) {
        Integer p1Age = p1.age;
        return p1Age.compareTo(p2.age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}

public class LambdaExpressions {

    public static void main(String[] args) {
        MyRunnable r0 = new MyRunnable();
        new Thread(r0, "oldWayThread").start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("\nAnonymous Way - doesn't create a class!");
            }
        }, "anonymousWayThread").start();
        ;

        /*
         * Using Lambda Expressions below -
         */

        // arrow token -> is know as the lambda operator. () before lambda
        // operator is the signature of method (now it is empty, else we need to
        // provide the arguments name only) and after codes are the
        // implementations.
        Runnable r1 = () -> System.out.println("\nJava 8 Anonymous Function Way - single line code!");
        new Thread(r1, "java8SingleLineThread").start();

        Runnable r2 = () -> {
            System.out.println("\nJava 8 Anonymous Function Way - multiple lines code - Line1!");
            System.out.println("Java 8 Anonymous Function Way - multiple lines code - Line2!");
        };
        new Thread(r2, "java8MultipleLinesThread").start();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*
         * Using custom functional interface -
         */

        SimpleFunctionalInterface simpleObj = () -> System.out
                .println("\nSimple functional interface - with abstract doSomething method!");
        simpleObj.doSomething();

        ComplexFunctionalInterfaceWithArguments complexObj = (firstname, lastname) -> System.out.println(
                "\nComplex functional interface - addName method - resulted name is : " + firstname + " " + lastname);
        complexObj.addName("Srimanta", "Sahu");

        /*
         * Using lambda expression with pre-defined interfaces
         */

        List<String> strings = Arrays.asList("AAA", "bbb", "CCC", "dddd", "EEE");

        System.out.println("\nSimple case-sensitive sort operation");
        Collections.sort(strings);
        for (String string : strings) {
            System.out.println(string);
        }

        System.out.println(
                "\nCase-insensitive sort with comparator using lambda expression and printing the results using new forEach method");
        Collections.sort(strings, (str1, str2) -> str1.compareToIgnoreCase(str2));

        /*
         * Added in Java8 inside Iterable interface, it takes a functional interface
         * Consumer<? super T> which has a single abstract method accept(T t)
         */
        strings.forEach(str -> System.out.println(str));

        /*
         * Using Predicate interface to wrap conditional processing -
         */
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Srimant", 25));
        personList.add(new Person("Sangita", 27));
        personList.add(new Person("Smita", 30));
        personList.add(new Person("Srikant", 32));
        personList.add(new Person("Maa", 57));
        personList.add(new Person("Bapa", 65));

        Predicate<Person> oldAged = (person) -> person.getAge() >= 50;
        Predicate<Person> youngAged = (person) -> person.getAge() < 30;

        System.out.println("\n\"Printing Person using java 8 default method\"");

        System.out.println("\nUsing oldAged predicate -");
        printPersonByPredicate(personList, oldAged);

        System.out.println("\nUsing youngAged predicate -");
        printPersonByPredicate(personList, youngAged);

        System.out.println("\n\"Printing Person using java 8 static method\"");
        /*
         * Java 8 method references usage -
         */
        new LambdaExpressions().sortDataUsingJava8MethodReferences(personList);

    }

    private static void printPersonByPredicate(List<Person> personList, Predicate<Person> oldAged) {
        personList.forEach((person) -> {
            if (oldAged.test(person)) {
                // using java 8 default method printPerson
                System.out.println(person.printDefault());
            }
        });
    }

    private void sortDataUsingJava8MethodReferences(List<Person> personList) {
        System.out.println("\nUse of Java 8 Method references, using static method to sort in asc order-");
        Collections.sort(personList, Person::compareAges);
        // using java 8 default method printPerson
        personList.forEach(person -> System.out.println(PersonInterface.printStatic(person)));

        System.out.println("\nUse of Java 8 Method references, using instance method to sort in desc order -");
        Collections.sort(personList, this::compareAges);
        // using java 8 default method printPerson
        personList.forEach(person -> System.out.println(PersonInterface.printStatic(person)));
    }

    // sorting in desc order
    public int compareAges(Person p1, Person p2) {
        Integer p2Age = p2.getAge();
        return p2Age.compareTo(p1.getAge());
    }

}
