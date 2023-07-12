package com.kvvssut.interviews.problemsolving.intermediate;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("loddktdji"));
    }

    public int lengthOfLongestSubstring(String input) {
        if (input.length() == 0) {
            return 0;
        } else if (input.length() == 1) {
            return 1;
        } else {
            int[] index = new int[128];
            for (int i = 0; i < 128; i++) {
                index[i] = -1;
            }

            int ch = input.charAt(0);
            index[ch] = 0;

            int startIdx = 0;

            int longestSubLen = 1;
            int currentSubLen = 1;

            for (int i = 1; i < input.length(); i++) {

                ch = input.charAt(i);

                if (index[ch] >= startIdx) {
                    if (currentSubLen > longestSubLen) {
                        longestSubLen = currentSubLen;
                    }
                    currentSubLen = currentSubLen - (index[ch] - startIdx);
                    startIdx = index[ch] + 1;
                } else {
                    currentSubLen = currentSubLen + 1;
                }

                index[ch] = i;
            }

            return Math.max(currentSubLen, longestSubLen);
        }
    }

}
