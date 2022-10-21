package com.tingshulien.leetcode.hashing.counting;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/largest-unique-number/">1133. Largest Unique Number</a>
 * <p>
 * Given an integer array nums, return the largest integer that only occurs once. If no integer occurs once, return -1.
 */
public class LargestUniqueNumber_1133 {

    public int largestUniqueNumber(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.merge(num, 1, Integer::sum);
        }

        int max = -1;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() > 1) {
                continue;
            }

            max = Math.max(max, entry.getKey());
        }

        return max;
    }

}
