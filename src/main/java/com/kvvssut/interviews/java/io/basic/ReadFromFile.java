package com.kvvssut.interviews.java.io.basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFile {

	public static void main(String[] args) {
		System.out
				.print(getTextFromFile("D:\\Tech_Workspace\\Workspace_OldBooks\\JavaTuotrialWithJava8Examples\\src\\io\\basic\\Sample.txt"));
	}

	static String getTextFromFile(String filename) {
		StringBuilder text = new StringBuilder();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filename));
			String readLine;
			while ((readLine = reader.readLine()) != null) {
				text.append(readLine);
				text.append("\n");
			}
			text.deleteCharAt(text.length() - 1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}

		return text.toString();
	}

}
