package com.kvvssut.interviews.leetcode.medium;

import java.util.Arrays;

/*
You are given an integer array banned and two integers n and maxSum. You are choosing some number of integers following the below rules:

The chosen integers have to be in the range [1, n].
Each integer can be chosen at most once.
The chosen integers should not be in the array banned.
The sum of the chosen integers should not exceed maxSum.
Return the maximum number of integers you can choose following the mentioned rules.

Example 1:
Input: banned = [1,6,5], n = 5, maxSum = 6
Output: 2
Explanation: You can choose the integers 2 and 4.
2 and 4 are from the range [1, 5], both did not appear in banned, and their sum is 6, which did not exceed maxSum.
Example 2:
Input: banned = [1,2,3,4,5,6,7], n = 8, maxSum = 1
Output: 0
Explanation: You cannot choose any integer while following the mentioned conditions.
Example 3:
Input: banned = [11], n = 7, maxSum = 50
Output: 7
Explanation: You can choose the integers 1, 2, 3, 4, 5, 6, and 7.
They are from the range [1, 7], all did not appear in banned, and their sum is 28, which did not exceed maxSum.

Constraints:
1 <= banned.length <= 104
1 <= banned[i], n <= 104
1 <= maxSum <= 109
 */
public class MaxNumberOfIntsFromRange {

    public static void main(String[] args) {
        int[] banned = {87, 193, 85, 55, 14, 69, 26, 133, 171, 180, 4, 8, 29, 121, 182, 78, 157, 53, 26, 7, 117, 138, 57, 167, 8, 103, 32, 110, 15, 190, 139, 16, 49, 138, 68, 69, 92, 89, 140, 149, 107, 104, 2, 135, 193, 87, 21, 194, 192, 9, 161, 188, 73, 84, 83, 31, 86, 33, 138, 63, 127, 73, 114, 32, 66, 64, 19, 175, 108, 80, 176, 52, 124, 94, 33, 55, 130, 147, 39, 76, 22, 112, 113, 136, 100, 134, 155, 40, 170, 144, 37, 43, 151, 137, 82, 127, 73};
        int n = 1079, maxSum = 87;
        System.out.println(new MaxNumberOfIntsFromRange().maxCount(banned, n, maxSum));
    }

    public int maxCount(int[] banned, int n, int maxSum) {
        int cnt = 0;
        int sum = 0;
        Arrays.sort(banned);

        for (int i = 1, j = 0; i <= n; i++) {
            if (j < banned.length && banned[j] == i) {
                do {
                    j++;
                } while (j < banned.length && banned[j] == i);
                continue;
            }
            if (sum + i <= maxSum) {
                sum += i;
                cnt++;
            } else {
                break;
            }
        }

        return cnt;
    }

}
