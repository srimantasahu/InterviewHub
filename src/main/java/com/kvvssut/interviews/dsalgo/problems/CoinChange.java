package com.kvvssut.interviews.dsalgo.problems;

class CoinChange {

    public static void main(String[] args) {
        System.out.println(new CoinChange().change(5, new int[]{5, 1, 2}));
    }

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }
}