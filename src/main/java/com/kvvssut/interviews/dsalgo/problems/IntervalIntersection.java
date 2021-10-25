package com.kvvssut.interviews.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class IntervalIntersection {

    public static void main(String[] args) {
        int[][] result = new IntervalIntersection().intervalIntersection(new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}}, new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}});
        Arrays.stream(result).forEach(res -> System.out.print("[" + res[0] + "," + res[1] + "] "));
    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> result = new ArrayList<>();

        for (int i = 0, j = 0; i < A.length && j < B.length; ) {
            if (A[i][0] > B[j][1]) {
                j++;
            } else if (B[j][0] > A[i][1]) {
                i++;
            } else {
                result.add(new int[]{Math.max(A[i][0], B[j][0]), Math.min(A[i][1], B[j][1])});
                if (A[i][1] < B[j][1]) {
                    i++;
                } else if (B[j][1] < A[i][1]) {
                    j++;
                } else {
                    i++;
                    j++;
                }
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}