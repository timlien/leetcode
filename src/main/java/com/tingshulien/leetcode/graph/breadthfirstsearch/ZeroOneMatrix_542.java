package com.tingshulien.leetcode.graph.breadthfirstsearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/01-matrix/">542. 01 Matrix</a>
 * <p>
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 * <p>
 * The distance between two adjacent cells is 1.
 */
public class ZeroOneMatrix_542 {

    private int[][] directions;

    private int height;

    private int width;

    public int[][] updateMatrix(int[][] mat) {
        this.directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        this.height = mat.length;
        this.width = mat[0].length;

        int[][] answer = new int[height][width];

        Queue<Node> queue = new LinkedList<>();
        boolean[][] seen = new boolean[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (mat[i][j] == 1) {
                    continue;
                }

                Node node = new Node(i, j);
                seen[i][j] = true;
                queue.add(node);
            }
        }

        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node node = queue.remove();
                answer[node.row][node.col] = distance;

                for (int[] direction : directions) {
                    int nextRow = node.row + direction[0];
                    int nextCol = node.col + direction[1];

                    if (isInvalid(nextRow, nextCol)) {
                        continue;
                    }

                    if (seen[nextRow][nextCol]) {
                        continue;
                    }

                    Node neighbor = new Node(nextRow, nextCol);
                    queue.add(neighbor);
                    seen[nextRow][nextCol] = true;
                }
            }

            distance++;
        }

        return answer;
    }

    private boolean isInvalid(int row, int col) {
        return row < 0 || row >= height || col < 0 || col >= width;
    }

    private static class Node {

        private int row;

        private int col;

        private Node(int row, int col) {
            this.row = row;
            this.col = col;
        }

    }

}
