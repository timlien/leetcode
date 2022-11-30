package com.tingshulien.leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/find-if-path-exists-in-graph/description/">1971. Find if Path Exists in Graph</a>
 * <p>
 * There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive).
 * The edges in the graph are represented as a 2D integer array edges,
 * where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi.
 * Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.
 * <p>
 * You want to determine if there is a valid path that exists from vertex source to vertex destination.
 * <p>
 * Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.
 */
public class FindIfPathExistsInGraph_1971 {

    private Map<Integer, List<Integer>> graph;

    private boolean[] seen;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        graph = buildGraph(n, edges);
        seen = new boolean[n];

        return dfs(source, destination);
    }

    private Map<Integer, List<Integer>> buildGraph(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.putIfAbsent(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        return graph;
    }

    private boolean dfs(int source, int destination) {
        boolean valid = false;

        seen[source] = true;

        if (source == destination) {
            return true;
        }

        for (int neighbor : graph.get(source)) {
            if (seen[neighbor]) {
                continue;
            }

            valid = valid || dfs(neighbor, destination);
        }

        return valid;
    }

}
