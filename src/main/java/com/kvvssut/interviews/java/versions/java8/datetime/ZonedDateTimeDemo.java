package com.kvvssut.interviews.java.versions.java8.datetime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Optional;
import java.util.Set;

public class ZonedDateTimeDemo {

    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);

        LocalDateTime dt = LocalDateTime.now();
        System.out.println("Current date and time in SHORT format is : " + dtf.format(dt));

        ZonedDateTime gmt = ZonedDateTime.now(ZoneId.of("GMT+0"));
        System.out.println("\nCurrent GMT date and time in SHORT format is : " + dtf.format(gmt));

        ZonedDateTime ny = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("\nCurrent NY date and time in SHORT format is : " + dtf.format(ny));

        Set<String> zones = ZoneId.getAvailableZoneIds();
        System.out.println("\nPrinting all available zones : ");
        zones.forEach(zone -> System.out.println(zone));

        // Printing Dubai's date and time in SHORT format
        Optional<String> zone = zones.stream().filter(str -> str.contains("Dubai")).findFirst();
        if (zone.isPresent()) {
            ZonedDateTime dubai = ZonedDateTime.now(ZoneId.of(zone.get()));
            System.out.println(
                    String.format("\nDubai zone's string is : %s \nCurrent Dubai date and time in SHORT format is : %s",
                            zone, dtf.format(dubai)));
        } else {
            System.out.println("Timezone not found!");
        }

    }

}