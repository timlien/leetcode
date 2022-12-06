package com.tingshulien.leetcode.graph.breadthfirstsearch;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/shortest-path-in-binary-matrix/description/">1091. Shortest Path in Binary Matrix</a>
 * <p>
 * Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.
 * <p>
 * A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
 * <p>
 * All the visited cells of the path are 0.
 * All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
 * The length of a clear path is the number of visited cells of this path.
 */
public class ShortestPathInBinaryMatrix_1091 {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        if (grid[0][0] == 1 || grid[row - 1][col - 1] == 1) {
            return -1;
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});

        boolean[][] seen = new boolean[row][col];
        seen[0][0] = true;

        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;

            for (int i = 0; i < size; i++) {
                int[] node = queue.remove();


                if (node[0] == row - 1 && node[1] == col - 1) {
                    return step;
                }

                for (int[] direction : directions) {
                    int nextRow = node[0] + direction[0];
                    int nextCol = node[1] + direction[1];

                    if (nextRow < 0 || nextRow >= row || nextCol < 0 || nextCol >= col || grid[nextRow][nextCol] == 1 || seen[nextRow][nextCol]) {
                        continue;
                    }

                    seen[nextRow][nextCol] = true;
                    queue.add(new int[]{nextRow, nextCol});
                }
            }
        }

        return -1;
    }

}
