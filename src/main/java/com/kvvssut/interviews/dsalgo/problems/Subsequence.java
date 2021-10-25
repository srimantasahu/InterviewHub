package com.kvvssut.interviews.dsalgo.problems;

class Subsequence {

    public static void main(String[] args) {
        System.out.println(new Subsequence().isSubsequence("abc", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char ch : s.toCharArray()) {
            index = t.indexOf(ch, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }
}