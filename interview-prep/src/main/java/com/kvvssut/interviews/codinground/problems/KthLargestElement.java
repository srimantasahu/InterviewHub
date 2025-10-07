package com.kvvssut.interviews.codinground.problems;

import java.util.PriorityQueue;

/*
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?

Example 1:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

Constraints:
1 <= k <= nums.length <= 105
-104 <= nums[i] <= 104
 */
public class KthLargestElement {

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};

        System.out.println(findKthLargest(nums1, 2)); // 5
        System.out.println(findKthLargest(nums2, 4)); // 4
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // remove smallest
            }
        }

        return minHeap.peek();
    }

    public int findKthLargestUsingCountingSort(int[] nums, int k) {
        int[] count = new int[20001]; // covers range [-10000, 10000]

        // Step 1: Count occurrences of each number
        for (int num : nums)
            count[num + 10000]++;   // shift by 10000 so index never goes negative

        // Step 2: Traverse from largest to smallest
        for (int i = count.length - 1; i >= 0; i--)
            if (count[i] > 0) {
                k -= count[i];      // reduce k by frequency of this number
                if (k <= 0)
                    return i - 10000; // convert index back to original number
            }

        return -1; // fallback (shouldn’t happen due to constraints)
    }

}
