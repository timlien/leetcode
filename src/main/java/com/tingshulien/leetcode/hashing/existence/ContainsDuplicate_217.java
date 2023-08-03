package com.tingshulien.leetcode.hashing.existence;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/contains-duplicate/">217. Contains Duplicate</a>
 * <p>
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 */
public class ContainsDuplicate_217 {

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            if (count.put(num, 1) != null) {
                return true;
            }
        }

        return false;
    }

}
