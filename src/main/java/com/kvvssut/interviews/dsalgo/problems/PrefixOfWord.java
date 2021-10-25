package com.kvvssut.interviews.dsalgo.problems;

public class PrefixOfWord {

    public static void main(String[] args) {
        System.out.println(new PrefixOfWord().isPrefixOfWord("I love mac burger", "burg"));
    }

    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] literals = sentence.split(" ");
        for (int i = 0; i < literals.length; i++) {
            if (literals[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }
}
