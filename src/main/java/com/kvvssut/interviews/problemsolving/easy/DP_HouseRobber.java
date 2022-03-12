package com.kvvssut.interviews.problemsolving.easy;

/*
    You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
    the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and
    it will automatically contact the police if two adjacent houses were broken into on the same night.

    Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

    Input: nums = [2,7,9,3,1]
    Output: 12
    Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
    Total amount you can rob = 2 + 9 + 1 = 12.
*/

public class DP_HouseRobber {

    public int rob(int[] nums) {
        int len = nums.length;

        if (len == 1) {
            return nums[0];
        } else if (len == 2) {
            return Math.max(nums[0], nums[1]);
        } else if (len == 3) {
            return Math.max(nums[0] + nums[2], nums[1]);
        } else {
            int[] values = new int[len];
            values[0] = nums[0];
            values[1] = nums[1];
            values[2] = Math.max(nums[0] + nums[2], nums[1]);
            int max = values[2];

            for (int i = 3; i < len; i++) {
                values[i] = Math.max(values[i - 2], values[i - 3]) + nums[i];
                if (values[i] > max) {
                    max = values[i];
                }
            }

            return max;
        }
    }

}
