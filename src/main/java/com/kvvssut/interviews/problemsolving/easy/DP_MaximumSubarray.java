package com.kvvssut.interviews.problemsolving.easy;

/*
    Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

    A subarray is a contiguous part of an array.

    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.
*/

public class DP_MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int prev = nums[0];
        int max = nums[0];

        for (int i = 1; i < len; i++) {
            int curr = nums[i];

            if (prev + curr < curr) {
                prev = curr;
                if (curr > max) {
                    max = curr;
                }
            } else {
                prev = prev + curr;
                if (prev > max) {
                    max = prev;
                }
            }
        }

        return max;
    }

}
