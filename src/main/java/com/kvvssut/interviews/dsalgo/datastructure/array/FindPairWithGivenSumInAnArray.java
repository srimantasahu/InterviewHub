package com.kvvssut.interviews.dsalgo.datastructure.array;

import java.util.HashSet;

public class FindPairWithGivenSumInAnArray {

    public static void main(String[] args) {
        int[] inputs = {2, 7, 5, 10, 11, 14, 9, 3, 4};
        int sum = 10;
        int[] results = getPairWithGivenSum(inputs, sum);

        if (results == null) {
            System.out.println("No matching pairs found!");
        } else {
            System.out.printf("Pair found -> %d + %d = %d", results[0], results[1], sum);
        }
    }

    private static int[] getPairWithGivenSum(int[] inputs, int sum) {
        int now = -1;
        HashSet<Integer> keySet = new HashSet<Integer>();

        for (int i = 0; i < inputs.length; i++) {
            now = inputs[i];
            if (keySet.contains(sum - now)) {
                return new int[]{sum - now, now};
            } else {
                keySet.add(now);
            }
        }
        return null;
    }

}
