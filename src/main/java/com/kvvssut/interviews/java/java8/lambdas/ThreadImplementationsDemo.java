package com.kvvssut.interviews.java.java8.lambdas;

public class ThreadImplementationsDemo {


    public static void main(String[] args) {
        // ************** PRIOR TO JAVA 8 **************//

        // 1. Using a class implementing Runnable
        MyRunnable runnable11 = new MyRunnable();
        new Thread(runnable11).start();

        // 2. Using an Inner class
        Runnable runnable12 = new Runnable() {

            @Override
            public void run() {
                System.out.println("Runnable inner class : Hello World!\n");
            }
        };
        new Thread(runnable12).start();

        // 3. Using an Anonymous class
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("Anonymous class : Hello World!\n");
            }
        }).start();

        // ************** USING JAVA 8 LAMBDA EXPRESSIONS ************** //

        // 1. Inner Class implementation with single statement
        Runnable runnable21 = () -> System.out
                .println("[JAVA8] Inner class impl with single statement : Hello World!\n");
        new Thread(runnable21).start();

        // 2. Inner Class implementation with multiple statements
        Runnable runnable22 = () -> {
            System.out.println("[JAVA8] Inner class impl with multiple statements : ");
            System.out.println("Hello World!\n");
        };
        new Thread(runnable22).start();

        // 3. Anonymous Class implementation with single statement
        new Thread(() -> System.out.println("[JAVA8] Anonymous class impl with single statement : Hello World!\n"))
                .start();

        // 4. Anonymous Class implementation with multiple statements
        new Thread(() -> {
            System.out.println("[JAVA8] Anonymous class impl with multiple statements : ");
            System.out.println("Hello World!\n");
        }).start();

    }
}