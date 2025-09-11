package com.kvvssut.interviews.miscellaneous.leetcode.hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

/*
Given an integer array nums, return an integer array counts where counts[i] is the number of smaller elements to the right of nums[i].

Example 1:
Input: nums = [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
Example 2:
Input: nums = [-1]
Output: [0]
Example 3:
Input: nums = [-1,-1]
Output: [0,0]
Constraints:
1 <= nums.length <= 105
-104 <= nums[i] <= 104
 */

public class CountOfSmallerNumbersAfterSelf_WIP {

    public static void main(String[] args) {
//        System.out.println(new CountOfSmallerNumbersAfterSelf_WIP().countSmaller(new int[]{5, 2, 6, 1}));
        System.out.println(new CountOfSmallerNumbersAfterSelf_WIP().countSmaller(new int[]{-1, -1}));
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Entry> entries = IntStream.range(0, n)
                .mapToObj(i -> new Entry(nums[i], i))
                .sorted(Comparator.comparing(Entry::val).thenComparing(Entry::idx, Comparator.reverseOrder())).toList();
        Integer[] counts = new Integer[n];

        for (int i = 0; i < n; i++) {
            int idx = entries.get(i).idx;

            if (i > idx) {
                counts[idx] = i - idx;
            } else if (i == idx) {
                counts[idx] = i;
            } else {
                counts[idx] = 0;
            }
        }

        return Arrays.asList(counts);
    }

    private record Entry(int val, int idx) {
    }

}
