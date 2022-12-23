package com.tingshulien.leetcode.graph.implicit;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/evaluate-division/">399. Evaluate Division</a>
 * <p>
 * You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i].
 * Each Ai or Bi is a string that represents a single variable.
 * <p>
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
 * <p>
 * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
 * <p>
 * Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
 */
public class EvaluateDivision_399 {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);

        double[] answer = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            answer[i] = bfs(query, graph);
        }

        return answer;
    }

    private double bfs(List<String> query, Map<String, Map<String, Double>> graph) {
        String numerator = query.get(0);
        String denominator = query.get(1);

        if (!graph.containsKey(numerator)) {
            return -1.0;
        }

        State root = State.newInstance(numerator, 1);

        Set<State> seen = new HashSet<>();
        seen.add(root);

        Queue<State> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            State state = queue.remove();
            if (state.node.equals(denominator)) {
                return state.value;
            }

            if (!graph.containsKey(state.node)) {
                continue;
            }

            for (Map.Entry<String, Double> entry : graph.get(state.node).entrySet()) {
                String neighborDenominator = entry.getKey();
                Double neighborVal = entry.getValue();
                State neighbor = State.newInstance(neighborDenominator, state.value * neighborVal);

                if (seen.contains(neighbor)) {
                    continue;
                }

                queue.add(neighbor);
                seen.add(neighbor);
            }
        }

        return -1.0;
    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        int size = values.length;
        for (int i = 0; i < size; i++) {
            String numerator = equations.get(i).get(0);
            String denominator = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(numerator, new HashMap<>());
            graph.get(numerator).put(denominator, value);

            graph.putIfAbsent(denominator, new HashMap<>());
            graph.get(denominator).put(numerator, 1 / value);
        }

        return graph;
    }

    private static class State {

        private String node;

        private double value;

        private static State newInstance(String node, double value) {
            State state = new State();
            state.node = node;
            state.value = value;
            return state;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            State state = (State) o;
            return Objects.equals(node, state.node);
        }

        @Override
        public int hashCode() {
            return Objects.hash(node);
        }

        @Override
        public String toString() {
            return "State{" +
                    "node='" + node + '\'' +
                    ", value=" + value +
                    '}';
        }

    }

}
