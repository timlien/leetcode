package com.tingshulien.leetcode.graph.depthfirstsearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/description/">323. Number of Connected Components in an Undirected Graph</a>
 * <p>
 * You have a graph of n nodes.
 * You are given an integer n and an array edges where edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the graph.
 * <p>
 * Return the number of connected components in the graph.
 */
public class NumberOfConnectedComponentsInAnUndirectedGraph_323 {

    private Map<Integer, List<Integer>> graph;

    private boolean[] seen;

    public int countComponents(int n, int[][] edges) {
        graph = buildGraph(n, edges);
        seen = new boolean[n];

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (seen[i]) {
                continue;
            }

            ans++;
            dfs(i);
        }

        return ans;
    }

    private Map<Integer, List<Integer>> buildGraph(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        return graph;
    }

    private void dfs(int i) {
        seen[i] = true;

        for (int neighbor : graph.get(i)) {
            if (seen[neighbor]) {
                continue;
            }

            dfs(neighbor);
        }
    }

}
