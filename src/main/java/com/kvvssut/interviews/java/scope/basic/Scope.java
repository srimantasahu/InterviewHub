package com.kvvssut.interviews.java.scope.basic;

public class Scope {

    int age = 25;

    public static void main(String[] args) {

        new Scope().manipulateAge();

    }

    private void manipulateAge() {

        System.out.println(age);

        {
            int age = 30;
            System.out.println(age);
        }

        int age = 35;
        System.out.println(age);

    }

}
