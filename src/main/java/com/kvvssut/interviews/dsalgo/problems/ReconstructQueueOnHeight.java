package com.kvvssut.interviews.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class ReconstructQueueOnHeight {

    public static void main(String[] args) {
        int[][] result = new ReconstructQueueOnHeight().reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
        Stream.of(result).forEach(res -> System.out.println(res[0] + ", " + res[1]));
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a1, a2) -> {
            int val = Integer.compare(a2[0], a1[0]);
            return val == 0 ? Integer.compare(a1[1], a2[1]) : val;
        });

        List<int[]> list = new ArrayList<>();

        for (int[] person : people) {
            list.add(person[1], person);
        }

        return list.toArray(new int[0][]);
    }
}