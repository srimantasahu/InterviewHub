package com.kvvssut.interviews.java.java12.stringindenttransform;

/*
Indent method is used to add an indentation to each line of a string. It returns a new String instance with the specified number of spaces added to the beginning of each line.
&
Transform method applies a transformation function to the string and returns the result. It’s a way to perform operations on strings in a more functional programming style.
 */
public class StringIndentAndTransform {

    public static void main(String[] args) {
        String original = "Hello\nWorld";

        String indented = original.indent(4);
        System.out.println(indented);
        // Output:
        //     Hello
        //     World

        String transformed = original.transform(String::toUpperCase);
        System.out.println(transformed);
        // Output:
        // HELLO
        // WORLD
    }

}
