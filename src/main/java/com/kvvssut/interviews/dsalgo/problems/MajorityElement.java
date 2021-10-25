package com.kvvssut.interviews.dsalgo.problems;

class MajorityElement {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[] {2,2,1,1,1,1,1,2,2}));
    }

    public static int majorityElement(int[] nums) {
       int maj_idx = 0;
       int count = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[maj_idx] == nums[i]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                maj_idx = i;
                count = 1;
            }
        }

        return nums[maj_idx];
    }
}