package com.tingshulien.leetcode.slidingwindow;

/**
 * <a href="https://leetcode.com/problems/number-of-zero-filled-subarrays/">2348. Number of Zero-Filled Subarrays</a>
 * <p>
 * Given an integer array nums, return the number of subarrays filled with 0.
 * <p>
 * A subarray is a contiguous non-empty sequence of elements within an array.
 */
public class NumberOfZeroFilledSubarrays_2348 {

    public long zeroFilledSubarray(int[] nums) {
        int left = 0;
        long count = 0;

        for (int right = 0; right < nums.length; right++) {
            if (left < right && nums[right - 1] != 0) {
                left = right;
            }

            if (nums[right] == 0) {
                count += right - left + 1;
            }
        }

        return count;
    }

}
