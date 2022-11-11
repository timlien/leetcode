package com.tingshulien.leetcode.binarytree;

import com.tingshulien.leetcode.utility.TreeNode;

/**
 * <a href="https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/">1448. Count Good Nodes in Binary Tree</a>
 * <p>
 * Given a binary tree root, a node X in the tree is named good
 * if in the path from root to X there are no nodes with a value greater than X.
 * <p>
 * Return the number of good nodes in the binary tree.
 */
public class CountGoodNodesInBinaryTree_1448 {

    public int goodNodes(TreeNode root) {
        return count(root, Integer.MIN_VALUE);
    }

    private int count(TreeNode node, int max) {
        if (node == null) {
            return 0;
        }

        int increment = node.val >= max ? 1 : 0;
        max = Math.max(node.val, max);
        return count(node.left, max) + count(node.right, max) + increment;
    }

}
