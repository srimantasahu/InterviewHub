package com.kvvssut.interviews.dsalgo.problems;

import java.util.Arrays;

class PossibleBiPartition {

    public static void main(String[] args) {
        System.out.println(new PossibleBiPartition().possibleBipartition(10, new int[][]{{4,7},{4,8},{5,6},{1,6},{3,7},{2,5},{5,8},{1,2},{4,9},{6,10},{8,10},{3,6},{2,10},{9,10},{3,9},{2,3},{1,9},{4,6},{5,7},{3,8},{1,8},{1,7},{2,4}}));
    }

    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] group = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            group[i] = i;
        }

        for (int[] dislike : dislikes) {
            Arrays.stream(group).mapToObj(o -> String.format("%3d ", o)).forEach(System.out::print);
            int a = dislike[0];
            int b = dislike[1];

            if (group[b] == group[a]) {
                return false;
            } else if (group[a] == a && group[b] == b) {
                group[a] = b;
                group[b] = a;
            } else if (group[a] == a && group[b] != b) {
                group[a] = group[group[b]];
            } else if (group[b] == b && group[a] != a) {
                group[b] = group[group[a]];
            }
        }

        return true;
    }
}