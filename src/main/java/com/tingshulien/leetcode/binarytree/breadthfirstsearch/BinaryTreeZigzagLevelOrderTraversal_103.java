package com.tingshulien.leetcode.binarytree.breadthfirstsearch;

import com.tingshulien.leetcode.utility.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/">103. Binary Tree Zigzag Level Order Traversal</a>
 * <p>
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
 * (i.e., from left to right, then right to left for the next level and alternate between).
 */
public class BinaryTreeZigzagLevelOrderTraversal_103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);

        List<List<Integer>> zigzag = new ArrayList<>();
        boolean leftToRight = true;

        while (!deque.isEmpty()) {
            int size = deque.size();

            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = null;

                if (leftToRight) {
                    node = deque.removeFirst();
                } else {
                    node = deque.removeLast();
                }

                level.add(node.val);

                if (leftToRight) {
                    if (node.left != null) {
                        deque.addLast(node.left);
                    }

                    if (node.right != null) {
                        deque.addLast(node.right);
                    }
                } else {
                    if (node.right != null) {
                        deque.addFirst(node.right);
                    }

                    if (node.left != null) {
                        deque.addFirst(node.left);
                    }
                }
            }

            zigzag.add(level);
            leftToRight = !leftToRight;
        }

        return zigzag;
    }

}
