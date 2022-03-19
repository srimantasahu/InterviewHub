package com.kvvssut.interviews.problemsolving.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Item {
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class ItemStore {

    private final Map<String, List<Item>> itemsMap = new HashMap<>();

    public void addItem(String name) {
        List<Item> items = itemsMap.get(name);

        if (items == null) {
            synchronized(itemsMap) {
                items = new ArrayList<>();
                items.add(new Item(name));
                itemsMap.put(name, items);
            }
        } else {
            items.add(new Item(name));
        }
    }

    public List<Item> getItemsByNameIgnoreCase(String name) {
        return itemsMap.entrySet().stream()
                .filter((e) -> name.equalsIgnoreCase(e.getKey()))
                .map(Map.Entry::getValue)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}

public class Java8PredicateFlatMapNameIgnoreCaseCheck {

    public static void main(String[] args) {
        ItemStore store = new ItemStore();

        store.addItem("first");
        store.addItem("second");
        store.addItem("SECOND");
        store.addItem("SEcoND");

        List<Item> items = store.getItemsByNameIgnoreCase("second");

        items.forEach(i -> System.out.println(i.getName()));
    }
}
