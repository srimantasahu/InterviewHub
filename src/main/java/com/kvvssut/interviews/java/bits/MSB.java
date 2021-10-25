package com.kvvssut.interviews.java.bits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MSB {

	public static void main(String[] args) { 

		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));

			try {
				System.out.print("Enter a number to get its MSB: ");
				int input = Integer.parseInt(reader.readLine().trim());

				System.out.print(String.format("'%d' MSB is '%d'.", input, getMSB(input)));
			} catch (NumberFormatException | IOException exception) {
				exception.printStackTrace();
			}

		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}
			}
		}
	}

	private static byte getMSB(int input) {

		int num = 1;
		byte counter = 0;
		
		do {
			counter++;
		} while ((num *= 2) < input);

		return counter;
	}

}
