package com.kvvssut.interviews.dsalgo.algorithm.recursionandbacktracking;

public class BinaryNBitStrings {

    public static void main(String[] args) {
        int n = 5;
        char[] charArr = new char[n];

        binaryNBitStrings(n, charArr);
    }

    public static void binaryNBitStrings(int n, char[] charArr) {
        if (n < 1) {
            System.out.println("String is " + new String(charArr));
            return;
        } else {
            charArr[n - 1] = 48;
            binaryNBitStrings(n - 1, charArr);
            charArr[n - 1] = 49;
            binaryNBitStrings(n - 1, charArr);
        }
    }

}
