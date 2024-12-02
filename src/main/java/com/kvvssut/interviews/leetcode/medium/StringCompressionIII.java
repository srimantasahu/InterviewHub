package com.kvvssut.interviews.leetcode.medium;

public class StringCompressionIII {

    /*
      Given a string word, compress it using the following algorithm:

      Begin with an empty string comp. While word is not empty, use the following operation:
      Remove a maximum length prefix of word made of a single character c repeating at most 9 times.
      Append the length of the prefix followed by c to comp.
      Return the string comp.

      Example 2:
      Input: word = "aaaaaaaaaaaaaabb"
      Output: "9a5a2b"

      Explanation:
      Initially, comp = "". Apply the operation 3 times, choosing "aaaaaaaaa", "aaaaa", and "bb" as the prefix in each operation.

      For prefix "aaaaaaaaa", append "9" followed by "a" to comp.
      For prefix "aaaaa", append "5" followed by "a" to comp.
      For prefix "bb", append "2" followed by "b" to comp.
     */

    public static void main(String[] args) {
        System.out.println(new StringCompressionIII().compressedString("aaaaaaaaabba"));
    }

    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();

        char cur = word.charAt(0);
        int cnt = 1;
        int repLimit = 9;

        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) != cur) {
                if (cnt > 0) {
                    comp.append(cnt).append(cur);
                }
                cur = word.charAt(i);
                cnt = 1;
            } else {
                cnt++;
                if (cnt == repLimit) {
                    comp.append(cnt).append(cur);
                    cnt = 0;
                }
            }
        }

        if (cnt > 0) {
            comp.append(cnt).append(cur);
        }

        return comp.toString();
    }

}
