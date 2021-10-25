package com.kvvssut.interviews.java.programs;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SortingMapOnValues {

	public static void main(String[] args) {
		Map<Integer, String> map = new TreeMap<Integer, String>();
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		map.put(4, "four");
		map.put(5, "five");

		List<Entry<Integer, String>> entryList = new LinkedList<Entry<Integer, String>>();
		for (Entry<Integer, String> entry : map.entrySet()) {
			entryList.add(entry);
		}

		Collections.sort(entryList, new Comparator<Entry<Integer, String>>() {

			@Override
			public int compare(Entry<Integer, String> entry1, Entry<Integer, String> entry2) {
				return entry1.getValue().compareTo(entry2.getValue());
			}

		});

		map = new LinkedHashMap<>(map.size());

		for (Entry<Integer, String> entry : entryList) {
			map.put(entry.getKey(), entry.getValue());
		}

		for (Entry<Integer, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
	}

}
