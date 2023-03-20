package com.tingshulien.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/all-paths-from-source-to-target/description/">797. All Paths From Source to Target</a>
 * <p>
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.
 * <p>
 * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 */
public class AllPathsFromSourceToTarget_797 {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> current = new ArrayList<>();
        current.add(0);
        List<List<Integer>> answer = new ArrayList<>();
        backtracking(current, graph, 0, answer, graph.length);
        return answer;
    }

    private void backtracking(List<Integer> current, int[][] graph, int node, List<List<Integer>> answer, int length) {
        if (node == length - 1) {
            answer.add(new ArrayList<>(current));
            return;
        }

        for (int i : graph[node]) {
            current.add(graph[node][i]);
            backtracking(current, graph, graph[node][i], answer, length);
            current.remove(current.size() - 1);
        }
    }

}
