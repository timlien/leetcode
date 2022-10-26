package com.tingshulien.leetcode.hashing.grouping;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/equal-row-and-column-pairs/">2352. Equal Row and Column Pairs</a>
 * <p>
 * Given a 0-indexed n x n integer matrix grid, return the number of pairs (Ri, Cj) such that row Ri and column Cj are equal.
 * <p>
 * A row and column pair is considered equal if they contain the same elements in the same order (i.e. an equal array).
 */
public class EqualRowAndColumnPairs_2352 {

    public int equalPairs(int[][] grid) {
        Map<String, Integer> rowCounts = new HashMap<>();
        for (int[] row : grid) {
            StringBuilder builder = new StringBuilder();
            for (int number : row) {
                builder.append(number);
                builder.append(",");
            }

            String rowStr = builder.toString();
            rowCounts.put(rowStr, rowCounts.getOrDefault(rowStr, 0) + 1);
        }

        Map<String, Integer> colCounts = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < grid.length; j++) {
                builder.append(grid[j][i]);
                builder.append(",");
            }

            String colStr = builder.toString();
            colCounts.put(colStr, colCounts.getOrDefault(colStr, 0) + 1);
        }

        int ans = 0;
        for (String key: rowCounts.keySet()) {
            ans += rowCounts.get(key) * colCounts.getOrDefault(key, 0);
        }

        return ans;
    }

}
