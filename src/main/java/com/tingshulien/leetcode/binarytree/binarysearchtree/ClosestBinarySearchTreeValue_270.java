package com.tingshulien.leetcode.binarytree.binarysearchtree;

import com.tingshulien.leetcode.utility.TreeNode;

/**
 * <a href="https://leetcode.com/problems/closest-binary-search-tree-value/description/">270. Closest Binary Search Tree Value</a>
 * <p>
 * Given the root of a binary search tree and a target value, return the value in the BST that is closest to the target.
 */
public class ClosestBinarySearchTreeValue_270 {

    private double minDifference = Double.MAX_VALUE;

    private int closestValue;

    public int closestValue(TreeNode root, double target) {
        find(root, target);
        return closestValue;
    }

    private void find(TreeNode node, double target) {
        if (node == null) {
            return;
        }

        double difference = Math.abs(node.val - target);
        if (difference < minDifference) {
            closestValue = node.val;
            minDifference = difference;
        }

        if (node.left != null && target - node.val < 0) {
            find(node.left, target);
        }

        if (node.right != null && target - node.val > 0) {
            find(node.right, target);
        }
    }

}
