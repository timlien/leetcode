package com.tingshulien.leetcode.greedy;

/**
 * <a href="https://leetcode.com/problems/non-decreasing-array/">665. Non-decreasing Array</a>
 *
 * Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.
 *
 * We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).
 */
public class NonDecreasingArray_665 {

    public boolean checkPossibility(int[] nums) {
        int violations = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] > nums[i]) {

                violations++;

                if (i >= 2 && nums[i-2] > nums[i]) {
                    nums[i] = nums[i-1];
                } else {
                    nums[i-1] = nums[i];
                }
            }

            if (violations > 1) {
                return false;
            }
        }

        return true;
    }

}
