package com.tingshulien.leetcode.slidingwindow;

/**
 * <a href="https://leetcode.com/problems/subarray-product-less-than-k/">713. Subarray Product Less Than K</a>
 * <p>
 * Given an array of integers nums and an integer k,
 * return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.
 */
public class SubarrayProductLessThanK_713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int product = 1;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];

            while (left <= right && product >= k) {
                product /= nums[left];
                left++;
            }

            if (product < k) {
                count += right - left + 1;
            }
        }

        return count;
    }

}
