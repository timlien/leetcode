package com.tingshulien.leetcode.binarysearch;

/**
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums.
 * If target exists, then return its index. Otherwise, return -1.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class BinarySearch_704 {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int pivot;

        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (nums[pivot] > target) {
                right = pivot - 1;
            } else if (nums[pivot] < target) {
                left = pivot + 1;
            } else {
                return pivot;
            }
        }

        return -1;
    }

}
