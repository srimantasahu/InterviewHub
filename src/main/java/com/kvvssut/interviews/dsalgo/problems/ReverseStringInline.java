package com.kvvssut.interviews.dsalgo.problems;

class ReverseStringInline {

    public static void main(String[] args) {
        char[] arr = {'H', 'a', 'n', 'n', 'a', 'h'};
        new ReverseStringInline().reverseString(arr);
        System.out.println(arr);
    }

    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            char ch = s[l];
            s[l++] = s[r];
            s[r--] = ch;
        }
    }
}