package com.tingshulien.leetcode.graph.depthfirstsearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/number-of-islands/">200. Number of Islands</a>
 * <p>
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslands_200 {

    Map<String, List<String>> graph;

    Set<String> seen;

    public int numIslands(char[][] grid) {
        graph = buildGraph(grid);
        seen = new HashSet<>();

        int ans = 0;
        for (String node : graph.keySet()) {
            if (seen.contains(node)) {
                continue;
            }

            ans++;
            dfs(node);
        }

        return ans;
    }

    private Map<String, List<String>> buildGraph(char[][] grid) {
        graph = new HashMap<>();
        int height = grid.length;
        int width = grid[0].length;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }

                String node = hash(i, j);
                graph.putIfAbsent(node, new ArrayList<>());

                if (j < width - 1 && grid[i][j + 1] == '1') {
                    String rightNode = hash(i, j + 1);
                    graph.get(node).add(rightNode);
                    graph.putIfAbsent(rightNode, new ArrayList<>());
                    graph.get(rightNode).add(node);
                }

                if (i < height - 1 && grid[i + 1][j] == '1') {
                    String downNode = hash(i + 1, j);
                    graph.get(node).add(downNode);
                    graph.putIfAbsent(downNode, new ArrayList<>());
                    graph.get(downNode).add(node);
                }
            }
        }

        return graph;
    }

    private void dfs(String node) {
        seen.add(node);

        for (String neighbor : graph.get(node)) {
            if (seen.contains(neighbor)) {
                continue;
            }

            dfs(neighbor);
        }
    }

    private String hash(int i, int j) {
        return i + "_" + j;
    }

}
