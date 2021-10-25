package com.kvvssut.interviews.dsalgo.problems;

public class MaxVowels {

    public static void main(String[] args) {
        System.out.println(new MaxVowels().maxVowels("leetcode", 3));
    }

    public int maxVowels(String s, int k) {
        int max = 0;
        int i = 0;
        char ch;
        for (; i < k; i++) {
            ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                max++;
            }
        }

        int temp = max;
        char ch2;
        for (i = k; i < s.length(); i++) {
            ch = s.charAt(i);
            ch2 = s.charAt(i - k);
            if (ch != ch2) {
                if (ch2 == 'a' || ch2 == 'e' || ch2 == 'i' || ch2 == 'o' || ch2 == 'u') {
                    temp--;
                }
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    temp++;
                    if (temp > max) {
                        max = temp;
                    }
                }
            }
        }

        return max;
    }
}
