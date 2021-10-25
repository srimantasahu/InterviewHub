package com.kvvssut.interviews.dsalgo.algorithm.recursionandbacktracking;

public class TowersOfHanoi {

	public static void main(String[] args) {
		towersOfHanoi(4, 'A', 'C', 'B');
	}
	
	public static void towersOfHanoi(int n, char from, char to, char aux) {
		if (n == 1) {
			System.out.println("Move disk 1 from [" + from + "] to [" + to + "]");
			return;
		}
		towersOfHanoi(n - 1, from, aux, to);
		System.out.println("Move disk " + n +" from [" + from + "] to [" + to + "]");
		towersOfHanoi(n - 1, aux, to, from);
	}

}
