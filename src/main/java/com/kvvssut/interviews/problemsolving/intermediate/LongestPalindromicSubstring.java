package com.kvvssut.interviews.problemsolving.intermediate;

/**
 * Given a string s, return the longest palindromic substring in s.
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("babad"));
    }

    public String longestPalindrome(String str) {
        String lps = "";

        for (int i = 0; i < str.length(); i++) {
            String cur = String.valueOf(str.charAt(i));

            for (int j = 1; i - j >= 0 && i + j < str.length(); j++) {
                if (str.charAt(i - j) == str.charAt(i + j)) {
                    cur = str.charAt(i - j) + cur + str.charAt(i + j);
                } else {
                    break;
                }
            }

            if (cur.length() > lps.length()) {
                lps = cur;
            }

            if (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                cur = String.valueOf(str.charAt(i)) + str.charAt(i + 1);

                for (int j = 1; i - j >= 0 && i + 1 + j < str.length(); j++) {
                    if (str.charAt(i - j) == str.charAt(i + 1 + j)) {
                        cur = str.charAt(i - j) + cur + str.charAt(i + 1 + j);
                    } else {
                        break;
                    }
                }

                if (cur.length() > lps.length()) {
                    lps = cur;
                }
            }
        }

        return lps;
    }

}
