package com.kvvssut.interviews.leetcode.medium;

import java.util.Arrays;

/*
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

Constraints:
1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105

Follow up:
Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
Could you do it in-place with O(1) extra space?
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        new RotateArray().rotate(nums, 3);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{-1, -100, 3, 99};
        new RotateArray().rotate(nums, 2);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 2};
        new RotateArray().rotate(nums, 2);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 2, 3, 4, 5, 6};
        new RotateArray().rotate(nums, 3);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54};
        new RotateArray().rotate(nums, 45);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        int len = nums.length, start = 0, pos = start, prev = nums[pos], cur;
        for (int i = 0; i < len; i++) {
            pos = (pos + k) % len;
            if (pos == start) {
                nums[pos] = prev;
                pos = ++start;
                if (pos < len)
                    prev = nums[pos];
            } else {
                cur = nums[pos];
                nums[pos] = prev;
                prev = cur;
            }
        }
    }

}
