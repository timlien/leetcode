package com.tingshulien.leetcode.prefixsum;

/**
 * <a href="https://leetcode.com/problems/minimum-average-difference/">2256. Minimum Average Difference</a>
 * <p>
 * You are given a 0-indexed integer array nums of length n.
 * <p>
 * The average difference of the index i is the absolute difference between the average of the first i + 1 elements of nums and the average of the last n - i - 1 elements. Both averages should be rounded down to the nearest integer.
 * <p>
 * Return the index with the minimum average difference. If there are multiple such indices, return the smallest one.
 * <p>
 * Note:
 * <p>
 * The absolute difference of two numbers is the absolute value of their difference.
 * The average of n elements is the sum of the n elements divided (integer division) by n.
 * The average of 0 elements is considered to be 0.
 */
public class MinimumAverageDifference_2256 {

    public int minimumAverageDifference(int[] nums) {
        int length = nums.length;
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }

        long leftSum = 0;
        long minAvgDiff = Long.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            leftSum += nums[i];
            long avgDiff = Math.abs((leftSum / (i + 1)) - (sum - leftSum) / (length - i - 1));
            if (avgDiff < minAvgDiff) {
                minAvgDiff = avgDiff;
                minIndex = i;
            }
        }

        if (sum / length < minAvgDiff) {
            return length - 1;
        } else {
            return minIndex;
        }
    }

}
