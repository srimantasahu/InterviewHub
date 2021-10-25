package com.kvvssut.interviews.java.io.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class CustomCapitalizationReader extends BufferedReader {

	public CustomCapitalizationReader(Reader in) {
		super(in);
	}

	@Override
	public String readLine() throws IOException {
		String readText = super.readLine();
		if (readText != null) {
			return readText.toUpperCase();
		}
		return readText;
	}

}
