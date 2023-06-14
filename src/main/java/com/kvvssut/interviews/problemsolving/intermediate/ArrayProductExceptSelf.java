package com.kvvssut.interviews.problemsolving.intermediate;

import java.util.Arrays;

public class ArrayProductExceptSelf {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ArrayProductExceptSelf().productExceptSelf(new int[]{1, 2, 3, 4})));
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftProduct = new int[n], rightProduct = new int[n], output = new int[n];

        int val = 1;
        for (int i = 0; i < n; i++) {
            leftProduct[i] = val;
            val *= nums[i];
        }

        val = 1;
        for (int i = n - 1; i >= 0; i--) {
            rightProduct[i] = val;
            val *= nums[i];
        }

        for (int i = 0; i < n; i++) {
            output[i] = leftProduct[i] * rightProduct[i];
        }

        return output;
    }

}
