package com.kvvssut.interviews.java.io.advanced;

import java.io.FileReader;
import java.io.IOException;

public class ReadFromFileUsingCustomCapitalizationReader {

	public static void main(String[] args) {
		System.out
				.print(getTextFromFile("D:\\Tech_Workspace\\Workspace_OldBooks\\JavaTuotrialWithJava8Examples\\src\\io\\basic\\Sample.txt"));
	}

	static String getTextFromFile(String filename) {
		StringBuilder text = new StringBuilder();
		CustomCapitalizationReader reader = null;
		try {
			reader = new CustomCapitalizationReader(new FileReader(filename));
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
