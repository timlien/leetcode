package com.tingshulien.leetcode.graph.depthfirstsearch;

import com.tingshulien.leetcode.utility.rank.BelowAverage;
import java.util.ArrayList;
import java.util.Collections;
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
@BelowAverage
public class NumberOfConnectedComponentsInAnUndirectedGraph_323 {

    private Map<Integer, List<Integer>> graph;

    private boolean[] seen;

    public int countComponents(int n, int[][] edges) {
        graph = new HashMap<>();

        for (int[] edge : edges) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<>());
            }

            graph.get(edge[0]).add(edge[1]);

            if (!graph.containsKey(edge[1])) {
                graph.put(edge[1], new ArrayList<>());
            }

            graph.get(edge[1]).add(edge[0]);
        }

        seen = new boolean[n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            count += dfs(i);
        }

        return count;
    }

    private int dfs(int node) {
        if (seen[node]) {
            return 0;
        }

        seen[node] = true;
        for (int neighbor : graph.getOrDefault(node, Collections.emptyList())) {
            dfs(neighbor);
        }

        return 1;
    }

}
