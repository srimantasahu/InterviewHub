package com.kvvssut.interviews.java.versions.java8.lambdas;

public class FunctionalInterfacesDemo {

    public static void main(String[] args) {
        // 1. Custom FI Demo with no arguments
        SimpleFunctionalInterface sfi = () -> System.out.println("SimpleFunctionalInterface : Hello World!\n");
        sfi.doSomething();

        // 2. Custom FI Demo with arguments
        FunctionalInterfaceWithArgs withArgs = (s1, s2) -> {
            String result = s1 + s2;
            System.out.println("FunctionalInterfaceWithArgs : The result is [" + result + "]\n");
        };
        withArgs.doSomething("Hello ", "World!");
    }

    @FunctionalInterface
    interface SimpleFunctionalInterface {
        public void doSomething();
    }

    @FunctionalInterface
    interface FunctionalInterfaceWithArgs {
        public void doSomething(String str1, String str2);
    }

}