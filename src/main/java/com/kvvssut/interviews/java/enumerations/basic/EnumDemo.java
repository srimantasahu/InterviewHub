package com.kvvssut.interviews.java.enumerations.basic;

public class EnumDemo {

    public static void main(String[] args) {
        for (ColorEnum color : ColorEnum.values()) {
            System.out.println(color.name());
        }

        System.out.println("\nColor of enum element is : "
                           + getColor(ColorEnum.GREEN));
    }

    private static String getColor(ColorEnum color) {
        String colorText = "";

        switch (color) {
            case BLUE:
                colorText = "Blue";
                break;
            case GREEN:
                colorText = "Green";
                break;
            case RED:
                colorText = "Red";
                break;
        }
        return colorText;
    }

}
