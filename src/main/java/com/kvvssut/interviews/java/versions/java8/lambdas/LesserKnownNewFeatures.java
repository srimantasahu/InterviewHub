package com.kvvssut.interviews.java.versions.java8.lambdas;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeSet;
import java.util.stream.Stream;

public class LesserKnownNewFeatures {

    public static void main(String[] args) {
        stringJoiner();
        fileSearch();
    }

    private static void stringJoiner() {
        String founders = String.join(" and ", "Larry", "Sergey", "Moe");
        System.out.println("Using String join with multiple CharSequences : "
                           + founders);

        String[] states = {"Haryana", "Punjab", "Himachal"};
        String statesList = String.join(", ", states);
        System.out
                .println("\nUsing String join with iterable instance of CharSequence : "
                         + statesList);

        StringJoiner sj1 = new StringJoiner(", ", "{", "}");
        sj1.setEmptyValue("StringJoiner is empty now!");
        System.out.println("\nEmpty StringJoiner value is : " + sj1);

        sj1.add("Haryana").add("Punjab").add("Himachal");
        System.out
                .println("\nUsing StringJoiner with delimiter & prefix & suffix arguments : "
                         + sj1);

        StringJoiner sj2 = new StringJoiner(", ", "{", "}");
        sj2.add("Odisha");
        sj2.merge(sj1);
        System.out.println("\nMerging StringJoiner instances : " + sj2);

        Set<String> set = new TreeSet<String>();
        set.add("Larry");
        set.add("Sergey");
        set.add("Moe");

        StringJoiner sj3 = new StringJoiner(" and ");
        set.forEach(s -> sj3.add(s));
        System.out.println("\nAdded colelction's items to a StringJoiner : "
                           + sj3);
    }

    private static void fileSearch() {
        Path path = FileSystems.getDefault().getPath("src", "Java-Tutorial.txt");

        String seachItem = "JVM provides security.";

        try (Stream<String> lines = Files.lines(path)) {

            Optional<String> line = lines.filter(l -> l.contains(seachItem))
                    .findFirst();
            if (line.isPresent()) {
                System.out.println("\n\nLine found is : " + line.get());
            } else {
                System.out.println("Not found!");
            }
        } catch (Exception e) {
            System.out.println("There was an error : " + e.getMessage());
        }

    }

}
