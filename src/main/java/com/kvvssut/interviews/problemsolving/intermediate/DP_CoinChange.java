package com.kvvssut.interviews.problemsolving.intermediate;

/*
    You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

    Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

    You may assume that you have an infinite number of each kind of coin.

    Input: coins = [1,2,5], amount = 11
    Output: 3
    Explanation: 11 = 5 + 5 + 1
*/

public class DP_CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] values = new int[amount + 1];

        values[0] = 0;

        for (int i = 1; i <= amount; i++) {
            values[i] = -1;
        }

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (values[i - coin] >= 0) {
                    if (values[i] >= 0) {
                        values[i] = Math.min(values[i - coin] + 1, values[i]);
                    } else {
                        values[i] = values[i - coin] + 1;
                    }
                }
            }
        }

        return values[amount];
    }

}
