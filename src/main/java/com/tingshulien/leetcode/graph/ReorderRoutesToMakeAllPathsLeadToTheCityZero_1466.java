package com.tingshulien.leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/">1466. Reorder Routes to Make All Paths Lead to the City Zero</a>
 * <p>
 * There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree).
 * Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.
 * <p>
 * Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.
 * <p>
 * This year, there will be a big event in the capital (city 0), and many people want to travel to this city.
 * <p>
 * Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.
 * <p>
 * It's guaranteed that each city can reach city 0 after reorder.
 */
public class ReorderRoutesToMakeAllPathsLeadToTheCityZero_1466 {

    private Map<Integer, List<Integer>> graph;

    private boolean[] seen;

    private Set<String> tracked;

    public int minReorder(int n, int[][] connections) {
        graph = buildGraph(connections);
        seen = new boolean[n];
        tracked = new HashSet<>(n);
        return dfs(0);
    }

    private Map<Integer, List<Integer>> buildGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            graph.putIfAbsent(start, new ArrayList<>());
            graph.get(start).add(end);
            graph.putIfAbsent(end, new ArrayList<>());
            graph.get(end).add(start);
            tracked.add(hash(edge[0], edge[1]));
        }

        return graph;
    }

    private int dfs(int start) {
        int answer = 0;

        seen[start] = true;

        for (int end : graph.get(start)) {
            if (seen[end]) {
                continue;
            }

            if (tracked.add(hash(start, end))) {
                answer++;
            }

            answer += dfs(end);
        }

        return answer;
    }

    private String hash(int start, int end) {
        return start + "_" + end;
    }

}
