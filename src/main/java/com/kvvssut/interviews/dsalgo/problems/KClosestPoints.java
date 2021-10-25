package com.kvvssut.interviews.dsalgo.problems;

import java.util.PriorityQueue;
import java.util.stream.Stream;

class KClosestPoints {

    public static void main(String[] args) {
        int[][] result = new KClosestPoints().kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2);
        Stream.of(result).forEach(arr -> System.out.println(arr[0] + ", " + arr[1]));
    }

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> Integer.compare(a2[0] * a2[0] + a2[1] * a2[1], a1[0] * a1[0] + a1[1] * a1[1]));

        for (int i = 0; i < K; i++) {
            pq.add(points[i]);
        }

        for (int i = K; i < points.length; i++) {
            int[] curr = points[i];
            int[] top = pq.peek();

            if (curr[0] * curr[0] + curr[1] * curr[1] < top[0] * top[0] + top[1] * top[1]) {
                pq.remove();
                pq.add(curr);
            }
        }

        return pq.toArray(new int[0][]);
    }
}