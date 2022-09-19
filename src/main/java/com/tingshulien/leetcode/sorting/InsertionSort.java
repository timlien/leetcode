package com.tingshulien.leetcode.sorting;

public class InsertionSort {

    public static void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] > nums[j - 1]) {
                    break;
                }

                swap(nums, j, j - 1);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
