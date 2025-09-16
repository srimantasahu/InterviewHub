package com.kvvssut.interviews.codinground.problems;

import java.util.LinkedList;
import java.util.Queue;

/*
Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach any index with value 0.

Notice that you can not jump outside of the array at any time.

Example 1:
Input: arr = [4,2,3,0,3,1,2], start = 5
Output: true
Explanation:
All possible ways to reach at index 3 with value 0 are:
index 5 -> index 4 -> index 1 -> index 3
index 5 -> index 6 -> index 4 -> index 1 -> index 3

Example 2:
Input: arr = [4,2,3,0,3,1,2], start = 0
Output: true
Explanation:
One possible way to reach at index 3 with value 0 is:
index 0 -> index 4 -> index 1 -> index 3

Example 3:
Input: arr = [3,0,2,1,2], start = 2
Output: false
Explanation: There is no way to reach at index 1 with value 0.

Constraints:
1 <= arr.length <= 5 * 104
0 <= arr[i] < arr.length
0 <= start < arr.length
 */
public class JumpGame {
    // Test the solution
    public static void main(String[] args) {
        JumpGame obj = new JumpGame();
        System.out.println(obj.canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 5)); // true
        System.out.println(obj.canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 0)); // true
        System.out.println(obj.canReach(new int[]{3, 0, 2, 1, 2}, 2));     // false
    }

    public boolean canReach(int[] arr, int start) {
        // Base case: If index is out of bounds OR already visited (marked as negative), return false
        if (start < 0 || start >= arr.length || arr[start] < 0) return false;

        // If we land on a cell with value 0, success: we can reach the target
        if (arr[start] == 0) return true;

        // Save current jump length, since we’ll overwrite this cell
        int jump = arr[start];

        // Mark the current index as visited by negating the value
        // This prevents infinite recursion / cycles
        arr[start] = -1;

        // Recurse in both possible directions:
        // 1. Move forward (start + jump)
        // 2. Move backward (start - jump)
        return canReach(arr, start + jump) || canReach(arr, start - jump);
    }

    public boolean canReachIterative(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];  // tracks visited indices to avoid cycles
        Queue<Integer> queue = new LinkedList<>(); // BFS queue

        // start BFS from the given index
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int idx = queue.poll();

            // Found a zero, return true
            if (arr[idx] == 0) return true;

            // Possible next positions
            int forward = idx + arr[idx];
            int backward = idx - arr[idx];

            // Check forward move (must be inside array and not visited yet)
            if (forward < n && !visited[forward]) {
                visited[forward] = true;   // mark visited
                queue.offer(forward);      // enqueue for BFS
            }

            // Check backward move (must be inside array and not visited yet)
            if (backward >= 0 && !visited[backward]) {
                visited[backward] = true;  // mark visited
                queue.offer(backward);     // enqueue for BFS
            }
        }

        // If BFS finishes without finding 0, return false
        return false;
    }

}
