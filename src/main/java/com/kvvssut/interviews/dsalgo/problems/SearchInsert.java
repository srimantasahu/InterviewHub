package com.kvvssut.interviews.dsalgo.problems;

class SearchInsert {

    public static void main(String[] args) {
        System.out.println(new SearchInsert().searchInsert(new int[]{1, 3, 5, 6}, 5));
    }

    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return high;
    }
}