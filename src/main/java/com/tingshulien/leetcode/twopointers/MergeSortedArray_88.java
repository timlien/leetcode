package com.tingshulien.leetcode.twopointers;

/**
 * <a href="https://leetcode.com/problems/merge-sorted-array/">88. Merge Sorted Array</a>
 *
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
 * representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
 * and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 */
public class MergeSortedArray_88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length;

        while (i > 0) {
            if (n <= 0) {
                nums1[i - 1] = nums1[m - 1];
                m--;
            } else if (m <= 0) {
                nums1[i - 1] = nums2[n - 1];
                n--;
            } else if (nums1[m - 1] > nums2[n - 1]) {
                nums1[i - 1] = nums1[m - 1];
                m--;
            } else if (nums1[m - 1] <= nums2[n - 1]) {
                nums1[i - 1] = nums2[n - 1];
                n--;
            }

            i--;
        }

    }
}
