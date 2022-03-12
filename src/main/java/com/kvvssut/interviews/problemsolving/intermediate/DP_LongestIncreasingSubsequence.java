package com.kvvssut.interviews.problemsolving.intermediate;

/*
    Given an integer array nums, return the length of the longest strictly increasing subsequence.

    A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements.
    For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

    Input: nums = [10,9,2,5,3,7,101,18]
    Output: 4
    Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
*/

public class DP_LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int[] values = new int[nums.length];
        int max = 1;

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            values[i] = 1;

            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < cur && values[j] >= values[i]) {
                    values[i] = values[j] + 1;
                    if (values[i] > max) {
                        max = values[i];
                    }
                }
            }
        }

        return max;
    }

}
