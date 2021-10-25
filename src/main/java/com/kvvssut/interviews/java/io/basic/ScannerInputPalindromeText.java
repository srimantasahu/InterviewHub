package com.kvvssut.interviews.java.io.basic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ScannerInputPalindromeText {

	/*
	 * Complete the function below.
	 */

	static String is_Palindrome(String s) {

		char[] chars = s.toCharArray();
		Arrays.sort(chars);

		System.out.println(String.valueOf(chars));

		int oddCount = 0, lenCount = 1;
		int len = chars.length;

		for (int i = 0; i < len - 1;) {
			lenCount = 1;
			while (i < len - 1 && chars[i] == chars[++i]) {
				lenCount++;
			}
			if (lenCount % 2 != 0 || (i == len - 1 && chars[i - 1] != chars[i])) {
				oddCount++;
			}
			if (oddCount > 1) {
				System.out.println("NO");
				return "NO";
			}
		}

		System.out.println("YES");
		return "YES";
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		final String fileName = "D:\\Tech_Workspace\\Workspace_OldBooks\\JavaTuotrialWithJava8Examples\\src\\io\\basic\\Sample.txt";
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		String res;
		String _s;
		try {
			_s = in.nextLine();
		} catch (Exception e) {
			_s = null;
		} finally {
			in.close();
		}

		res = is_Palindrome(_s);
		bw.write(res);
		bw.newLine();

		bw.close();
	}
}
