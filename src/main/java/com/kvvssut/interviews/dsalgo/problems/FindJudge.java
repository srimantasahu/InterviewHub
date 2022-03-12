package com.kvvssut.interviews.dsalgo.problems;

class FindJudge {

    public static void main(String[] args) {
        System.out.println(new FindJudge().findJudge(4, new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}}));
    }

    public int findJudge(int N, int[][] trust) {
        if (trust.length >= N - 1) {
            int[] cntarr = new int[N];

            for (int i = 0; i < trust.length; i++) {
                cntarr[trust[i][0] - 1]--;
                cntarr[trust[i][1] - 1]++;
            }

            for (int i = 0; i < N; i++) {
                if (cntarr[i] == N - 1) {
                    return i + 1;
                }
            }
        }

        return -1;
    }
}