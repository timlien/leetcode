package com.tingshulien.leetcode.graph.implicit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/open-the-lock/">752. Open the Lock</a>
 * <p>
 * You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'.
 * The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.
 * <p>
 * The lock initially starts at '0000', a string representing the state of the 4 wheels.
 * <p>
 * You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.
 * <p>
 * Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.
 */
public class OpenTheLock_752 {

    public int openLock(String[] deadends, String target) {
        Set<String> exclusiveNode = new HashSet<>(List.of(deadends));

        Map<String, List<String>> graph = new HashMap<>(9999);
        for (int i = 0; i <= 9999; i++) {
            String node = toFourDigitString(Integer.toString(i));
            if (exclusiveNode.contains(node)) {
                continue;
            }

            List<String> neighbors = findNeighbor(node);
            neighbors.removeIf(exclusiveNode::contains);

            graph.putIfAbsent(node, new ArrayList<>());
            graph.get(node).addAll(neighbors);

            for (String neighbor : neighbors) {
                graph.putIfAbsent(neighbor, new ArrayList<>());
                graph.get(neighbor).add(node);
            }
        }

        String start = "0000";
        if (exclusiveNode.contains(start)) {
            return -1;
        }

        Set<String> seen = new HashSet<>();
        seen.add(start);

        Queue<String> queue = new LinkedList<>();
        queue.add(start);

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String node = queue.remove();
                if (node.equals(target)) {
                    return step;
                }

                for (String neighbor : graph.get(node)) {
                    if (seen.contains(neighbor)) {
                        continue;
                    }

                    queue.add(neighbor);
                    seen.add(neighbor);
                }
            }

            step++;
        }

        return -1;
    }

    private String toFourDigitString(String value) {
        final int length = 4 - value.length();
        if (length == 0) {
            return value;
        }

        return "0".repeat(Math.max(0, length)) + value;
    }

    private List<String> findNeighbor(String node) {
        char[] lockArray = node.toCharArray();
        List<String> vertex = new ArrayList<>();

        for (int i = 0; i < node.length(); i++) {
            StringBuilder neighbor = new StringBuilder();
            for (int j = 0; j < node.length(); j++) {
                if (i == j) {
                    neighbor.append(increment(lockArray[j]));
                } else {
                    neighbor.append(lockArray[j]);
                }
            }
            vertex.add(neighbor.toString());
        }

        return vertex;
    }

    private char increment(char number) {
        switch (number) {
            case '0' -> {
                return '1';
            }
            case '1' -> {
                return '2';
            }
            case '2' -> {
                return '3';
            }
            case '3' -> {
                return '4';
            }
            case '4' -> {
                return '5';
            }
            case '5' -> {
                return '6';
            }
            case '6' -> {
                return '7';
            }
            case '7' -> {
                return '8';
            }
            case '8' -> {
                return '9';
            }
            case '9' -> {
                return '0';
            }
        }

        throw new IllegalArgumentException();
    }

}
