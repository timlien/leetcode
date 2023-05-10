package com.tingshulien.leetcode.dynamicprogramming.twodimension;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/longest-common-subsequence/">1143. Longest Common Subsequence</a>
 * <p>
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
 * <p>
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted
 * without changing the relative order of the remaining characters.
 * <p>
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 */
public class LongestCommonSubsequence_1143 {

    private Map<String, Integer> countByIndexes = new HashMap<>();

    public int longestCommonSubsequence(String text1, String text2) {
        return dp(0, 0, text1, text2);
    }

    private int dp(int i, int j, String text1, String text2) {
        String index = index(i, j);
        if (countByIndexes.containsKey(index)) {
            return countByIndexes.get(index);
        }

        if (i >= text1.length() || j >= text2.length()) {
            return 0;
        }

        if (text1.charAt(i) == text2.charAt(j)) {
            countByIndexes.put(index, 1 + dp(i + 1, j + 1, text1, text2));
        } else {
            countByIndexes.put(index, Math.max(dp(i + 1, j, text1, text2), dp(i, j + 1, text1, text2)));
        }

        return countByIndexes.get(index);
    }

    private String index(int i, int j) {
        return i + "_" + j;
    }

}
