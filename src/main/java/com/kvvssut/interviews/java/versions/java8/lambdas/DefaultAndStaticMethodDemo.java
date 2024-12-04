package com.kvvssut.interviews.java.versions.java8.lambdas;

import java.util.ArrayList;
import java.util.List;

public class DefaultAndStaticMethodDemo {

    public static void main(String[] args) {
        List<PersonInfo> people = new ArrayList<PersonInfo>();
        people.add(new PersonInfo("Sam", 26));
        people.add(new PersonInfo("Joe", 70));
        people.add(new PersonInfo("Mike", 42));

        System.out.println("Using \"default method\" to print person info -");
        people.forEach(p -> System.out.println(p.getPersonInfo()));

        System.out.println("\nUsing \"static method\" to print person info");
        people.forEach(p -> System.out.println(PersonInterface.getPersonInfo(p)));

    }
}