package com.tingshulien.leetcode.graph.implicit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/word-ladder/description/">127. Word Ladder</a>
 * <p>
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 * <p>
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 */
public class WordLadder_127 {

    private Set<String> seen;

    private Set<String> dictionary;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        this.seen = new HashSet<>();
        this.dictionary = new HashSet<>(wordList);

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        seen.add(beginWord);

        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;

            for (int i = 0; i < size; i++) {
                String word = queue.remove();
                if (word.equals(endWord)) {
                    return step;
                }

                for (String nextWord : transform(word)) {
                    if (seen.contains(nextWord)) {
                        continue;
                    }

                    queue.add(nextWord);
                    seen.add(nextWord);
                }
            }
        }

        return 0;
    }

    public List<String> transform(String word) {
        List<String> result = new ArrayList<>();
        int length = word.length();

        for (int i = 0; i < length; i++) {
            for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
                if (word.charAt(i) == alphabet) {
                    continue;
                }

                String nextWord = word.substring(0, i) + alphabet + word.substring(i + 1, length);
                if (!dictionary.contains(nextWord)) {
                    continue;
                }

                result.add(nextWord);
            }
        }

        return result;
    }

}
