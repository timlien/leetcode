package com.tingshulien.leetcode.binarysearch;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/longest-subsequence-with-limited-sum/description/">2389. Longest Subsequence With Limited Sum</a>
 * <p>
 * You are given an integer array nums of length n, and an integer array queries of length m.
 * <p>
 * Return an array answer of length m where answer[i] is the maximum size of a subsequence
 * that you can take from nums such that the sum of its elements is less than or equal to queries[i].
 * <p>
 * A subsequence is an array that can be derived from another array
 * by deleting some or no elements without changing the order of the remaining elements.
 */
public class LongestSubsequenceWithLimitedSum_2389 {

    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);

        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = nums[i] + nums[i - 1];
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = binarySearch(prefix, queries[i]);
        }

        return answer;
    }

    private int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

}
