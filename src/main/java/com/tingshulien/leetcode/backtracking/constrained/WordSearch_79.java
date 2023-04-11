package com.tingshulien.leetcode.backtracking.constrained;

/**
 * <a href="https://leetcode.com/problems/word-search/description/">79. Word Search</a>
 * <p>
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 */
public class WordSearch_79 {

    private int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private int row;

    private int col;

    private boolean[][] seen;

    public boolean exist(char[][] board, String word) {
        this.row = board.length;
        this.col = board[0].length;
        this.seen = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                seen[i][j] = true;

                if (backtracking(0, i, j, board, word)) {
                    return true;
                }

                seen[i][j] = false;
            }
        }

        return false;
    }

    private boolean backtracking(int index, int row, int col, char[][] board, String word) {
        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        if (index == word.length() - 1) {
            return true;
        }

        boolean success = false;
        for (int[] direction : directions) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];

            if (nextRow < 0 || nextRow >= this.row || nextCol < 0 || nextCol >= this.col) {
                continue;
            }

            if (seen[nextRow][nextCol]) {
                continue;
            }

            seen[nextRow][nextCol] = true;
            success = success || backtracking(index + 1, nextRow, nextCol, board, word);
            seen[nextRow][nextCol] = false;
        }

        return success;
    }

}
