package com.tingshulien.leetcode.hashing.counting;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/subarray-sum-equals-k/">560. Subarray Sum Equals K</a>
 * <p>
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 * <p>
 * A subarray is a contiguous non-empty sequence of elements within an array.
 */
public class SubarraySumEqualsK_560 {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> countByPrefix = new HashMap<>();
        countByPrefix.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            count += countByPrefix.getOrDefault(sum - k, 0);
            countByPrefix.merge(sum, 1, Integer::sum);
        }

        return count;
    }

}
