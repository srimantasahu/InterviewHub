package com.kvvssut.interviews.dsalgo.problems;

import java.util.HashSet;
import java.util.Set;

class NumJewelsInStones {

    public static void main(String[] args) {
        System.out.println(new NumJewelsInStones().numJewelsInStones("aA", "aAAbbbb"));
    }

    public int numJewelsInStones(String J, String S) {

        int jLen = J.length();
        int sLen = S.length();

        if (jLen == 0 || sLen == 0) {
            return 0;
        }

        Set<Character> jewels = new HashSet<>();

        for (int j = 0; j < jLen; j++) {
            jewels.add(J.charAt(j));
        }

        int count = 0;

        for (int s = 0; s < sLen; s++) {
            if (jewels.contains(S.charAt(s))) {
                count++;
            }
        }

        return count;
    }

}