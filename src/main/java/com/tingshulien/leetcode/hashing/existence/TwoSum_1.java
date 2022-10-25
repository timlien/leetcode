package com.tingshulien.leetcode.hashing.existence;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/two-sum/">1. Two Sum</a>
 * <p>
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 */
public class TwoSum_1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexByNumber = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int residue = target - nums[i];
            if (indexByNumber.containsKey(residue)) {
                return new int[]{i, indexByNumber.get(residue)};
            }

            indexByNumber.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }

}
