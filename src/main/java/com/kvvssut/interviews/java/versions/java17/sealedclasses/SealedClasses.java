package com.kvvssut.interviews.java.versions.java17.sealedclasses;

/*
Sealed class is a feature introduced in Java 15 to enhance the control over class inheritance and ensure that only specific subclasses can extend it.
It provides a way to declare a limited set of classes that are allowed to inherit from the sealed class, while preventing other classes from extending it.
 */
public class SealedClasses {

    /*
    In this example, the Shape class is declared as sealed using the sealed keyword.
    The permits keyword is used to specify the classes that are allowed to inherit from Shape.
     */

    public sealed class Shape permits Circle, Square, Rectangle {
    }

    public final class Circle extends Shape {
    }

    public non-sealed class Square extends Shape {
    }

    public sealed class Rectangle extends Shape permits TransparentRectangle, FilledRectangle {
    }

    public final class TransparentRectangle extends Rectangle {
    }

    public final class FilledRectangle extends Rectangle {
    }

    /*
    Key features of sealed classes

    Controlled Inheritance: Sealed classes allow you to control which classes can extend them, preventing unwanted or unexpected subclasses.

    Limited Subclasses: The permits keyword specifies a list of classes that can be direct subclasses of the sealed class.

    Open and Non-Sealed: Sealed classes can also allow classes to extend them that are open or non-sealed, offering more flexibility in class hierarchy design.

    Final by Default: Sealed classes are implicitly final, meaning they cannot be directly instantiated or subclassed unless explicitly permitted.

    Use Cases: Sealed classes are useful for modeling closed hierarchies where you want to limit the number of subclasses,
               ensuring better control over the design and behavior of your class hierarchy.
     */

}
