package com.kvvssut.interviews.java.java9.modulesystem;

/*
https://openjdk.org/projects/jigsaw/quick-start

check /src/main/java/module-info.java

One of the main motivations for this is to provide modular JVM, which can run on devices with a lot less available memory.
The JVM could run with only those modules and APIs which are required by the application.
It also addresses issues related to strong encapsulation, classpath pollution, and versioning conflicts that have been problematic in the Java ecosystem.
 */

public class Main {

    public static void main(String[] args) {
        System.out.println("Greetings!");
    }

}
