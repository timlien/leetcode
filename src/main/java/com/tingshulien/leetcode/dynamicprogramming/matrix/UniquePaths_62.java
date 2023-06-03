package com.tingshulien.leetcode.dynamicprogramming.matrix;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/unique-paths/">62. Unique Paths</a>
 * <p>
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
 * The robot can only move either down or right at any point in time.
 * <p>
 * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 * <p>
 * The test cases are generated so that the answer will be less than or equal to 2 * 109.
 */
public class UniquePaths_62 {

    private int m;

    private int n;

    private int[][] memo;

    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;
        this.memo = new int[m][n];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(0, 0);
    }

    private int dp(int row, int col) {
        if (row == m || col == n) {
            return 0;
        }

        if (row == m - 1 && col == n - 1) {
            return 1;
        }

        if (memo[row][col] != -1) {
            return memo[row][col];
        }

        memo[row][col] = dp(row + 1, col) + dp(row, col + 1);

        return memo[row][col];
    }

}
