package com.kvvssut.interviews.leetcode.hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class SlidingWindowMaximum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SlidingWindowMaximum().maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        PriorityQueue<Record> pq = new PriorityQueue<>(Comparator.comparing(Record::getVal).thenComparing(Record::getIdx).reversed());

        for (int i = 0; i < k; i++) {
            pq.offer(new Record(nums[i], i));
        }
        res[0] = pq.peek().getVal();

        for (int i = k; i < n; i++) {
            pq.offer(new Record(nums[i], i));
            while (pq.peek().getIdx() <= i - k) {
                pq.poll();
            }
            res[i - k + 1] = pq.peek().getVal();
        }

        return res;
    }

    private static class Record {
        int val;
        int idx;

        public Record(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        public int getVal() {
            return val;
        }

        public int getIdx() {
            return idx;
        }
    }
}