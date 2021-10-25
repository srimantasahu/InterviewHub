package com.kvvssut.interviews.java.bits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SwapOfTwoNumbers {
	
	public static void main(String[] args) { 

		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));

			try {
				System.out.print("Enter first number: ");
				int input1 = Integer.parseInt(reader.readLine().trim());
				
				System.out.print("Enter second number: ");
				int input2 = Integer.parseInt(reader.readLine().trim());
				
				System.out.print(String.format("'%d','%d' swapping is ", input1, input2));
				
				swapNumbers(input1, input2);
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

	private static void swapNumbers(int input1, int input2) {
		input1 = input1 ^ input2;
		input2 = input1 ^ input2;
		input1 = input1 ^ input2;
		
		System.out.print(String.format("'%d','%d'", input1 , input2));
	}

}
