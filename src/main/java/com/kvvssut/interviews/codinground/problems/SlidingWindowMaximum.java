package com.kvvssut.interviews.codinground.problems;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

Example 1:
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

Example 2:
Input: nums = [1], k = 1
Output: [1]

Constraints:
1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length
 */
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        SlidingWindowMaximum obj = new SlidingWindowMaximum();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = obj.maxSlidingWindow(nums, k);
        System.out.println("Sliding window maximum: " + Arrays.toString(result));
    }

    /**
     * Sliding Window Maximum using the Block Partitioning method.
     * Time Complexity: O(n), Space Complexity: O(n)
     * Idea:
     * - Precompute "max from the left" and "max from the right" for blocks of size k.
     * - For each sliding window, the maximum is the larger of:
     * -> right[i]   (max in the block starting at i)
     * -> left[i+k-1] (max in the block ending at i+k-1)
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] left = new int[n];   // max from left to current index (within block of size k)
        int[] right = new int[n];  // max from right to current index (within block of size k)
        int[] ans = new int[n - k + 1];

        // Step 1: Build left[] (max seen so far from the left, reset every k elements)
        for (int i = 0; i < n; i++) {
            if (i % k == 0) {
                // Start of a new block
                left[i] = nums[i];
            } else {
                // Carry forward max within the block
                left[i] = Math.max(left[i - 1], nums[i]);
            }
        }

        // Step 2: Build right[] (max seen so far from the right, reset every k elements)
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1 || (i + 1) % k == 0) {
                // End of a block
                right[i] = nums[i];
            } else {
                // Carry forward max within the block
                right[i] = Math.max(right[i + 1], nums[i]);
            }
        }

        // Step 3: Compute sliding window maximum
        for (int i = 0; i <= n - k; i++) {
            // For window [i, i+k-1]:
            // - right[i] covers the left block
            // - left[i+k-1] covers the right block
            ans[i] = Math.max(right[i], left[i + k - 1]);
        }

        return ans;
    }

    // O(n log k) - because each insert/remove is log k
    public int[] maxSlidingWindowUsingPriorityQueue(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        // Max-heap: store indices, compare by nums value
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(nums[b], nums[a])
        );

        // Initialize first window
        for (int i = 0; i < k; i++) {
            pq.offer(i);
        }
        result[0] = nums[pq.peek()];

        // Process rest
        for (int i = k; i < n; i++) {
            pq.offer(i);

            // Remove indices out of window
            while (pq.peek() <= i - k) {
                pq.poll();
            }

            result[i - k + 1] = nums[pq.peek()];
        }

        return result;
    }
}
