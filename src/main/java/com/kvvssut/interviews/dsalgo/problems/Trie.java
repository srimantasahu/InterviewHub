package com.kvvssut.interviews.dsalgo.problems;

class Trie {

    public static final int ALPHABET_SIZE = 26;

    private TrieNode parent;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        parent = new TrieNode();
    }

    public static void insertKey(TrieNode root, final String key) {
        int level, length = key.length(), index;

        for (level = 0; level < length; level++) {
            index = getIndexForChar(key.charAt(level));
            if (root.getTrieArray()[index] == null) {
                root.getTrieArray()[index] = new TrieNode();
            }
            root = root.getTrieArray()[index];
        }

        root.setLeaf(true);
    }

    public static boolean searchKey(TrieNode root, final String key) {
        int level, length = key.length(), index;

        for (level = 0; level < length; level++) {
            index = getIndexForChar(key.charAt(level));
            if (root.getTrieArray()[index] == null) {
                return false;
            }
            root = root.getTrieArray()[index];
        }

        return root.isLeaf();
    }

    public static boolean prefixKey(TrieNode root, final String key) {
        int level, length = key.length(), index;

        for (level = 0; level < length; level++) {
            index = getIndexForChar(key.charAt(level));
            if (root.getTrieArray()[index] == null) {
                return false;
            }
            root = root.getTrieArray()[index];
        }

        return true;
    }

    public static int getIndexForChar(char ch) {
        return ch - 'a';
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        insertKey(parent, word);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return searchKey(parent, word);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return prefixKey(parent, prefix);
    }

}

class TrieNode {
    private TrieNode trieArray[];
    private boolean isLeaf;

    public TrieNode() {
        this.trieArray = new TrieNode[Trie.ALPHABET_SIZE];
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

/**
 * Your com.kvvssut.Trie object will be instantiated and called as such:
 * com.kvvssut.Trie obj = new com.kvvssut.Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */