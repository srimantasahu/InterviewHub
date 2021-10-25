package com.kvvssut.interviews.dsalgo.problems;

class SingleNonDuplicate {

    public static void main(String[] args) {
        System.out.println(new SingleNonDuplicate().singleNonDuplicate(new int[]{0,1,1,2,2,3,3,4,4}));
    }

    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid - 1] != nums[mid] && nums[mid + 1] != nums[mid]) {
                return nums[mid];
            } else if (mid % 2 == 0) {
                if (nums[mid] == nums[mid + 1]) {
                    low = mid + 2;
                } else {
                    high = mid - 2;
                }
            } else {
                if (nums[mid] == nums[mid - 1]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return nums[low];
    }

    public int singleNonDuplicateRec(int[] nums) {
        return singleNonDuplicateRec(nums, 0, nums.length);
    }

    public int singleNonDuplicateRec(int[] nums, int l, int r) {
        int mid = l + (r - l) / 2;

        if (r == 0) {
            return nums[0];
        } else if (l == nums.length - 1) {
            return nums[nums.length - 1];
        } else if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
            return nums[mid];
        } else if (mid % 2 == 0) {
            if (nums[mid] == nums[mid + 1]) {
                return singleNonDuplicateRec(nums, mid + 2, r);
            } else {
                return singleNonDuplicateRec(nums, l, mid - 2);
            }
        } else {
            if (nums[mid] == nums[mid - 1]) {
                return singleNonDuplicateRec(nums, mid + 1, r);
            } else {
                return singleNonDuplicateRec(nums, l, mid - 1);
            }
        }
    }
}