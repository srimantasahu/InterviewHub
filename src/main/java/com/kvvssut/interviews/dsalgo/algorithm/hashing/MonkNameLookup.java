package com.kvvssut.interviews.dsalgo.algorithm.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MonkNameLookup {

	private static final int HASH_FN_1 = 59, HASH_FN_2 = 95, MAX_BUCKET_SIZE = 128;

	private static int hashKeyTable[][][] = new int[HASH_FN_1][HASH_FN_2][MAX_BUCKET_SIZE];
	private static String hashValueTable[][][] = new String[HASH_FN_1][HASH_FN_2][MAX_BUCKET_SIZE];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int numberOfColleagues = Integer.parseInt(line);
		for (int i = 0; i < numberOfColleagues; i++) {
			line = br.readLine();
			String inputs[] = line.split(" ");
			store(Integer.parseInt(inputs[0]), inputs[1]);
		}

		line = br.readLine();
		int numberOfQueries = Integer.parseInt(line);
		for (int i = 0; i < numberOfQueries; i++) {
			line = br.readLine();
			System.out.println(retrieve(Integer.parseInt(line)));
		}
	}

	private static void store(int rollNo, String name) {
		int hash1 = getHash1(rollNo), hash2 = getHash2(rollNo);
		int hashKeyArray[] = hashKeyTable[hash1][hash2];
		int hashKeyArrayLength = hashKeyArray.length;
		if (hashKeyArray[hashKeyArrayLength - 1] != 0) {
			increaseBucketSize(hash1, hash2);
			hashKeyArrayLength += MAX_BUCKET_SIZE;
		}
		for (int i = 0; i < hashKeyArrayLength; i++) {
			if (hashKeyArray[i] == 0) {
				hashKeyArray[i] = rollNo;
				hashValueTable[hash1][hash2][i] = name;
				break;
			}
		}
	}

	private static String retrieve(int rollNo) {
		int hash1 = getHash1(rollNo), hash2 = getHash2(rollNo);
		int hashKeyArray[] = hashKeyTable[hash1][hash2];
		int hashKeyArrayLength = hashKeyArray.length;
		for (int i = 0; i < hashKeyArrayLength; i++) {
			if (hashKeyArray[i] == rollNo) {
				return hashValueTable[hash1][hash2][i];
			}
		}
		return null;
	}

	private static int getHash1(int rollNo) {
		return rollNo % HASH_FN_1;
	}

	private static int getHash2(int rollNo) {
		return rollNo % HASH_FN_2;
	}

	private static void increaseBucketSize(int hash1, int hash2) {
		int hashKeyArray[] = hashKeyTable[hash1][hash2];
		String hashValueArray[] = hashValueTable[hash1][hash2];
		int oldArrayLength = hashKeyArray.length;
		int tempHashKeyArray[] = new int[oldArrayLength + MAX_BUCKET_SIZE];
		String tempHashValueArray[] = new String[oldArrayLength + MAX_BUCKET_SIZE];

		for (int i = 0; i < oldArrayLength; i++) {
			tempHashKeyArray[i] = hashKeyArray[i];
			tempHashValueArray[i] = hashValueArray[i];
		}

		hashKeyTable[hash1][hash2] = tempHashKeyArray;
		hashValueTable[hash1][hash2] = tempHashValueArray;
	}

}
