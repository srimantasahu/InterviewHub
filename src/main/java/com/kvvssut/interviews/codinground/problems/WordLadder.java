package com.kvvssut.interviews.codinground.problems;

import java.util.*;

/*
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

Example 1:
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.

Example 2:
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.

Constraints:
1 <= beginWord.length <= 10
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.
 */
public class WordLadder {

    public static void main(String[] args) {
        WordLadder wl = new WordLadder();
        System.out.println(wl.ladderLength("hit", "cog",
                Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"))); // Output: 5
        System.out.println(wl.ladderLength("hit", "cog",
                Arrays.asList("hot", "dot", "dog", "lot", "log"))); // Output: 0
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Put all dictionary words into a HashSet for O(1) lookups
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0; // endWord must exist in dictionary

        // Queue for BFS, starting from beginWord
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        // Keep track of visited words to avoid revisiting
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int steps = 1; // start at 1 because beginWord itself counts

        // Standard BFS loop
        while (!queue.isEmpty()) {
            int size = queue.size(); // number of nodes at current BFS level

            // Process all words in current level
            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                // If we reached the target word → return length
                if (word.equals(endWord)) return steps;

                char[] chars = word.toCharArray();

                // Try changing each character of the word
                for (int j = 0; j < chars.length; j++) {
                    char original = chars[j];

                    // Replace with every possible lowercase letter
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue; // skip if same character

                        chars[j] = c;
                        String newWord = new String(chars);

                        // If new word is valid and not visited, add to queue
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            queue.offer(newWord);
                            visited.add(newWord);
                        }
                    }

                    // Restore the original character before next position
                    chars[j] = original;
                }
            }

            steps++; // finished one BFS layer → increment path length
        }

        return 0; // no path found
    }

}