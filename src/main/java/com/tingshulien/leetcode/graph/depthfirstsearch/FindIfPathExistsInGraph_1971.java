package com.tingshulien.leetcode.graph.depthfirstsearch;

import com.tingshulien.leetcode.utility.rank.BelowAverage;
import java.util.ArrayList;
import java.util.Collections;
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
@BelowAverage
public class FindIfPathExistsInGraph_1971 {

    private Map<Integer, List<Integer>> graph;

    private boolean [] seen;

    private int destination;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        this.graph = new HashMap<>();
        this.seen = new boolean[n];
        this.destination = destination;

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

        return dfs(source);
    }

    private boolean dfs(int source) {
        if (source == destination) {
            return true;
        }

        for (int neighbor : graph.getOrDefault(source, Collections.emptyList())) {
            if (seen[neighbor]) {
                continue;
            }

            seen[neighbor] = true;
            if (dfs(neighbor)) {
                return true;
            }
        }

        return false;
    }

}
