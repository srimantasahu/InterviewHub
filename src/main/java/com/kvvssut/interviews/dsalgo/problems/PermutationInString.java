package com.kvvssut.interviews.dsalgo.problems;

class PermutationInString {

    public static void main(String[] args) {
        System.out.println(new PermutationInString().checkInclusion("ab", "eidbaoo"));
    }

    public boolean checkInclusion(String p, String s) {
        int sLen = s.length();
        int pLen = p.length();

        if (sLen >= pLen) {
            int[] charCnt = new int[26];

            for (int i = 0; i < pLen; i++) {
                charCnt[p.charAt(i) - 'a']--;
                charCnt[s.charAt(i) - 'a']++;
            }
            if (checkAllUnset(charCnt)) {
                return true;
            }

            for (int i = pLen; i < sLen; i++) {
                charCnt[s.charAt(i - pLen) - 'a']--;
                charCnt[s.charAt(i) - 'a']++;
                if (checkAllUnset(charCnt)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean checkAllUnset(int[] charCnt) {
        for (int i = 0; i < 26; i++) {
            if (charCnt[i] != 0) {
                return false;
            }
        }

        return true;
    }
}