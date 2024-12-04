package com.kvvssut.interviews.java.versions.java8.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.util.Locale;

public class LocalDateAndTimeFormatterDemo {

    public static void main(String[] args) {

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter df = DateTimeFormatter.ISO_DATE;
        System.out.println("Current date in ISO_DATE format is : " + df.format(currentDate));

        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter tf = DateTimeFormatter.ISO_TIME;
        System.out.println("\nCurrent time in ISO_TIME format is : " + tf.format(currentTime));

        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME;
        System.out.println("\nCurrent date and time in ISO_DATE_TIME format is : " + dtf.format(currentDateTime));

        DateTimeFormatter df_full = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        System.out.println("\nCurrent date in FULL format is : " + df_full.format(currentDateTime));

        DateTimeFormatter dtf_short = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        System.out.println("\nCurrent date and time in SHORT format is : " + dtf_short.format(currentDateTime));

        String fr_full = df_full.withLocale(Locale.FRENCH).format(currentDateTime);
        System.out.println("\nCurrent date in FULL format and FRENCH locale is : " + fr_full);

        String fr_short = dtf_short.withLocale(Locale.FRENCH).format(currentDateTime);
        System.out.println("\nCurrent date and time in SHORT format and FRENCH locale is : " + fr_short);

        DateTimeFormatterBuilder formatterBuilder = new DateTimeFormatterBuilder().appendValue(ChronoField.DAY_OF_MONTH)
                .appendLiteral('|').appendValue(ChronoField.MONTH_OF_YEAR).appendLiteral('|')
                .appendValue(ChronoField.YEAR);
        DateTimeFormatter formatter = formatterBuilder.toFormatter();
        System.out.println("\nCurrent date in custom format dd|MM|yyyy is : " + formatter.format(currentDateTime));

    }

}