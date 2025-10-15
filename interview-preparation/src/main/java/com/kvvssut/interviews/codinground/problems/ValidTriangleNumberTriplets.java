package com.kvvssut.interviews.codinground.problems;

import java.util.Arrays;

public class ValidTriangleNumberTriplets {

    public static void main(String[] args) {
        ValidTriangleNumberTriplets solver = new ValidTriangleNumberTriplets();

        int[] nums1 = {2, 2, 3, 4};
        System.out.println(solver.triangleNumber(nums1));
        // Output: 3
        // Valid combinations: (2,3,4), (2,3,4), (2,2,3)

        int[] nums2 = {4, 2, 3, 4};
        System.out.println(solver.triangleNumber(nums2));
        // Output: 4
        // Valid combinations: (2,3,4), (2,4,4), (3,4,4), (2,3,4 with the other 4)
    }

    public int triangleNumber(int[] nums) {
        // Step 1: Sort the array so we can use the triangle property easily
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;

        // Step 2: Fix the largest side (nums[k]) starting from the end
        for (int k = n - 1; k >= 2; k--) {
            int i = 0;          // smallest side pointer
            int j = k - 1;      // middle side pointer

            // Step 3: Use two-pointer approach to check pairs (nums[i], nums[j])
            while (i < j) {
                // If nums[i] + nums[j] > nums[k], we found valid triangles
                if (nums[i] + nums[j] > nums[k]) {
                    // All elements between nums[i] and nums[j-1] with nums[j]
                    // also form valid triangles with nums[k], because the array is sorted.
                    count += j - i;

                    // Move 'j' left to check the next smaller middle side
                    j--;
                } else {
                    // If nums[i] + nums[j] <= nums[k], increase 'i'
                    // to try a larger smallest side
                    i++;
                }
            }
        }
        return count;
    }
}
