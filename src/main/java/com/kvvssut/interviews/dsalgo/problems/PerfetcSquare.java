package com.kvvssut.interviews.dsalgo.problems;

class PerfetcSquare {

    public static void main(String[] args) {
        System.out.println(new PerfetcSquare().isPerfectSquare(2147483647));
    }

    public boolean isPerfectSquare(int num) {
        long l = 1;
        long r = num;
        while (l <= r) {
            long mid = l - (l - r) / 2;

            if (mid * mid == num) {
                return true;
            } else if (mid * mid > num) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return false;
    }

}