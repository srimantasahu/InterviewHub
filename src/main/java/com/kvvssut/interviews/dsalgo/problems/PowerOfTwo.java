package com.kvvssut.interviews.dsalgo.problems;

class PowerOfTwo {

    public static void main(String[] args) {
        System.out.println(new PowerOfTwo().isPowerOfTwo(32));
    }

    public boolean isPowerOfTwo(int n) {
        if (n > 0) {
            return (n & -n) == n;
        }
        return false;
    }
}