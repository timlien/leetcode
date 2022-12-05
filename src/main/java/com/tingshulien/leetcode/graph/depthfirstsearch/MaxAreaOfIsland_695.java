package com.tingshulien.leetcode.graph.depthfirstsearch;

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
public class MaxAreaOfIsland_695 {

    private int[][] grid;

    private int[][] directions;

    int height;

    int width;

    private boolean[][] seen;

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        this.directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        this.height = grid.length;
        this.width = grid[0].length;
        this.seen = new boolean[height][width];

        int answer = 0;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (grid[row][col] == 0) {
                    continue;
                }

                if (seen[row][col]) {
                    continue;
                }

                answer = Math.max(answer, dfs(row, col));
            }
        }

        return answer;
    }

    private int dfs(int row, int col) {
        int count = 1;
        seen[row][col] = true;

        for (int[] direction : directions) {
            int neighborRow = row + direction[0];
            int neighborCol = col + direction[1];
            if (neighborRow < 0 || neighborRow >= height) {
                continue;
            }

            if (neighborCol < 0 || neighborCol >= width) {
                continue;
            }

            if (grid[neighborRow][neighborCol] == 0) {
                continue;
            }

            if (seen[neighborRow][neighborCol]) {
                continue;
            }

            count += dfs(neighborRow, neighborCol);
        }

        return count;
    }

}
