package com.tingshulien.leetcode.hashing.counting;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/sum-of-unique-elements/">1748. Sum of Unique Elements</a>
 * <p>
 * You are given an integer array nums. The unique elements of an array are the elements that appear exactly once in the array.
 * <p>
 * Return the sum of all the unique elements of nums.
 */
public class SumOfUniqueElements_1748 {

    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.merge(num, 1, Integer::sum);
        }

        int answer = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() > 1) {
                continue;
            }

            answer += entry.getKey();
        }

        return answer;
    }

}
