package com.kvvssut.interviews.dsalgo.algorithm.dynamicprogramming;

public class RecursiveCountPossibleCoinsSum {

	public static void main(String[] args) {
		final int[] setOfCoins = { 1, 2, 5, 10 };
		final int coins = 4;
		final int sum = 10;

		final int possibleWays = countCoinsSum(setOfCoins, coins, sum);

		System.out.println("Total possible ways: " + possibleWays);
	}

	private static int countCoinsSum(int[] setOfCoins, int coins, int sum) {
		if (sum == 0) {
			return 1;
		}

		if (sum < 0) {
			return 0;
		}

		if (coins <= 0 && sum >= 1) {
			return 0;
		}

		return countCoinsSum(setOfCoins, coins - 1, sum)
				+ countCoinsSum(setOfCoins, coins, sum - setOfCoins[coins - 1]);
	}

}
