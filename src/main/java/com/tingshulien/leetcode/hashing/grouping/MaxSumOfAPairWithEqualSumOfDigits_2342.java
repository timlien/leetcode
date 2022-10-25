package com.tingshulien.leetcode.hashing.grouping;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/">2342. Max Sum of a Pair With Equal Sum of Digits</a>
 * <p>
 * You are given a 0-indexed array nums consisting of positive integers.
 * You can choose two indices i and j, such that i != j, and the sum of digits of the number nums[i] is equal to that of nums[j].
 * <p>
 * Return the maximum value of nums[i] + nums[j] that you can obtain over all possible indices i and j that satisfy the conditions.
 */
public class MaxSumOfAPairWithEqualSumOfDigits_2342 {

    public int maximumSum(int[] nums) {
        Map<Integer, Integer> numberByDigitSum = new HashMap<>();
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            int digitSum = digitSum(number);
            if (numberByDigitSum.containsKey(digitSum)) {
                int value = numberByDigitSum.get(digitSum);
                maxSum = Math.max(maxSum, number + value);

                if (number > value) {
                    numberByDigitSum.put(digitSum, number);
                }
            } else {
                numberByDigitSum.put(digitSum, number);
            }
        }

        return maxSum == Integer.MIN_VALUE ? -1 : maxSum;
    }

    private int digitSum(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }

}
