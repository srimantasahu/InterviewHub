package com.kvvssut.interviews.dsalgo.problems;

class RansomNote {

    public static void main(String[] args) {
        System.out.println(new RansomNote().canConstruct("fihjjjjei", "hjibagacbhadfaefdjaeaebgi"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.isEmpty()) {
            return true;
        } else if (ransomNote.length() > magazine.length()) {
            return false;
        } else {
            int[] indexes = new int[26];
            for (char ch : ransomNote.toCharArray()) {
                int index = magazine.indexOf(ch, indexes[ch - 'a']);
                if (index == -1) {
                    return false;
                }
                indexes[ch - 'a'] = index + 1;
            }

            return true;
        }
    }

}