package com.kvvssut.interviews.java.bits;

public class CountSetBits {

	public static void main(String[] args) {
		int num = 53;
		System.out.println(String.format("Num - %d \nBinary: %s", num, Integer.toBinaryString(35)));
		System.out.println("Number of 1s: " + count1sInBinaryRepresentaionOfANumber(35));
	}

	public static int count1sInBinaryRepresentaionOfANumber(int num) {
		int count = 0;
		while (num > 0) {
			num = num & (num - 1);
			count++;
		}
		return count;
	}

}
