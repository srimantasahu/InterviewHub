package com.kvvssut.interviews.dsalgo.problems;

class MaxUncrossedLines {

    public static void main(String[] args) {
        System.out.println(new MaxUncrossedLines().maxUncrossedLines(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2}));
    }

    public int maxUncrossedLines(int[] A, int[] B) {
        int aLen = A.length;
        int bLen = B.length;

        int[][] dp = new int[aLen][bLen];

        if (A[0] == B[0]) {
            dp[0][0] = 1;
        }

        for (int i = 1; i < aLen; i++) {
            if (A[i] == B[0]) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }

        for (int j = 1; j < bLen; j++) {
            if (B[j] == A[0]) {
                dp[0][j] = 1;
            } else {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for (int i = 1; i < aLen; i++) {
            for (int j = 1; j < bLen; j++) {
                if (A[i] == B[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[aLen - 1][bLen - 1];
    }
}