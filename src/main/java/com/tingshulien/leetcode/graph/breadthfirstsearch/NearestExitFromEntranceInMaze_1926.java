package com.tingshulien.leetcode.graph.breadthfirstsearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/description/">1926. Nearest Exit from Entrance in Maze</a>
 *
 * You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+'). You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.
 *
 * In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot step outside the maze. Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell that is at the border of the maze. The entrance does not count as an exit.
 *
 * Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.
 */
public class NearestExitFromEntranceInMaze_1926 {

    private int rows;

    private int cols;

    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] directions = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};

        rows = maze.length;
        cols = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] seen = new boolean[rows][cols];

        int[] startNode = new int[]{entrance[0], entrance[1], 0};
        queue.add(startNode);
        seen[startNode[0]][startNode[1]] = true;

        while (!queue.isEmpty()) {
            int[] node = queue.remove();

            for (int[] direction : directions) {
                int neighborRow = node[0] + direction[0];
                int neighborCol = node[1] + direction[1];

                if (invalid(neighborRow, neighborCol)) {
                    if (node[2] == 0) {
                        continue;
                    } else {
                        return node[2];
                    }
                }

                if (maze[neighborRow][neighborCol] == '+') {
                    continue;
                }

                if (seen[neighborRow][neighborCol]) {
                    continue;
                }

                queue.add(new int[]{neighborRow, neighborCol, node[2] + 1});
                seen[neighborRow][neighborCol] = true;
            }
        }

        return -1;
    }

    private boolean invalid(int row, int col) {
        return row < 0 || row >= rows || col < 0 || col >= cols;
    }

}
