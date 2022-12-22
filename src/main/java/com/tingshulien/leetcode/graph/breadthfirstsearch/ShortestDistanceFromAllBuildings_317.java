package com.tingshulien.leetcode.graph.breadthfirstsearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/shortest-distance-from-all-buildings/">317. Shortest Distance from All Buildings</a>
 * <p>
 * You are given an m x n grid grid of values 0, 1, or 2, where:
 * <p>
 * each 0 marks an empty land that you can pass by freely,
 * each 1 marks a building that you cannot pass through, and
 * each 2 marks an obstacle that you cannot pass through.
 * You want to build a house on an empty land that reaches all buildings in the shortest total travel distance. You can only move up, down, left, and right.
 * <p>
 * Return the shortest travel distance for such a house. If it is not possible to build such a house according to the above rules, return -1.
 * <p>
 * The total travel distance is the sum of the distances between the houses of the friends and the meeting point.
 * <p>
 * The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
 */
public class ShortestDistanceFromAllBuildings_317 {

    private int[][] directions;

    private int rows;

    private int cols;

    private int buildings;

    public int shortestDistance(int[][] grid) {
        directions = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};

        rows = grid.length;
        cols = grid[0].length;

        int distance = Integer.MAX_VALUE;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    buildings++;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != 0) {
                    continue;
                }

                distance = Math.min(distance, bfs(i, j, grid));
            }
        }

        if (distance == Integer.MAX_VALUE) {
            return -1;
        } else {
            return distance;
        }
    }

    private int bfs(int row, int col, int[][] grid) {
        boolean[][] seen = new boolean[rows][cols];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        seen[row][col] = true;

        int distanceSum = 0;
        int buildingCount = 0;
        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.remove();

                if (grid[node[0]][node[1]] == 1) {
                    distanceSum += step;
                    buildingCount++;

                    if (buildingCount == buildings) {
                        return distanceSum;
                    }

                    continue;
                }

                for (int[] direction : directions) {
                    int nextRow = node[0] + direction[0];
                    int nextCol = node[1] + direction[1];
                    if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols) {
                        continue;
                    }

                    if (grid[nextRow][nextCol] == 2) {
                        continue;
                    }

                    if (seen[nextRow][nextCol]) {
                        continue;
                    }

                    queue.add(new int[]{nextRow, nextCol});
                    seen[nextRow][nextCol] = true;
                }
            }

            step++;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0 && seen[i][j]) {
                    grid[i][j] = 2;
                }
            }
        }

        return Integer.MAX_VALUE;
    }

}
