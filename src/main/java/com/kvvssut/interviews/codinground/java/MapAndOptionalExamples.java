package com.kvvssut.interviews.codinground.java;

import java.util.*;
import java.util.concurrent.*;

public class MapAndOptionalExamples {

    public static void main(String[] args) {

        // --- Map.putIfAbsent ---
        System.out.println("=== putIfAbsent ===");

        Map<String, Integer> stock = new HashMap<>();
        stock.put("apple", 50);
        stock.putIfAbsent("apple", 100); // won't update
        stock.putIfAbsent("banana", 30); // inserts new key

        System.out.println("Stock after putIfAbsent: " + stock);
        System.out.println();


        // --- Map.computeIfAbsent ---
        System.out.println("=== computeIfAbsent ===");

        Map<String, List<String>> categoryMap = new HashMap<>();

        categoryMap.computeIfAbsent("fruits", k -> new ArrayList<>()).add("Apple");
        categoryMap.computeIfAbsent("fruits", k -> new ArrayList<>()).add("Banana");
        categoryMap.computeIfAbsent("veggies", k -> new ArrayList<>()).add("Carrot");

        System.out.println("Category map: " + categoryMap);
        System.out.println();


        // --- Map.computeIfPresent ---
        System.out.println("=== computeIfPresent ===");

        Map<String, Integer> itemCount = new HashMap<>();
        itemCount.put("pen", 10);
        itemCount.computeIfPresent("pen", (k, v) -> v + 5); // 10 → 15
        itemCount.computeIfPresent("pencil", (k, v) -> v + 5); // not present

        System.out.println("Item count after computeIfPresent: " + itemCount);
        System.out.println();


        // --- Map.merge ---
        System.out.println("=== merge ===");

        Map<String, Integer> sales = new HashMap<>();
        sales.put("Alice", 10);
        sales.merge("Alice", 5, Integer::sum);  // 10 + 5 = 15
        sales.merge("Bob", 7, Integer::sum);    // not present → insert 7

        System.out.println("Sales after merge: " + sales);
        System.out.println();


        // --- Increment Count if Present (counter style) ---
        System.out.println("=== Increment Value If Present ===");

        Map<String, Integer> counterMap = new HashMap<>();
        counterMap.put("viewCount", 1);

        counterMap.computeIfPresent("viewCount", (k, v) -> v + 1); // increment
        counterMap.computeIfPresent("clickCount", (k, v) -> v + 1); // not present

        System.out.println("Counter map: " + counterMap);
        System.out.println();


        // --- ConcurrentHashMap: Thread-Safe Use Case ---
        System.out.println("=== ConcurrentHashMap Examples (Thread-Safe) ===");

        ConcurrentHashMap<String, Integer> concurrentCounter = new ConcurrentHashMap<>();


        // Use case: safely count logins from multiple threads
        concurrentCounter.put("user1", 1);

        concurrentCounter.putIfAbsent("user1", 100); // Won't update
        concurrentCounter.putIfAbsent("user2", 1);   // Inserts

        concurrentCounter.computeIfPresent("user1", (k, v) -> v + 1); // user1 = 2
        concurrentCounter.computeIfAbsent("user3", k -> 1);           // user3 = 1

        concurrentCounter.merge("user1", 1, Integer::sum); // user1 = 3

        System.out.println("ConcurrentCounter: " + concurrentCounter);
        System.out.println();


        // --- Optional Examples ---
        System.out.println("=== Optional Examples ===");

        Optional<String> optName = Optional.of("Alice");

        optName.ifPresent(name -> System.out.println("Hello, " + name));

        String nameOrDefault = optName.orElse("Guest");
        System.out.println("Name or default: " + nameOrDefault); // Alice

        int nameLength = optName.map(String::length).orElse(0);
        System.out.println("Name length: " + nameLength); // 5

        Optional<String> emptyName = Optional.ofNullable(null);
        String fallback = emptyName.orElse("Fallback");
        System.out.println("Fallback name: " + fallback); // Fallback

        // --- Optional + Map combo ---
        System.out.println("=== Optional + Map Example ===");

        Map<String, String> emailMap = Map.of("admin", "admin@example.com");
        String email = Optional.ofNullable(emailMap.get("user"))
                .orElse("default@example.com");

        System.out.println("Email: " + email); // default@example.com

        System.out.println("\nAll features demonstrated successfully.");
    }
}
