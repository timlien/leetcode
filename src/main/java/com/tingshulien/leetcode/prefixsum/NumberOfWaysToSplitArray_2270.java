package com.tingshulien.leetcode.prefixsum;

/**
 * <a href="https://leetcode.com/problems/number-of-ways-to-split-array/">2270. Number of Ways to Split Array</a>
 * <p>
 * You are given a 0-indexed integer array nums of length n.
 * <p>
 * nums contains a valid split at index i if the following are true:
 * <p>
 * The sum of the first i + 1 elements is greater than or equal to the sum of the last n - i - 1 elements.
 * There is at least one element to the right of i. That is, 0 <= i < n - 1.
 * Return the number of valid splits in nums.
 */
public class NumberOfWaysToSplitArray_2270 {

    public int waysToSplitArray(int[] nums) {
        final long[] prefix = new long[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = nums[i] + prefix[i - 1];
        }

        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (prefix[i] >= (prefix[nums.length - 1] - prefix[i])) {
                count++;
            }
        }

        return count;
    }

}
