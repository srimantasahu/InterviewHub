package com.kvvssut.interviews.java.java11.vartypeinlambda;

/*
Local variable type inference (the “var” type) can also be used with lambda expressions in Java.
This feature introduced in Java 11, allows us to declare the type of variables within lambda expressions using var.
This improves code readability while still maintaining the benefits of static typing.
 */

import java.util.List;

public class LocalVariableTypeInLambdaExpression {

    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie");

        names.forEach((var name) -> {
            System.out.println("Hello, " + name);
        });
    }

}
