package com.tingshulien.leetcode.binarytree.binarysearchtree;

import com.tingshulien.leetcode.utility.TreeNode;

/**
 * <a href="https://leetcode.com/problems/validate-binary-search-tree/description/">98. Validate Binary Search Tree</a>
 * <p>
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * A valid BST is defined as follows:
 * <p>
 * The left
 * subtree
 * of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBinarySearchTree_98 {

    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }

        if (node.val <= min || node.val >= max) {
            return false;
        }

        return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
    }

}
