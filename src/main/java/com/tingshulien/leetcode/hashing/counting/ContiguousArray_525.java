package com.tingshulien.leetcode.hashing.counting;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/contiguous-array/">525. Contiguous Array</a>
 * <p>
 * Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
 */
public class ContiguousArray_525 {

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> indexBySum = new HashMap<>();
        indexBySum.put(0, -1);

        int sum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 1 ? 1 : -1);
            if (indexBySum.containsKey(sum)) {
                count = Math.max(i - indexBySum.get(sum), count);
            } else {
                indexBySum.put(sum, i);
            }
        }

        return count;
    }

}
