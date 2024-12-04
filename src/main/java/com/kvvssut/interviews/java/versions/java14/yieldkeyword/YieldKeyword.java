package com.kvvssut.interviews.java.versions.java14.yieldkeyword;

/*
Java 12 introduces expressions to Switch statement and released it as a preview feature.
Java 13 added a new yield construct to return a value from switch statement.
With Java 14, switch expression now is a standard feature.
 */
public class YieldKeyword {

    public static void main(String[] args) {
        System.out.println(getDayType("AnyDay")); // yields - Invalid day.
    }

    public static String getDayType(String day) {
        var result = switch (day) {
            case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday":
                yield "Weekday";
            case "Saturday", "Sunday":
                yield "Weekend";
            default:
                yield "Invalid day.";
        };

        return result;
    }

}
