package com.kvvssut.interviews.java.bits;

public class NumberOf1sBits {

    public static void main(String[] args) {
        count1sInBinaryRepresentaionOfANumber(35);
    }

    private static void count1sInBinaryRepresentaionOfANumber(int num) {
        System.out.println("Num in binary: " + Integer.toBinaryString(num));
        int count = 0;
        while (num > 0) {
            num = num & (num - 1);
            count++;
            System.out.println("Num: " + Integer.toBinaryString(num));
        }
        System.out.println("Number of 1s: " + count);
    }

}
