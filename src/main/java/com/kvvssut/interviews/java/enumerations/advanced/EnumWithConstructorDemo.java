package com.kvvssut.interviews.java.enumerations.advanced;

public class EnumWithConstructorDemo {

    public static void main(String[] args) {
        for (ColorWithConstructorEnum color : ColorWithConstructorEnum.values()) {
            System.out.println(color.name());
        }

        System.out.println("\nColor of enum element is : "
                + ColorWithConstructorEnum.GREEN.getColorText());
        System.out.println("Fill percentage is : "
                + ColorWithConstructorEnum.GREEN.getFillPercentage());
    }
}
