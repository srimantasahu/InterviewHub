package com.kvvssut.interviews.dsalgo.problems;

import java.util.Arrays;
import java.util.Comparator;

class TwoCityScheduling {

    public static void main(String[] args) {
        System.out.println(new TwoCityScheduling().twoCitySchedCost(new int[][]{{400, 50}, {30, 20}, {10, 20}, {30, 200}}));
    }

    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt(p -> p[0] - p[1]));

        int sum = 0;
        int len = costs.length;

        for (int i = 0; i < len / 2; i++) {
            sum += costs[i][0] + costs[len - i - 1][1];
        }

        return sum;
    }
}