package com.kvvssut.interviews.java.java10.vartype;

/*
Local Variable Type Inference, often referred to as “var” type, is a feature that allows us to declare local variables without explicitly specifying their types.
The compiler infers the type of the variable based on the assigned value. This feature aims to improve code readability while maintaining strong typing.

The var type is used only for local variables with an initializer. It cannot be used for method parameters, return types, class fields, or uninitialized variables.
While var reduces boilerplate code, it’s important to use meaningful variable names for clarity.
 */

public class LocalVariableTypeInference {

    public static void main(String[] args) {
        var name = "John Doe"; // Infers String type
        var age = 30; // Infers int type
        var salary = 50000.0; // Infers double type

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);

        // Compile-time error: var must be initialized
        // var uninitializedVar;
    }

}
