package com.kvvssut.interviews.dsalgo.problems;

public class FirstBadVersion {

    public static void main(String[] args) {
        System.out.println(new FirstBadVersion().firstBadVersion(5));
    }

    public int firstBadVersion(int n) {
        //return getBadVersionIndexRecursion(1, 2126753390, 2126753390);

        int low = 1;
        int high = n;
        int min = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isBadVersion(mid)) {
                min = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        return min;
    }


    
    private int getBadVersionIndexRecursion(int low, int high, int min) {
        if (low == min) {
            return min;
        }

        int mid = low + (high - low) / 2;

        if (isBadVersion(mid)) {
            return getBadVersionIndexRecursion(low, mid - 1, mid);
        } else {
            return getBadVersionIndexRecursion(mid + 1, high, min);
        }
    }

    private boolean isBadVersion(int x) {
        return x >= 4;
    }
}