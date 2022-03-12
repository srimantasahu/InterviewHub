package com.kvvssut.interviews.java.programs;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortMapOnValuesUsingStreams {

    public static void main(String[] args) {
        Map<Integer, String> map = new LinkedHashMap<Integer, String>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");

        List<Entry<Integer, String>> entryList = map.entrySet().stream().map(Function.identity())
                .collect(Collectors.toList());

        Collections.sort(entryList, new Comparator<Entry<Integer, String>>() {

            @Override
            public int compare(Entry<Integer, String> e1, Entry<Integer, String> e2) {
                int value = 0;
                if (e1.getValue() == e2.getValue()) {
                    value = 0;
                } else if (Objects.isNull(e1.getValue())) {
                    value = -1;
                } else if (Objects.isNull(e2.getValue())) {
                    value = 1;
                } else {
                    value = e1.getValue().compareTo(e2.getValue());
                }
                return value;
            }
        });

        map.clear();

        entryList.stream().forEach(entry -> {
            map.put(entry.getKey(), entry.getValue());
        });

        map.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + " & " + entry.getValue()));
    }

}
