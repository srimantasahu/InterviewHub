package com.kvvssut.interviews.java.java9.privateinterfacemethods;

/*
Private interface methods are a feature introduced in Java 9 to allow interfaces to have private methods.
These methods are intended to be used within the interface itself, primarily for code reuse and improved readability.
They cannot be accessed or overridden by implementing classes or other classes outside the interface.
 */

public interface PrivateInterfaceMethods {

    default void publicMethod() {
        privateMethod();
    }

    private void privateMethod() {
        System.out.println("Private method in interface.");
    }

}
