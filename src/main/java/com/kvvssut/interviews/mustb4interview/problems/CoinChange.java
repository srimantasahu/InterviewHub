package com.kvvssut.interviews.mustb4interview.problems;

import java.util.Arrays;

/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.

Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:
Input: coins = [2], amount = 3
Output: -1

Example 3:
Input: coins = [1], amount = 0
Output: 0

Constraints:
1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
 */
public class CoinChange {
    public static void main(String[] args) {
        CoinChange obj = new CoinChange();
        System.out.println(obj.coinChange(new int[]{1, 2, 5}, 11)); // 3
        System.out.println(obj.coinChange(new int[]{2}, 3));      // -1
        System.out.println(obj.coinChange(new int[]{1}, 0));      // 0
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;   // no coins needed for amount=0

        int INF = amount + 1;        // "infinity"
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;                   // base case

        for (int coin : coins) {
            if (coin > amount) continue; // skip useless coins
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] == INF ? -1 : dp[amount];
    }
}