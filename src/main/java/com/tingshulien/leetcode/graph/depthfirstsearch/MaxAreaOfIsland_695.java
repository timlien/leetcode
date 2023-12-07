package com.tingshulien.leetcode.graph.depthfirstsearch;

import com.tingshulien.leetcode.utility.rank.AboveAverage;

/**
 * <a href="https://leetcode.com/problems/max-area-of-island/description/">695. Max Area of Island</a>
 * <p>
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
 * You may assume all four edges of the grid are surrounded by water.
 * <p>
 * The area of an island is the number of cells with a value 1 in the island.
 * <p>
 * Return the maximum area of an island in grid. If there is no island, return 0.
 */
@AboveAverage
public class MaxAreaOfIsland_695 {

    private int[][] grid;

    private int[][] connections;

    private int row;

    private int col;

    private boolean[][] seen;

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        this.connections = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        this.row = grid.length;
        this.col = grid[0].length;
        this.seen = new boolean[row][col];

        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (seen[i][j]) {
                    continue;
                }

                max = Math.max(max, dfs(i, j));
            }
        }

        return max;
    }

    private int dfs(int row, int col) {
        if (seen[row][col]) {
            return 0;
        }

        seen[row][col] = true;

        if (grid[row][col] == 0) {
            return 0;
        }

        int count = 1;

        for (int[] connection : connections) {
            int nextRow = row + connection[0];
            int nextCol = col + connection[1];

            if (nextRow < 0 || nextRow >= this.row) {
                continue;
            }

            if (nextCol < 0 || nextCol >= this.col) {
                continue;
            }

            count += dfs(nextRow, nextCol);
        }

        return count;
    }

}
