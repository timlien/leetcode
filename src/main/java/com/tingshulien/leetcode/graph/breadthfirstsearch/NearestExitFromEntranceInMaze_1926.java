package com.tingshulien.leetcode.graph.breadthfirstsearch;

import com.tingshulien.leetcode.utility.rank.AboveAverage;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/description/">1926. Nearest Exit from Entrance in Maze</a>
 * <p>
 * You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+'). You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.
 * <p>
 * In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot step outside the maze. Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell that is at the border of the maze. The entrance does not count as an exit.
 * <p>
 * Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.
 */
@AboveAverage
public class NearestExitFromEntranceInMaze_1926 {

    private int[][] connections;

    private char[][] maze;

    private int[] entrance;

    private int row;

    private int col;

    private boolean[][] seen;

    public int nearestExit(char[][] maze, int[] entrance) {
        this.connections = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        this.maze = maze;
        this.entrance = entrance;
        this.row = maze.length;
        this.col = maze[0].length;
        this.seen = new boolean[row][col];

        Queue<State> queue = new LinkedList<>();
        State start = new State(entrance[0], entrance[1], 0);
        queue.add(start);
        seen[start.row][start.col] = true;

        while (!queue.isEmpty()) {
            State node = queue.remove();

            if (isExit(node)) {
                return node.step;
            }

            for (int[] connection : connections) {
                int nextRow = node.row + connection[0];
                int nextCol = node.col + connection[1];

                if (!isTraversable(nextRow, nextCol)) {
                    continue;
                }

                if (seen[nextRow][nextCol]) {
                    continue;
                }

                seen[nextRow][nextCol] = true;

                if (isWall(nextRow, nextCol)) {
                    continue;
                }

                queue.add(new State(nextRow, nextCol, node.step + 1));
            }
        }

        return -1;
    }

    private boolean isWall(int row, int col) {
        return maze[row][col] == '+';
    }

    private boolean isExit(State state) {
        if (state.row == entrance[0] && state.col == entrance[1]) {
            return false;
        }

        return state.row == 0 || state.col == 0 || state.row == this.row - 1 || state.col == this.col - 1;
    }

    private boolean isTraversable(int row, int col) {
        return row >= 0 && col >= 0 && row < this.row && col < this.col;
    }

    private static class State {

        private int row;

        private int col;

        private int step;

        public State(int row, int col, int step) {
            this.row = row;
            this.col = col;
            this.step = step;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            State state = (State) o;
            return row == state.row && col == state.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

}
