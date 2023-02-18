package com.tingshulien.leetcode.binarysearch.solutionspace;

/**
 * <a href="https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description/">1283. Find the Smallest Divisor Given a Threshold</a>
 * <p>
 * Given an array of integers nums and an integer threshold, we will choose a positive integer divisor,
 * divide all the array by it, and sum the division's result.
 * Find the smallest divisor such that the result mentioned above is less than or equal to threshold.
 * <p>
 * Each result of the division is rounded to the nearest integer greater than or equal to that element.
 * (For example: 7/3 = 3 and 10/2 = 5).
 * <p>
 * The test cases are generated so that there will be an answer.
 */
public class FindTheSmallestDivisorGivenAThreshold_1283 {

    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = (int) Math.pow(10, 6);

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (divide(mid, nums, threshold)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean divide(int divisor, int[] nums, int threshold) {
        int result = 0;

        for (int num : nums) {
            result += Math.ceil(num / (double) divisor);
        }

        return result <= threshold;
    }

}
