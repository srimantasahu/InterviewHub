package com.kvvssut.interviews.dsalgo.datastructure.tree;

public class TrieInsertSearchDeleteImpl {

	public static final int ALPHABET_SIZE = 26;

	public static void main(String[] args) {
		final String[] inputs = { "the", "a", "there", "answer", "any", "by", "bye", "their" };

		TrieNode root = new TrieNode();
		for (int i = 0; i < inputs.length; i++) {
			insertKey(root, inputs[i]);
		}

		System.out.println("Present in dictionary : " + searchKey(root, "answer"));
		System.out.println("Present in dictionary : " + searchKey(root, "an"));
		System.out.println("Present in dictionary : " + searchKey(root, "there"));
		System.out.println("Present in dictionary : " + searchKey(root, "theri"));
		System.out.println("Present in dictionary : " + searchKey(root, "their"));

		deleteKey(root, "the", 0, "the".length());
		deleteKey(root, "there", 0, "there".length());
		deleteKey(root, "theri", 0, "theri".length());

		System.out.println("\nPost delete :- \n");
		System.out.println("Present in dictionary : " + searchKey(root, "the"));
		System.out.println("Present in dictionary : " + searchKey(root, "there"));
		System.out.println("Present in dictionary : " + searchKey(root, "their"));
		System.out.println("Present in dictionary : " + searchKey(root, "theri"));

	}

	public static void insertKey(TrieNode root, final String key) {
		int level, length = key.length(), index;

		if (root != null) {
			for (level = 0; level < length; level++) {
				index = getIndexForChar(key.charAt(level));
				if (root.getTrieArray()[index] == null) {
					root.getTrieArray()[index] = new TrieNode();
				}
				root = root.getTrieArray()[index];
			}
		}

		root.setLeaf(true);
	}

	public static boolean searchKey(TrieNode root, final String key) {
		int level, length = key.length(), index;

		if (root != null) {
			for (level = 0; level < length; level++) {
				index = getIndexForChar(key.charAt(level));
				if (root.getTrieArray()[index] == null) {
					return false;
				}
				root = root.getTrieArray()[index];
			}
		}

		return root.isLeaf();
	}

	public static boolean deleteKey(TrieNode node, final String key, int level, int length) {
		if (node != null) {
			if (level == length) {
				if (node != null && isAFreeNode(node)) {
					return true;
				}
				return false;
			} else {
				int index = getIndexForChar(key.charAt(level));
				if (deleteKey(node.getTrieArray()[index], key, level + 1, length)) {
					node.setAtIndexOfTrieNode(index, null);
					return isAFreeNode(node);
				}
			}
		}

		return false;
	}

	public static boolean isAFreeNode(TrieNode node) {
		TrieNode trieArray[] = node.getTrieArray();
		for (int i = 0; i < trieArray.length; i++) {
			if (trieArray[i] != null) {
				return false;
			}
		}
		return true;
	}

	public static int getIndexForChar(char ch) {
		if (ch >= 95) {
			return ch - 97;
		} else {
			return ch - 65;
		}
	}

}

class TrieNode {
	private TrieNode trieArray[];
	private boolean isLeaf;

	public TrieNode() {
		this.trieArray = new TrieNode[TrieInsertSearchDeleteImpl.ALPHABET_SIZE];
		this.isLeaf = false;
	}

	public TrieNode[] getTrieArray() {
		return trieArray;
	}

	public void setAtIndexOfTrieNode(int index, TrieNode trieNode) {
		this.trieArray[index] = trieNode;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

}
