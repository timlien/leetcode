package com.tingshulien.leetcode.hashing.counting;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/count-number-of-nice-subarrays/">1248. Count Number of Nice Subarrays</a>
 * <p>
 * Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.
 * <p>
 * Return the number of nice sub-arrays.
 */
public class CountNumberOfNiceSubarrays_1248 {

    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> countByPrefix = new HashMap<>();
        countByPrefix.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] % 2);
            count += countByPrefix.getOrDefault(sum - k, 0);
            countByPrefix.merge(sum, 1, Integer::sum);
        }

        return count;
    }

}
