package com.tingshulien.leetcode.backtracking.constrained;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/n-queens-ii/">52. N-Queens II</a>
 * <p>
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 * <p>
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 */
public class NQueensII_52 {

    private int count;

    public int totalNQueens(int n) {
        this.count = n;
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonal = new HashSet<>();
        Set<Integer> antiDiagonal = new HashSet<>();
        return backtracking(0, columns, diagonal, antiDiagonal);
    }

    private int backtracking(int row, Set<Integer> columns, Set<Integer> diagonal, Set<Integer> antiDiagonal) {
        if (row == count) {
            return 1;
        }

        int solution = 0;

        for (int col = 0; col < count; col++) {
            if (columns.contains(col) || diagonal.contains(row - col) || antiDiagonal.contains(row + col)) {
                continue;
            }

            columns.add(col);
            diagonal.add(row - col);
            antiDiagonal.add(row + col);
            solution += backtracking(row + 1, columns, diagonal, antiDiagonal);
            columns.remove(col);
            diagonal.remove(row - col);
            antiDiagonal.remove(row + col);
        }

        return solution;
    }

}
