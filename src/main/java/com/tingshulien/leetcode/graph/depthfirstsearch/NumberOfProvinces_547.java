package com.tingshulien.leetcode.graph.depthfirstsearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/number-of-provinces/">547. Number of Provinces</a>
 * <p>
 * There are n cities. Some of them are connected, while some are not.
 * If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
 * <p>
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 * <p>
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 * <p>
 * Return the total number of provinces.
 */
public class NumberOfProvinces_547 {

    private Map<Integer, List<Integer>> graph;

    private boolean[] seen;

    public int findCircleNum(int[][] isConnected) {
        graph = buildGraph(isConnected);

        int size = isConnected.length;
        seen = new boolean[size];

        int ans = 0;
        for (int i = 0; i < size; i++) {
            if (seen[i]) {
                continue;
            }

            ans++;
            dfs(i);
        }

        return ans;
    }

    private Map<Integer, List<Integer>> buildGraph(int[][] isConnected) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        int height = isConnected.length;
        for (int i = 0; i < height; i++) {
            graph.putIfAbsent(i, new ArrayList<>());
            for (int j = i + 1; j < height; j++) {
                graph.putIfAbsent(j, new ArrayList<>());
                if (isConnected[i][j] == 1) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        return graph;
    }

    private void dfs(int node) {
        seen[node] = true;
        for (int neighbor : graph.get(node)) {
            if (seen[neighbor]) {
                continue;
            }

            dfs(neighbor);
        }
    }

}
