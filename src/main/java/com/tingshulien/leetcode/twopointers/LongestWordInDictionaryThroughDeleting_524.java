package com.tingshulien.leetcode.twopointers;

import java.util.List;

/**
 * <a href="https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/">524. Longest Word in Dictionary through Deleting</a>
 *
 * Given a string s and a string array dictionary,
 * return the longest string in the dictionary that can be formed by deleting some of the given string characters.
 * If there is more than one possible result, return the longest word with the smallest lexicographical order.
 * If there is no possible result, return the empty string.
 */
public class LongestWordInDictionaryThroughDeleting_524 {

    public String findLongestWord(String s, List<String> dictionary) {
        String maxString = "";
        for (String vocabulary : dictionary) {
            if (isSequential(s, vocabulary)) {
                if (vocabulary.length() < maxString.length()) {
                    continue;
                }

                if (vocabulary.length() == maxString.length() && vocabulary.compareTo(maxString) >= 0) {
                    continue;
                }

                maxString = vocabulary;
            }
        }

        return maxString;
    }

    private boolean isSequential(String s, String vocabulary) {
        if (s.length() < vocabulary.length()) {
            return false;
        }

        int i = 0;
        int j = 0;
        while (i < s.length()) {
            if (s.charAt(i) == vocabulary.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }

            if (j == vocabulary.length()) {
                return true;
            }
        }

        return false;
    }

}
