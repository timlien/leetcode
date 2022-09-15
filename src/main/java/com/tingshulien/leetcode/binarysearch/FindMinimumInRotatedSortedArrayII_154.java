package com.tingshulien.leetcode.binarysearch;

/**
 * <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/">154. Find Minimum in Rotated Sorted Array II</a>
 * <p>
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,4,4,5,6,7] might become:
 * <p>
 * [4,5,6,7,0,1,4] if it was rotated 4 times.
 * [0,1,4,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 * <p>
 * Given the sorted rotated array nums that may contain duplicates, return the minimum element of this array.
 * <p>
 * You must decrease the overall operation steps as much as possible.
 */
public class FindMinimumInRotatedSortedArrayII_154 {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int pivot;

        while (left <= right) {
            pivot = left + (right - left) / 2;

            if (nums[pivot] > nums[right]) {
                left = pivot + 1;
            } else if (nums[pivot] < nums[right]) {
                right = pivot;
            } else {
                right--;
            }
        }

        return nums[left];
    }

}
