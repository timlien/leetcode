package com.tingshulien.leetcode.binarytree.depthfirstsearch;

import com.tingshulien.leetcode.utility.TreeNode;

/**
 * <a href="https://leetcode.com/problems/diameter-of-binary-tree/description/">543. Diameter of Binary Tree</a>
 * <p>
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * <p>
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 * <p>
 * The length of a path between two nodes is represented by the number of edges between them.
 */
public class DiameterOfBinaryTree_543 {

    private int diameter;

    public int diameterOfBinaryTree(TreeNode root) {
        length(root);
        return diameter;
    }

    private int length(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftLength = length(node.left);
        int rightLength = length(node.right);

        diameter = Math.max(diameter, leftLength + rightLength);

        return Math.max(leftLength, rightLength) + 1;
    }

}
