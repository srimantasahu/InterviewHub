package com.kvvssut.interviews.codinground.java;

import java.util.Arrays;
import java.util.TreeMap;

/*
Tracks intervals and computes total coverage length after each insertion.
Uses TreeMap to efficiently merge overlapping intervals.

Example:
Stream = [[1,3],[5,7],[2,6]]
Coverage after each step = [3, 6, 7]
*/
public class MergeIntervalsCoverageTreeMap {

    // Stores intervals as: start -> end
    private final TreeMap<Integer, Integer> intervals = new TreeMap<>();
    private int totalCoverage = 0;

    public static void main(String[] args) {
        MergeIntervalsCoverageTreeMap tracker = new MergeIntervalsCoverageTreeMap();

        int[][] stream = {{1, 3}, {5, 7}, {2, 6}};
        int[] result = tracker.processStream(stream);

        System.out.println(Arrays.toString(result)); // [3, 6, 7]
    }

    public int[] processStream(int[][] stream) {
        int[] result = new int[stream.length];
        for (int i = 0; i < stream.length; i++) {
            addInterval(stream[i][0], stream[i][1]);
            result[i] = totalCoverage;
        }
        return result;
    }

    public void addInterval(int start, int end) {
        if (start > end) return; // invalid interval safeguard

        // Try to merge with the closest interval on the left
        Integer leftKey = intervals.floorKey(start);
        if (leftKey != null && intervals.get(leftKey) >= start - 1) {
            end = Math.max(end, intervals.get(leftKey));
            start = leftKey;

            // remove and adjust coverage
            totalCoverage -= (intervals.get(leftKey) - leftKey + 1);
            intervals.remove(leftKey);
        }

        // Merge with all overlapping intervals on the right
        Integer rightKey = intervals.ceilingKey(start);
        while (rightKey != null && rightKey <= end + 1) {
            end = Math.max(end, intervals.get(rightKey));

            totalCoverage -= (intervals.get(rightKey) - rightKey + 1);
            intervals.remove(rightKey);

            rightKey = intervals.ceilingKey(start);
        }

        // Insert the merged interval and update coverage
        intervals.put(start, end);
        totalCoverage += (end - start + 1);
    }

}