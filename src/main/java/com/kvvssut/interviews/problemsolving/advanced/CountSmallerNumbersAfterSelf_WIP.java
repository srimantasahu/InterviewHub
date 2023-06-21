package com.kvvssut.interviews.problemsolving.advanced;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Given an integer array nums, return an integer array counts where
 * counts[i] is the number of smaller elements to the right of nums[i].
 */
public class CountSmallerNumbersAfterSelf_WIP {

    public static void main(String[] args) {
        System.out.println(new CountSmallerNumbersAfterSelf_WIP().countSmaller(new int[] {2,0,1}));
    }

    //TODO : fix me
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;;
        int[] counts = new int[n];

        for (int i = n-2; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                if (nums[j] < nums[i]) {
                    counts[i] = counts[j] + 1;
                    break;
                }
            }
        }

        return IntStream.of(counts).boxed().collect(Collectors.toList());
    }

}
