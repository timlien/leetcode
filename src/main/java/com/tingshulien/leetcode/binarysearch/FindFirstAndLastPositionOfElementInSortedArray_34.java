package com.tingshulien.leetcode.binarysearch;

/**
 * <a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/">34. Find First and Last Position of Element in Sorted Array</a>
 *
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class FindFirstAndLastPositionOfElementInSortedArray_34 {

    public int[] searchRange(int[] nums, int target) {
        int i = findMinimum(nums, target);
        if (i == -1) {
            return new int[]{-1, -1};
        }

        int j = findMaximum(nums, target);
        return new int[]{i, j};
    }

    private int findMinimum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int pivot;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (nums[pivot] == target) {
                if ((pivot == 0 || nums[pivot - 1] != target)) {
                    return pivot;
                } else {
                    right = pivot - 1;
                }
            } else if(nums[pivot] > target) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }

        return -1;
    }

    private int findMaximum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int pivot;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (nums[pivot] == target) {
                if (pivot == nums.length - 1 || nums[pivot + 1] != target) {
                    return pivot;
                } else {
                    left = pivot + 1;
                }
            } else if(nums[pivot] > target) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }

        return -1;
    }

}
