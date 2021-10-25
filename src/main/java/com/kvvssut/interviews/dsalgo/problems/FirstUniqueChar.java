package com.kvvssut.interviews.dsalgo.problems;

class FirstUniqueChar {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("z"));
    }

    public static int firstUniqChar(String s) {
        int idx = Integer.MAX_VALUE;

        for (int i = 'a'; i <= 'z'; i++) {
            int curIdx = s.indexOf(i);
            if (curIdx != -1 && s.lastIndexOf(i) == curIdx) {
                idx = Math.min(curIdx, idx);
            }
        }

        return idx == Integer.MAX_VALUE ? -1 : idx;
    }
}