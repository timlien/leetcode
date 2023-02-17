package com.tingshulien.leetcode.binarysearch.solutionspace;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/path-with-minimum-effort/">1631. Path With Minimum Effort</a>
 * <p>
 * You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns,
 * where heights[row][col] represents the height of cell (row, col).
 * You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed).
 * You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.
 * <p>
 * A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
 * <p>
 * Return the minimum effort required to travel from the top-left cell to the bottom-right cell.
 */
public class PathWithMinimumEffort_1631 {

    private final int[][] directions = new int[][]{{1, 0}, {0 ,1}, {-1, 0}, {0, -1}};

    private boolean[][] seen;

    private int rows;

    private int cols;

    public int minimumEffortPath(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;

        int left = 0;
        int right = 0;

        for (int[] row : heights) {
            for (int number : row) {
                right = Math.max(right, number);
            }
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (dfs(mid, heights)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean dfs(int effort, int[][] heights) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        seen = new boolean[rows][cols];
        seen[0][0] = true;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            if (node[0] == rows - 1 && node[1] == cols - 1) {
                return true;
            }

            for (int[] direction : directions) {
                int[] neighbor = new int[]{node[0] + direction[0], node[1] + direction[1]};

                if (!isValid(neighbor) || isVisited(neighbor)) {
                    continue;
                }

                if (Math.abs(heights[node[0]][node[1]] - heights[neighbor[0]][neighbor[1]]) >  effort) {
                    continue;
                }

                seen[neighbor[0]][neighbor[1]] = true;
                queue.add(neighbor);
            }

        }

        return false;
    }

    private boolean isVisited(int[] node) {
        return seen[node[0]][node[1]];
    }

    private boolean isValid(int[] node) {
        return node[0] >= 0 && node[0] < rows && node[1] >= 0 && node[1] < cols;
    }

}
