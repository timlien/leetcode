package com.tingshulien.leetcode.graph;

import com.tingshulien.leetcode.utility.rank.Bottom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/maximal-network-rank/description/">1615. Maximal Network Rank</a>
 * <p>
 * There is an infrastructure of n cities with some number of roads connecting these cities. Each roads[i] = [ai, bi] indicates that there is a bidirectional road between cities ai and bi.
 * <p>
 * The network rank of two different cities is defined as the total number of directly connected roads to either city. If a road is directly connected to both cities, it is only counted once.
 * <p>
 * The maximal network rank of the infrastructure is the maximum network rank of all pairs of different cities.
 * <p>
 * Given the integer n and the array roads, return the maximal network rank of the entire infrastructure.
 */
@Bottom
public class MaximalNetworkRank_1615 {

    private Map<Integer, List<Integer>> graph;

    private int n;

    public int maximalNetworkRank(int n, int[][] roads) {
        this.graph = new HashMap<>();
        this.n = n;

        for (int[] edge : roads) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<>());
            }

            graph.get(edge[0]).add(edge[1]);

            if (!graph.containsKey(edge[1])) {
                graph.put(edge[1], new ArrayList<>());
            }

            graph.get(edge[1]).add(edge[0]);
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dfs(i, -1, 2));
        }

        return max;
    }

    private int dfs(int node, int parent, int depth) {
        if (!graph.containsKey(node)) {
            return 0;
        }

        if (depth == 0) {
            return 0;
        }

        int connection = 0;

        for (int neighbor : graph.get(node)) {
            if (neighbor == parent) {
                continue;
            }

            connection++;
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (i == node) {
                continue;
            }

            max = Math.max(max, dfs(i, node, depth - 1));
        }

        return connection + max;
    }

}
