package com.kvvssut.interviews.dsalgo.algorithm.recursionandbacktracking;

public class ZeroTokNLenStrings {

	public static void main(String[] args) {
		int n = 3;
		int k = 10;
		char[] charArr = new char[n];
		
		zeroTokNLenStrings(n, k, charArr);
	}
	
	public static void zeroTokNLenStrings(int n, int k, char[] charArr) {
		if (n < 1) {
			System.out.println("String is " + new String(charArr));
			return;
		} else {
			for (int i = 0; i < k; i++) {
				charArr[n -1] = (char) (48 + i);
				zeroTokNLenStrings(n - 1, k, charArr);
			}
		}
	}

}
