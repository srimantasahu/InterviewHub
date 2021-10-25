package com.kvvssut.interviews.dsalgo.datastructure.trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TrieSearchEngineImpl {

	public static final int ALPHABET_SIZE = 26;

	public static List<String> matchedStrings = null;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(
					"Please add words to dictionary (separated by comma) e.g., the,theme,there,answer,any,by,therasus,bye,their,therepy -");
			String readLine = reader.readLine();
			String inputs[] = readLine.split(",");

			TrieImplNode root = new TrieImplNode();
			for (String input : inputs) {
				insertKey(root, input.trim());
			}

			int next = 1;
			while (next == 1) {
				matchedStrings = new ArrayList<String>();

				System.out.println("Please search for a prefix of a word to get words suggestions - ");
				readLine = reader.readLine().trim();
				searchMaxLengthWord(root, readLine, "", 0);

				System.out.printf("All matched string for literal \"%s\" are -\n", readLine);
				for (String match : matchedStrings) {
					System.out.println(match);
				}

				System.out.println("To add more words to dictionary, enter '0' else '-1'- ");
				next = Integer.parseInt(reader.readLine().trim());
				if (next == 0) {
					System.out.println(
							"Please add words to dictionary (separated by comma) e.g., the,theme,there,answer,any,by,therasus,bye,their,therepy -");
					readLine = reader.readLine();
					inputs = readLine.split(",");

					for (String input : inputs) {
						insertKey(root, input.trim());
					}
					next = 1; // to call the flow again
				} else {
					System.out.println("To search again prefix of a word, enter '1' else '-1' to exit - ");
					next = Integer.parseInt(reader.readLine().trim());
				}
			}

		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}

	public static void insertKey(TrieImplNode root, final String key) {
		int level, length = key.length(), index;

		for (level = 0; level < length; level++) {
			index = getIndexForChar(key.charAt(level));
			if (root.getTrieArray()[index] == null) {
				root.getTrieArray()[index] = new TrieImplNode();
			}
			root = root.getTrieArray()[index];
		}
		root.setLeaf(true);
	}

	public static void searchMaxLengthWord(TrieImplNode node, String key, String word, int level) {

		if (level < key.length()) {
			char ch = key.charAt(level);
			int index = getIndexForChar(ch);
			searchMaxLengthWord(node.getTrieArray()[index], key, word + ch, level + 1);
		} else {
			if (node.isLeaf()) {
				matchedStrings.add(word);
			}
			String currentWord = word;
			int currentLevel = level;
			for (int i = 0; i < ALPHABET_SIZE; i++) {
				TrieImplNode now = null;
				if ((now = node.getTrieArray()[i]) != null) {
					searchMaxLengthWord(now, key, currentWord + getCharForIndex(i), currentLevel + 1);
				}
			}
		}
	}

	public static int getIndexForChar(char ch) {
		if (ch >= 95) {
			return ch - 97;
		}
		return 0;
	}

	public static char getCharForIndex(int i) {
		return (char) (97 + i);
	}

	static class TrieImplNode {
		private TrieImplNode trieArray[];
		private boolean isLeaf;

		public TrieImplNode() {
			this.trieArray = new TrieImplNode[TrieMaxLengthSearchEngine.ALPHABET_SIZE];
			this.isLeaf = false;
		}

		public TrieImplNode[] getTrieArray() {
			return trieArray;
		}

		public void setTrieImplNode(TrieImplNode[] trieArray) {
			this.trieArray = trieArray;
		}

		public boolean isLeaf() {
			return isLeaf;
		}

		public void setLeaf(boolean isLeaf) {
			this.isLeaf = isLeaf;
		}

	}

}
