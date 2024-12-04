package com.kvvssut.interviews.java.versions.java8.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.Set;

public class DateTimeAPI {

    public static void main(String[] args) {
        Instant start = Instant.now();
        System.out.println("Start : " + start);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Instant end = Instant.now();
        System.out.println("End : " + end);

        Duration elapsed = Duration.between(start, end);
        System.out.println("Elapsed : " + elapsed);
        System.out.println("Elapsed in millis : " + elapsed.toMillis());

        LocalDate currentDate = LocalDate.now();
        System.out.println("\nCurrent date is : " + currentDate);
        LocalDate specificDate = LocalDate.of(2000, 01, 01);
        System.out.println("Specific date is : " + specificDate);

        LocalTime currentTime = LocalTime.now();
        System.out.println("\nCurrent time is : " + currentTime);
        LocalTime specificTime = LocalTime.of(14, 59, 05, 595000000);
        System.out.println("Specific time is : " + specificTime);

        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("\nCurrent datetime is : " + currentDateTime);
        LocalDateTime specificDateTime = LocalDateTime.of(specificDate,
                specificTime);
        System.out.println("Specific datetime is : " + specificDateTime);

        DateTimeFormatter df = DateTimeFormatter.ISO_DATE;
        System.out.println("\nFormatted current date in ISO_DATE format : "
                           + df.format(currentDate));

        DateTimeFormatter tf = DateTimeFormatter.ISO_TIME;
        System.out.println("\nFormatted current time in ISO_TIME format : "
                           + tf.format(currentTime));

        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME;
        System.out
                .println("\nFormatted current datetime in ISO_DATE_TIME format : "
                         + dtf.format(currentDateTime));

        DateTimeFormatter f_full = DateTimeFormatter
                .ofLocalizedDate(FormatStyle.FULL);
        System.out
                .println("\nFormatted current datetime in FULL format style : "
                         + f_full.format(currentDateTime));

        DateTimeFormatter f_short = DateTimeFormatter
                .ofLocalizedDate(FormatStyle.SHORT);
        System.out
                .println("\nFormatted current datetime in SHORT format style : "
                         + f_short.format(currentDateTime));

        String it_full = f_full.withLocale(Locale.ITALIAN).format(
                currentDateTime);
        System.out
                .println("\nFormatted current datetime in FULL format style with ITALIAN locale : "
                         + it_full);

        String it_short = f_short.withLocale(Locale.ITALIAN).format(
                currentDateTime);
        System.out
                .println("\nFormatted current datetime in SHORT format style with ITALIAN locale : "
                         + it_short);

        DateTimeFormatterBuilder dtfBuilder = new DateTimeFormatterBuilder()
                .appendValue(ChronoField.DAY_OF_MONTH).appendLiteral('|')
                .appendValue(ChronoField.MONTH_OF_YEAR).appendLiteral('|')
                .appendValue(ChronoField.YEAR);
        DateTimeFormatter dtFormatter = dtfBuilder.toFormatter();
        System.out
                .println("\nCustom formatted current datetime with '|' delimiter : "
                         + dtFormatter.format(currentDateTime));

        ZonedDateTime gmt = ZonedDateTime.now(ZoneId.of("GMT+0"));
        System.out.println("\nFormatted in GMT+0 : " + dtf.format(gmt));

        ZonedDateTime ny = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("\nFormatted in America/New_York : "
                           + dtf.format(ny));

        Set<String> zones = ZoneId.getAvailableZoneIds();
        zones.stream().filter(z -> z.contains("London"))
                .forEach(z -> System.out.println("\nTimeZone found is : " + z));

    }
}
