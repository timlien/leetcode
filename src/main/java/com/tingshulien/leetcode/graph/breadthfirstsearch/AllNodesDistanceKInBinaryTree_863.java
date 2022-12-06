package com.tingshulien.leetcode.graph.breadthfirstsearch;

import com.tingshulien.leetcode.utility.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/">863. All Nodes Distance K in Binary Tree</a>
 * <p>
 * Given the root of a binary tree, the value of a target node target, and an integer k,
 * return an array of the values of all nodes that have a distance k from the target node.
 * <p>
 * You can return the answer in any order.
 */
public class AllNodesDistanceKInBinaryTree_863 {

    private Map<Integer, List<Integer>> graph;

    private Set<Integer> seen;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (k == 0) {
            return List.of(target.val);
        }

        graph = new HashMap<>();
        buildGraph(root, null);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(target.val);

        seen = new HashSet<>();
        seen.add(target.val);

        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;

            for (int i = 0; i < size; i++) {
                int node = queue.remove();
                for (int neighbor : graph.get(node)) {
                    if (seen.contains(neighbor)) {
                        continue;
                    }

                    seen.add(neighbor);
                    queue.add(neighbor);
                }
            }

            if (count == k) {
                return new ArrayList<>(queue);
            }
        }

        return Collections.emptyList();
    }


    private void buildGraph(TreeNode node, TreeNode parent) {
        if (node == null) {
            return;
        }

        graph.putIfAbsent(node.val, new ArrayList<>());

        if (parent != null) {
            graph.putIfAbsent(parent.val, new ArrayList<>());
            graph.get(node.val).add(parent.val);
            graph.get(parent.val).add(node.val);
        }

        buildGraph(node.left, node);
        buildGraph(node.right, node);
    }

}
