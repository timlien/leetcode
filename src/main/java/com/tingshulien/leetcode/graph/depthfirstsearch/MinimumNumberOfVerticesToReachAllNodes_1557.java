package com.tingshulien.leetcode.graph.depthfirstsearch;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/">1557. Minimum Number of Vertices to Reach All Nodes</a>
 * <p>
 * Given a directed acyclic graph, with n vertices numbered from 0 to n-1,
 * and an array edges where edges[i] = [fromi, toi] represents a directed edge from node fromi to node toi.
 * <p>
 * Find the smallest set of vertices from which all nodes in the graph are reachable. It's guaranteed that a unique solution exists.
 * <p>
 * Notice that you can return the vertices in any order.
 */
public class MinimumNumberOfVerticesToReachAllNodes_1557 {

    private Map<Integer, List<Integer>> graph;

    private Set<Integer> vertices;

    private boolean[] seen;

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        graph = buildGraph(n, edges);
        vertices = new HashSet<>(n);
        seen = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (seen[i]) {
                continue;
            }

            vertices.add(i);
            dfs(i);
        }

        return new ArrayList<>(vertices);
    }

    private Map<Integer, List<Integer>> buildGraph(int n, List<List<Integer>> edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.putIfAbsent(i, new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            int start = edge.get(0);
            int end = edge.get(1);
            graph.get(start).add(end);
        }

        return graph;
    }

    private void dfs(int node) {
        seen[node] = true;

        for (int neighbor : graph.get(node)) {
            if (seen[neighbor]) {
                vertices.remove(neighbor);
                continue;
            }

            dfs(neighbor);
        }
    }

}
