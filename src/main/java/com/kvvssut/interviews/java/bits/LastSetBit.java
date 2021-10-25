package com.kvvssut.interviews.java.bits;

public class LastSetBit {

	public static void main(String[] args) {
		System.out.println(getLastSetBitInABinaryNumberAsBit(12)); // o/p - 3
		System.out.println(getLastSetBitInABinaryNumberAsInteger(12)); // o/p - 4
	}

	public static int getLastSetBitInABinaryNumberAsBit(int num) {
		int result = num & (-num);
		return getLog2OfNum(result);
	}

	public static int getLastSetBitInABinaryNumberAsInteger(int num) {
		return num & (-num);
	}

	public static int getLog2OfNum(int num) {
		int log2OfNum = 0;
		while (num > 0) {
			log2OfNum++;
			num /= 2;
		}
		return log2OfNum;
	}

}
