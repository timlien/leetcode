package com.tingshulien.leetcode.greedy;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/partition-array-such-that-maximum-difference-is-k/">2294. Partition Array Such That Maximum Difference Is K</a>
 * <p>
 * You are given an integer array nums and an integer k. You may partition nums into one or more subsequences such that each element in nums appears in exactly one of the subsequences.
 * <p>
 * Return the minimum number of subsequences needed such that the difference between the maximum and minimum values in each subsequence is at most k.
 * <p>
 * A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.
 */
public class PartitionArraySuchThatMaximumDifferenceIsK_2294 {

    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);

        int answer = 1; // [1,2,3,5,6], k = 2

        int start = nums[0];
        for (int num : nums) {
            if (num - start > k) {
                start = num;
                answer++;
            }
        }

        return answer;
    }

}
