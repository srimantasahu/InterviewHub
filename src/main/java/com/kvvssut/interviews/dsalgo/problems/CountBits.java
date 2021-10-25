package com.kvvssut.interviews.dsalgo.problems;

import java.util.Arrays;

class CountBits {

    public static void main(String[] args) {
        Arrays.stream(new CountBits().countBits(28)).mapToObj(i -> i + " ").forEach(System.out::print);
    }

    public int[] countBits(int num) {
        int[] lookup = new int[num + 1];

        for (int i = 0; i <= num; i++) {
            lookup[i] = lookup[i / 2] + i % 2;
        }

        return lookup;
    }

}