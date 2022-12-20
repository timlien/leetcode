package com.tingshulien.leetcode.graph.breadthfirstsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/shortest-path-with-alternating-colors/">1129. Shortest Path with Alternating Colors</a>
 * <p>
 * You are given an integer n, the number of nodes in a directed graph where the nodes are labeled from 0 to n - 1.
 * Each edge is red or blue in this graph, and there could be self-edges and parallel edges.
 * <p>
 * You are given two arrays redEdges and blueEdges where:
 * <p>
 * redEdges[i] = [ai, bi] indicates that there is a directed red edge from node ai to node bi in the graph, and
 * blueEdges[j] = [uj, vj] indicates that there is a directed blue edge from node uj to node vj in the graph.
 * Return an array answer of length n, where each answer[x] is the length of the shortest path from node 0 to node x
 * such that the edge colors alternate along the path, or -1 if such a path does not exist.
 */
public class ShortestPathWithAlternatingColors_1129 {

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int RED = 0;
        int BLUE = 1;

        Map<Integer, Map<Integer, List<Integer>>> graph = new HashMap<>();
        graph.put(RED, new HashMap<>());
        graph.put(BLUE, new HashMap<>());

        addGraph(graph.get(RED), redEdges, n);
        addGraph(graph.get(BLUE), blueEdges, n);

        Node red = Node.newInstance(0, RED, 0);
        Node blue = Node.newInstance(0, BLUE, 0);

        boolean[][] seen = new boolean[n][2];
        seen[0][RED] = true;
        seen[0][BLUE] = true;

        Queue<Node> queue = new LinkedList<>();
        queue.add(red);
        queue.add(blue);

        int[] answer = new int[n];
        Arrays.fill(answer, Integer.MAX_VALUE);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node node = queue.remove();
                int num = node.num;
                int color = node.color;
                int step = node.step;

                answer[num] = Math.min(answer[num], step);

                for (int neighborNum : graph.get(1 - color).get(num)) {
                    Node neighbor = Node.newInstance(neighborNum, 1 - color, step + 1);
                    if (seen[neighbor.num][neighbor.color]) {
                        continue;
                    }

                    queue.add(neighbor);
                    seen[neighbor.num][neighbor.color] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (answer[i] == Integer.MAX_VALUE) {
                answer[i] = -1;
            }
        }

        return answer;
    }

    private void addGraph(Map<Integer, List<Integer>> graph, int[][] edges, int size) {
        for (int i = 0; i < size; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
    }

    private static class Node {
        int num;
        int color;
        int step;

        private static Node newInstance(int num, int color, int step) {
            Node node = new Node();
            node.num = num;
            node.color = color;
            node.step = step;
            return node;
        }
    }

}
