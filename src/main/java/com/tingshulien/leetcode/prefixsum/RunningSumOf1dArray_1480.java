package com.tingshulien.leetcode.prefixsum;

/**
 * <a href="https://leetcode.com/problems/running-sum-of-1d-array/description/">1480. Running Sum of 1d Array</a>
 * <p>
 * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
 * <p>
 * Return the running sum of nums.
 */
public class RunningSumOf1dArray_1480 {

    public int[] runningSum(int[] nums) {
        int[] runningSum = new int[nums.length];
        runningSum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            runningSum[i] += nums[i] + runningSum[i - 1];
        }

        return runningSum;
    }

}
