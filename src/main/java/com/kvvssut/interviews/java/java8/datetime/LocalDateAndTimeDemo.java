package com.kvvssut.interviews.java.java8.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateAndTimeDemo {

    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        System.out.println("Current date is : " + currentDate);

        LocalDate specificDate = LocalDate.of(2005, 9, 5);
        System.out.println("\nSpecific date is : " + specificDate);

        LocalTime currentTime = LocalTime.now();
        System.out.println("\nCurrent time is : " + currentTime);

        LocalTime specificTime = LocalTime.of(9, 5, 59);
        System.out.println("\nSpecific time is : " + specificTime);

        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("\nCurrent date and time is : " + currentDateTime);

        LocalDateTime specificDateTime = LocalDateTime.of(specificDate, specificTime);
        System.out.println("\nSpecific date and time is : " + specificDateTime);

    }

}