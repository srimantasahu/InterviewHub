package com.kvvssut.interviews.dsalgo.problems;

class MaxSubArrayProduct {

    public static void main(String[] args) {
        System.out.println(new MaxSubArrayProduct().maxProduct(new int[]{2, 3, -2, 4, 2}));
    }

    public int maxProduct(int[] nums) {
        int globalMax = nums[0];
        int prevMax = nums[0];
        int prevMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curMax = Math.max(prevMax * nums[i], Math.max(prevMin * nums[i], nums[i]));
            int curMin = Math.min(prevMax * nums[i], Math.min(prevMin * nums[i], nums[i]));
            globalMax = Math.max(globalMax, curMax);
            prevMax = curMax;
            prevMin = curMin;
        }

        return globalMax;
    }
}