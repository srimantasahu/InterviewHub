package com.kvvssut.interviews.dsalgo.problems;

import java.util.Arrays;

class ContiguousArray {

    public static void main(String[] args) {
        System.out.println(new ContiguousArray().findMaxLength(new int[]{0, 1, 0, 0, 1, 0, 0, 1, 1}));
    }

    public int findMaxLength(int[] nums) {
        if (nums.length < 2) return 0;
        int maxLength = 0;
        int[] arr = new int[2 * nums.length + 1];
        Arrays.fill(arr, -2);
        arr[nums.length] = -1;
        int counter = nums.length;
        Arrays.stream(nums).mapToObj(o -> String.format("%2d ", o)).forEach(System.out::print);
        for (int i = 0; i < nums.length; i++) {
            Arrays.stream(arr).mapToObj(o -> String.format("%2d ", o)).forEach(System.out::print);
            counter += nums[i] * 2 - 1;
            if (arr[counter] == -2) {
                arr[counter] = i;
            } else {
                maxLength = Math.max(maxLength, i - arr[counter]);
            }
        }
        return maxLength;
    }

}