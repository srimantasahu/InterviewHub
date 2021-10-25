package com.kvvssut.interviews.dsalgo.problems;

class EditDistance {

    public static void main(String[] args) {
        System.out.println(new EditDistance().minDistance("horse", "ros"));
    }

    public int minDistance(String word1, String word2) {
        return editDistance(word1, word2, word1.length(), word2.length());
    }

    private int editDistance(String word1, String word2, int m, int n) {
        int[] dp0 = new int[n + 1];
        for (int j = 0; j <= n; j++) {
            dp0[j] = j;
        }

        for (int i = 1; i <= m; i++) {
            int[] dp1 = new int[n + 1];
            dp1[0] = i;
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp1[j] = dp0[j - 1];
                } else {
                    dp1[j] = 1 + Math.min(dp1[j - 1], Math.min(dp0[j], dp0[j - 1]));
                }
            }
            dp0 = dp1;
        }

        return dp0[n];
    }

}