package com.kvvssut.interviews.dsalgo.problems;

import java.util.ArrayList;
import java.util.List;

class FindAnagrams {

    public static void main(String[] args) {
        System.out.println(new FindAnagrams().findAnagrams("abab", "ab"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        int sLen = s.length();
        int pLen = p.length();

        if (sLen >= pLen) {
            int[] charCnt = new int[26];
            int[] tmpCnt = new int[26];

            for (int i = 0; i < pLen; i++) {
                charCnt[p.charAt(i) - 'a']++;
                tmpCnt[s.charAt(i) - 'a']++;
            }

            if (checkAnagram(charCnt, tmpCnt)) {
                result.add(0);
            }

            for (int i = pLen; i < sLen; i++) {
                if (charCnt[s.charAt(i) - 'a'] == 0) {
                    unsetCount(tmpCnt);
                    for (int j = 0; j < pLen && i < sLen - 1; j++) {
                        tmpCnt[s.charAt(++i) - 'a']++;
                    }
                } else {
                    tmpCnt[s.charAt(i - pLen) - 'a']--;
                    tmpCnt[s.charAt(i) - 'a']++;
                }

                if (checkAnagram(charCnt, tmpCnt)) {
                    result.add(i - pLen + 1);
                }
            }
        }

        return result;
    }

    private boolean checkAnagram(int[] charCnt, int[] tmpCnt) {
        for (int i = 0; i < 26; i++) {
            if (charCnt[i] != tmpCnt[i]) {
                return false;
            }
        }

        return true;
    }

    private void unsetCount(int[] tmpCnt) {
        for (int i = 0; i < 26; i++) {
            tmpCnt[i] = 0;
        }
    }

}