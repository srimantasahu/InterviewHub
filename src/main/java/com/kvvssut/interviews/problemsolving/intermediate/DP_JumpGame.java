package com.kvvssut.interviews.problemsolving.intermediate;

/*
    You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

    Return true if you can reach the last index, or false otherwise.

    Input: nums = [2,3,1,1,4]
    Output: true
    Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

    Input: nums = [3,2,1,0,4]
    Output: false
    Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

 */

public class DP_JumpGame {

    public boolean canJump(int[] nums) {
        int len = nums.length;

        if (len == 1) {
            return true;
        }

        int[] vals = new int[len];

        for (int i = 0; i < len - 1; i++) {
            int cur = nums[i];

            if (cur == 0 && vals[i + 1] == 0) {
                break;
            }

            for (int j = 1; j <= cur; j++) {
                if (i + j < len) {
                    vals[i + j] = 1;
                    if (i + j == len - 1) {
                        break;
                    }
                }
            }
        }

        return vals[len - 1] == 1;
    }

}
