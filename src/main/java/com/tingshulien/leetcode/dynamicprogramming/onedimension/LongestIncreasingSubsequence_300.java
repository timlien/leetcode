package com.tingshulien.leetcode.dynamicprogramming.onedimension;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/longest-increasing-subsequence/">300. Longest Increasing Subsequence</a>
 * <p>
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 */
public class LongestIncreasingSubsequence_300 {

    private Map<Integer, Integer> maxLengthByIndex = new HashMap<>();

    public int lengthOfLIS(int[] nums) {
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            length = Math.max(length, dp(i, nums));
        }

        return length;
    }

    private int dp(int i, int[] nums) {
        if (maxLengthByIndex.containsKey(i)) {
            return maxLengthByIndex.get(i);
        }

        int length = 1;
        for (int j = 0; j < i; j++) {
            if (nums[i] <= nums[j]) {
                continue;
            }

            length = Math.max(length, dp(j, nums) + 1);
        }

        maxLengthByIndex.put(i, length);

        return length;
    }

}
