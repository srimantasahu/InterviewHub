package com.kvvssut.interviews.dsalgo.problems;

import java.util.ArrayList;
import java.util.List;

class FrequencySort {

    public static void main(String[] args) {
        System.out.println(new FrequencySort().frequencySort("2a554442f544asfasssffffasss"));
    }

    public String frequencySort(String s) {
        if (s.length() > 2) {
            int[] chars = new int[128];
            int maxFreq = 0;

            for (char ch : s.toCharArray()) {
                chars[ch]++;
                if (chars[ch] > maxFreq) {
                    maxFreq = chars[ch];
                }
            }

            List<Character>[] freqList = new ArrayList[maxFreq + 1];

            for (int i = 0; i < 128; i++) {
                if (chars[i] > 0) {
                    List<Character> charList = freqList[chars[i]];
                    if (charList == null) {
                        charList = new ArrayList<>();
                        freqList[chars[i]] = charList;
                    }
                    charList.add((char) i);
                }
            }

            StringBuilder result = new StringBuilder();

            for (int i = maxFreq; i > 0; i--) {
                if (freqList[i] != null) {
                    for (char ch : freqList[i]) {
                        for (int j = 0; j < i; j++) {
                            result.append(ch);
                        }
                    }
                }
            }

            return result.toString();
        }

        return s;
    }
}