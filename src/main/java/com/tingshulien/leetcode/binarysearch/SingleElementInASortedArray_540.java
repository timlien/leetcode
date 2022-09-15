package com.tingshulien.leetcode.binarysearch;

/**
 * <a href="https://leetcode.com/problems/single-element-in-a-sorted-array/">540. Single Element in a Sorted Array</a>
 *
 * You are given a sorted array consisting of only integers where every element appears exactly twice,
 * except for one element which appears exactly once.
 *
 * Return the single element that appears only once.
 *
 * Your solution must run in O(log n) time and O(1) space.
 */
public class SingleElementInASortedArray_540 {

    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int pivot;

        while (left <= right) {
            pivot = left + (right - left) / 2;

            if (pivot == left || pivot == right) {
                return nums[pivot];
            }

            if (nums[pivot] == nums[pivot + 1]) {
                if ((pivot - left) % 2 == 0) {
                    left = pivot + 2;
                } else {
                    right = pivot - 1;
                }
            } else if (nums[pivot] == nums[pivot - 1]) {
                if ((pivot - left) % 2 == 0) {
                    right = pivot - 2;
                } else {
                    left = pivot + 1;
                }
            } else {
                return nums[pivot];
            }
        }

        return -1;
    }

}
