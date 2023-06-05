package com.tingshulien.leetcode.dynamicprogramming.matrix;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/minimum-falling-path-sum/description/">931. Minimum Falling Path Sum</a>
 * <p>
 * Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
 * <p>
 * A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right.
 * Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
 */
public class MinimumFallingPathSum_931 {

    private int m;

    private int n;

    private int[][] matrix;

    private int[][] memo;

    public int minFallingPathSum(int[][] matrix) {
        this.m = matrix.length;
        this.n = matrix[0].length;
        this.matrix = matrix;
        this.memo = new int[m][n];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        int answer = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++) {
            answer = Math.min(answer, dp(0, col));
        }

        return answer;
    }

    private int dp(int row, int col) {
        if (row == m) {
            return 0;
        }

        if (memo[row][col] != -1) {
            return memo[row][col];
        }

        int value = matrix[row][col];

        memo[row][col] = value + dp(row + 1, col);

        if (col > 0) {
            memo[row][col] = Math.min(memo[row][col], value + dp(row + 1, col - 1));
        }

        if (col < n - 1) {
            memo[row][col] = Math.min(memo[row][col], value + dp(row + 1, col + 1));
        }

        return memo[row][col];
    }

}
