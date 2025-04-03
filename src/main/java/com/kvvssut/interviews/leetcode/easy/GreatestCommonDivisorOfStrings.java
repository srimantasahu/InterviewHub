package com.kvvssut.interviews.leetcode.easy;

public class GreatestCommonDivisorOfStrings {

    public static void main(String[] args) {
        System.out.println(new GreatestCommonDivisorOfStrings().gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX"));
    }

    public String gcdOfStrings(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        if (str1.charAt(0) == str2.charAt(0) && str1.charAt(m - 1) == str2.charAt(n - 1)) {
            int j = gcd(m, n);

            String word = str1.substring(0, j);
            int i = j;
            while (i < m) {
                if (!str1.substring(i, i + j).equals(word)) {
                    return "";
                }
                i += j;
            }
            i = 0;
            while (i < n) {
                if (!str2.substring(i, i + j).equals(word)) {
                    return "";
                }
                i += j;
            }

            return word;
        }

        return "";
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}
