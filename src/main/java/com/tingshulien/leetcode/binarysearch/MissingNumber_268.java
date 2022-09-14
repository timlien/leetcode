package com.tingshulien.leetcode.binarysearch;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/missing-number/">268. Missing Number</a>
 *
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 */
public class MissingNumber_268 {

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        int pivot;

        while (left <= right) {
            pivot = left + (right - left) / 2;

            if (nums[pivot] == pivot) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }

        return left;
    }

}
