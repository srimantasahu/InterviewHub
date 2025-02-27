package com.kvvssut.interviews.leetcode.hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class SlidingWindowMaximum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SlidingWindowMaximum().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] ans = new int[n - k + 1];

        for (int i = 0; i < n; i++) {
            if (i % k == 0)
                left[i] = nums[i];
            else
                left[i] = Math.max(left[i - 1], nums[i]);
        }

        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1 || (i + 1) % k == 0)
                right[i] = nums[i];
            else
                right[i] = Math.max(right[i + 1], nums[i]);
        }

        for (int i = 0; i <= n - k; i++) {
            ans[i] = Math.max(right[i], left[i + k - 1]);
        }

        return ans;
    }

    public int[] maxSlidingWindowUsingPriorityQueue(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        PriorityQueue<Entry> pq = new PriorityQueue<>(Comparator.comparing(Entry::val).thenComparing(Entry::idx).reversed());

        for (int i = 0; i < k; i++) {
            pq.offer(new Entry(nums[i], i));
        }
        res[0] = pq.peek().val;

        for (int i = k; i < n; i++) {
            pq.offer(new Entry(nums[i], i));
            while (pq.peek().idx <= i - k) {
                pq.poll();
            }
            res[i - k + 1] = pq.peek().val;
        }

        return res;
    }

    private record Entry(int val, int idx) {
    }
}