package com.tingshulien.leetcode.sorting;

public class InsertionSort {

    public static void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            int j = i - 1;

            while (j >= 0 && current < nums[j]) {
                nums[j + 1] = nums[j];
                j--;
            }

            nums[j + 1] = current;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
