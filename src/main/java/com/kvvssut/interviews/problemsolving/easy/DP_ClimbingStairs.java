package com.kvvssut.interviews.problemsolving.easy;

/*
    You are climbing a staircase. It takes n steps to reach the top.

    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

    Input: n = 3
    Output: 3
    Explanation: There are three ways to climb to the top.
    1. 1 step + 1 step + 1 step
    2. 1 step + 2 steps
    3. 2 steps + 1 step
*/

public class DP_ClimbingStairs {

    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        int[] values = new int[n];
        values[0] = 1;
        values[1] = 2;

        for (int i = 2; i < n; i++) {
            values[i] = values[i - 1] + values[i - 2];
        }

        return values[n - 1];
    }

}
