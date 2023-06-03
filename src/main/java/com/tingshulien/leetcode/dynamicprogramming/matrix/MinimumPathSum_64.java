package com.tingshulien.leetcode.dynamicprogramming.matrix;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/minimum-path-sum/">64. Minimum Path Sum</a>
 * <p>
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right,
 * which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 */
public class MinimumPathSum_64 {

    private int m;

    private int n;

    private int[][] grid;

    private int[][] memo;

    public int minPathSum(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.grid = grid;
        this.memo = new int[m][n];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(0, 0);
    }

    private int dp(int row, int col) {
        if (row == m - 1 && col == n - 1) {
            return grid[row][col];
        }

        if (memo[row][col] != -1) {
            return memo[row][col];
        }

        int sum = grid[row][col];
        if (row < m -1 && col < n - 1) {
            sum += Math.min(dp(row + 1, col), dp(row, col + 1));
        } else if (row == m - 1) {
            sum += dp(row, col + 1);
        } else {
            sum += dp(row + 1, col);
        }

        memo[row][col] = sum;

        return memo[row][col];
    }

}
