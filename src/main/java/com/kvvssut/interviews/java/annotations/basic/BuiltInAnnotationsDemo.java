package com.kvvssut.interviews.java.annotations.basic;

public class BuiltInAnnotationsDemo {

    @SuppressWarnings("deprecation")
    // annotation to suppress deprecated method usage warning
    public static void main(String[] args) {

        ColorMethods.printAllColors(); // Warning - The method printAllColors()
        // from the type ColorMethods is
        // deprecated
        ColorMethods.printColor(2);
    }

}
