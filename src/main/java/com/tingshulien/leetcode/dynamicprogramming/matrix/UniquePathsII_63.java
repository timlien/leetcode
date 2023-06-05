package com.tingshulien.leetcode.dynamicprogramming.matrix;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/unique-paths-ii/description/">63. Unique Paths II</a>
 * <p>
 * You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
 * The robot can only move either down or right at any point in time.
 * <p>
 * An obstacle and space are marked as 1 or 0 respectively in grid.
 * A path that the robot takes cannot include any square that is an obstacle.
 * <p>
 * Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 * <p>
 * The testcases are generated so that the answer will be less than or equal to 2 * 109.
 */
public class UniquePathsII_63 {

    private int m;

    private int n;

    private int[][] grid;

    private int[][] memo;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        this.m = obstacleGrid.length;
        this.n = obstacleGrid[0].length;
        this.grid = obstacleGrid;
        this.memo = new int[m][n];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(0, 0);
    }

    private int dp(int row, int col) {
        if (grid[row][col] == 1) {
            return 0;
        }

        if (row == m - 1 && col == n - 1) {
            return 1;
        }

        if (memo[row][col] != -1) {
            return memo[row][col];
        }

        if (row < m - 1 && col < n - 1) {
            memo[row][col] = dp(row + 1, col) + dp(row, col + 1);
        } else if (row == m - 1) {
            memo[row][col] = dp(row, col + 1);
        } else {
            memo[row][col] = dp(row + 1, col);
        }

        return memo[row][col];
    }

}
