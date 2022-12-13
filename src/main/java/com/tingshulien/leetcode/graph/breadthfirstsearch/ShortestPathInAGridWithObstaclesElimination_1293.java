package com.tingshulien.leetcode.graph.breadthfirstsearch;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/">1293. Shortest Path in a Grid with Obstacles Elimination</a>
 * <p>
 * You are given an m x n integer matrix grid where each cell is either 0 (empty) or 1 (obstacle).
 * You can move up, down, left, or right from and to an empty cell in one step.
 * <p>
 * Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner (m - 1, n - 1) given that you can eliminate at most k obstacles.
 * If it is not possible to find such walk return -1.
 */
public class ShortestPathInAGridWithObstaclesElimination_1293 {

    public int shortestPath(int[][] grid, int k) {
        int[][] directions = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};

        Queue<Node> queue = new LinkedList<>();
        Set<Node> seen = new HashSet<>();

        Node start = Node.newInstance(0, 0, 0, k);
        queue.add(start);
        seen.add(start);

        int rows = grid.length;
        int cols = grid[0].length;

        if (k >= (rows + cols - 2)) {
            return rows + cols - 2;
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.remove();

                if (node.row == rows - 1 && node.col == cols - 1) {
                    return node.step;
                }

                for (int[] direction : directions) {
                    int neighborRow = node.row + direction[0];
                    int neighborCol = node.col + direction[1];

                    if (neighborRow < 0 || neighborRow >= rows || neighborCol < 0 || neighborCol >= cols) {
                        continue;
                    }

                    Node neighbor = Node.newInstance(neighborRow, neighborCol, node.step + 1, node.k - grid[neighborRow][neighborCol]);
                    if (seen.contains(neighbor) || neighbor.k < 0) {
                        continue;
                    }

                    queue.add(neighbor);
                    seen.add(neighbor);
                }
            }
        }

        return -1;
    }

    private static class Node {

        int row;

        int col;

        int step;

        int k;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node node = (Node) o;
            return row == node.row && col == node.col && k == node.k;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col, k);
        }

        static Node newInstance(int row, int col, int step, int k) {
            Node node = new Node();
            node.row = row;
            node.col = col;
            node.step = step;
            node.k = k;
            return node;
        }

    }

}
