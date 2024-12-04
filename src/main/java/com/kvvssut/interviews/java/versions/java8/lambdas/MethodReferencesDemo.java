package com.kvvssut.interviews.java.versions.java8.lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MethodReferencesDemo {

    public static int compareAges(Person p1, Person p2) {
        Integer age1 = p1.getAge();
        return age1.compareTo(p2.getAge());
    }

    public static void main(String[] args) {
        List<Person> people = new ArrayList<Person>();
        people.add(new Person("Sam", 26));
        people.add(new Person("Joe", 70));
        people.add(new Person("Mike", 42));

        System.out.println("Sorting by age using static method reference -");
        Collections.sort(people, MethodReferencesDemo::compareAges);
        people.forEach(p -> System.out.println(p));

        System.out.println("\nSorting by name using instance method reference -");
        Collections.sort(people, new MethodReferencesDemo()::compareNames);
        people.forEach(p -> System.out.println(p));

    }

    public int compareNames(Person p1, Person p2) {
        return p1.getName().compareTo(p2.getName());
    }

}