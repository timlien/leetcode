package com.tingshulien.leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/reachable-nodes-with-restrictions/description/">2368. Reachable Nodes With Restrictions</a>
 * <p>
 * There is an undirected tree with n nodes labeled from 0 to n - 1 and n - 1 edges.
 * <p>
 * You are given a 2D integer array edges of length n - 1 where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.
 * You are also given an integer array restricted which represents restricted nodes.
 * <p>
 * Return the maximum number of nodes you can reach from node 0 without visiting a restricted node.
 * <p>
 * Note that node 0 will not be a restricted node.
 */
public class ReachableNodesWithRestrictions_2368 {

    private Map<Integer, List<Integer>> graph;

    private boolean[] seen;

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        seen = new boolean[n];
        for (int node : restricted) {
            seen[node] = true;
        }

        graph = buildGraph(edges);
        return dfs(0);
    }

    private Map<Integer, List<Integer>> buildGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            graph.putIfAbsent(start, new ArrayList<>());
            graph.putIfAbsent(end, new ArrayList<>());
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        return graph;
    }

    private int dfs(int i) {
        int count = 1;

        seen[i] = true;

        for (int neighbor : graph.get(i)) {
            if (seen[neighbor]) {
                continue;
            }

            count += dfs(neighbor);
        }

        return count;
    }

}
