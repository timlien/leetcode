package com.tingshulien.leetcode.sorting;

/**
 * <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/">215. Kth Largest Element in an Array</a>
 * <p>
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * <p>
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * You must solve it in O(n) time complexity.
 */
public class KthLargestElementInAnArray_215 {

    public int findKthLargest(int[] nums, int k) {
        int index = findKthLargestIndex(nums, nums.length - k, 0, nums.length - 1);
        return nums[index];
    }

    private int findKthLargestIndex(int[] nums, int k, int left, int right) {
        int pivotIndex = partition(nums, left, right);
        if (pivotIndex == k) {
            return k;
        } else if (pivotIndex < k) {
            return findKthLargestIndex(nums, k, pivotIndex + 1, right);
        } else {
            return findKthLargestIndex(nums, k, left, pivotIndex - 1);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }

        i++;
        swap(nums, i, right);

        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
