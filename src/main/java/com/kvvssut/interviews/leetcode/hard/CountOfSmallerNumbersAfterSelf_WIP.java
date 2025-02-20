package com.kvvssut.interviews.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

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
        System.out.println(new CountOfSmallerNumbersAfterSelf_WIP().countSmaller(new int[]{5, 2, 6, 1}));
        System.out.println(new CountOfSmallerNumbersAfterSelf_WIP().countSmaller(new int[]{-1, 0}));
    }

    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        List<Integer> counts = new ArrayList<>(len);
        counts.add(0); // for last entry

        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; ) {
                if (nums[j] == nums[i]) {
                    counts.addFirst(counts.get(j - i - 1));
                    break;
                } else if (nums[j] < nums[i]) {
                    counts.addFirst(counts.get(j - i - 1) + 1);
                    break;
                }
                if (++j == len) {
                    counts.addFirst(0);
                }
            }
        }

        return counts;
    }


}
