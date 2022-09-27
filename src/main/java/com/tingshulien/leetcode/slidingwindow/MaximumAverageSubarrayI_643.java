package com.tingshulien.leetcode.slidingwindow;

/**
 * <a href="https://leetcode.com/problems/maximum-average-subarray-i/">643. Maximum Average Subarray I</a>
 * <p>
 * You are given an integer array nums consisting of n elements, and an integer k.
 * <p>
 * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
 * Any answer with a calculation error less than 10-5 will be accepted.
 */
public class MaximumAverageSubarrayI_643 {

    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double max = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            max = Math.max(sum, max);
        }

        return max / k;
    }

}
