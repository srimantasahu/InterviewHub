package com.kvvssut.interviews.dsalgo.problems;

class MaxSubarraySumCircular {

    public static void main(String[] args) {
        System.out.println(new MaxSubarraySumCircular().maxSubarraySumCircular(new int[]{3, 5, -3, -1, 2, 4, -1}));
    }

    public int maxSubarraySumCircular(int[] inputs) {
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int cumulativeMaxSum = 0;
        int cumulativeMinSum = 0;
        int total = 0;

        for (int input : inputs) {
            cumulativeMaxSum = Math.max(cumulativeMaxSum + input, input);
            if (cumulativeMaxSum > maxSum) {
                maxSum = cumulativeMaxSum;
            }
            cumulativeMinSum = Math.min(cumulativeMinSum + input, input);
            if (cumulativeMinSum < minSum) {
                minSum = cumulativeMinSum;
            }
            total += input;
        }

        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }
}