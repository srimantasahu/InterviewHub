package com.kvvssut.interviews.dsalgo.datastructure.trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class TrieMaxLengthSearchEngine {

    public static final int ALPHABET_SIZE = 26;

    static int maxPriority = 0;

    private static HashMap<String, Integer> map = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            String readLine = reader.readLine();
            String inputs[] = readLine.split(" ");
            int noOfWords = Integer.parseInt(inputs[0]), noOfQueries = Integer.parseInt(inputs[1]);

            TrieImplNode root = new TrieImplNode();
            for (int i = 0; i < noOfWords; i++) {
                readLine = reader.readLine();
                inputs = readLine.split(" ");
                insertKey(root, inputs[0], Integer.parseInt(inputs[1]));
            }

            for (int i = 0; i < noOfQueries; i++) {
                readLine = reader.readLine();
                if (map.containsKey(readLine)) {
                    maxPriority = map.get(readLine);
                } else {
                    searchMaxPriorityWord(root, readLine, "", 0);
                    if (maxPriority == 0) {
                        maxPriority = -1;
                    }
                    map.put(readLine, maxPriority);
                }
                System.out.println(maxPriority);
                maxPriority = 0;
            }

        } finally {
            if (reader != null) {
                reader.close();
            }
        }

    }

    public static void insertKey(TrieImplNode root, final String key, final int priority) {
        int level, length = key.length(), index;

        for (level = 0; level < length; level++) {
            index = getIndexForChar(key.charAt(level));
            if (root.getTrieArray()[index] == null) {
                root.getTrieArray()[index] = new TrieImplNode();
            }
            root = root.getTrieArray()[index];
        }
        root.setPriority(priority);
    }

    public static void searchMaxPriorityWord(TrieImplNode node, String key, String word, int level) {

        if (level < key.length()) {
            char ch = key.charAt(level);
            int index = getIndexForChar(ch);
            node = node.getTrieArray()[index];
            if (node != null) {
                searchMaxPriorityWord(node, key, word + ch, level + 1);
            }
        } else {
            if (isLastLeafNode(node)) {
                if (node.getPriority() > maxPriority) {
                    maxPriority = node.getPriority();
                }
            } else {
                String currentWord = word;
                int currentLevel = level;
                for (int i = 0; i < ALPHABET_SIZE; i++) {
                    TrieImplNode now = null;
                    if ((now = node.getTrieArray()[i]) != null) {
                        searchMaxPriorityWord(now, key, currentWord + getCharForIndex(i), currentLevel + 1);
                    }
                }
            }
        }

    }

    public static boolean isLastLeafNode(TrieImplNode node) {
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (node.getTrieArray()[i] != null) {
                return false;
            }
        }
        return true;
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
        private int priority;

        public TrieImplNode() {
            this.trieArray = new TrieImplNode[TrieMaxLengthSearchEngine.ALPHABET_SIZE];
            this.priority = 0;
        }

        public TrieImplNode[] getTrieArray() {
            return trieArray;
        }

        public void setTrieImplNode(TrieImplNode[] trieArray) {
            this.trieArray = trieArray;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

    }

}
