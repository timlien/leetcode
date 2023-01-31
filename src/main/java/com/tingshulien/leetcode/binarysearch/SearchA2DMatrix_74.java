package com.tingshulien.leetcode.binarysearch;

/**
 * <a href="https://leetcode.com/problems/search-a-2d-matrix/">74. Search a 2D Matrix</a>
 * <p>
 * You are given an m x n integer matrix matrix with the following two properties:
 * <p>
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the previous row.
 * Given an integer target, return true if target is in matrix or false otherwise.
 * <p>
 * You must write a solution in O(log(m * n)) time complexity.
 */
public class SearchA2DMatrix_74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;

        while (left <= right) {
            int pivot = left + (right - left);
            int number = matrix[pivot / n][pivot % n];

            if (number == target) {
                return true;
            }

            if (number > target) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }

        return false;
    }




}
