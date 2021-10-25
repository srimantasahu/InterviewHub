package com.kvvssut.interviews.dsalgo.problems;

import java.util.Arrays;

class SortColorsInto3Groups {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0, 1};
        new SortColorsInto3Groups().sortColors(nums);
        Arrays.stream(nums).forEach(num -> System.out.print(num + " "));
    }

    public void sortColors(int[] nums) {
        int startOf1 = -1;
        int startOf2 = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (startOf1 != -1) {
                    nums[startOf1++] = 0;
                    if (startOf2 != -1) {
                        nums[startOf2++] = 1;
                        nums[i] = 2;
                    } else {
                        nums[i] = 1;
                    }
                } else if (startOf2 != -1 && startOf2 < i) {
                    nums[startOf2++] = 0;
                    nums[i] = 2;
                }
            } else if (nums[i] == 1) {
                if (startOf1 == -1) {
                    startOf1 = i;
                }
                if (startOf2 != -1) {
                    if (startOf2 < startOf1) {
                        startOf1 = startOf2;
                    }
                    nums[startOf2++] = 1;
                    nums[i] = 2;
                }
            } else if (startOf2 == -1) {
                startOf2 = i;
            }
        }
    }
}