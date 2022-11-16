package com.tingshulien.leetcode.binarytree.depthfirstsearch;

import com.tingshulien.leetcode.utility.TreeNode;

/**
 * <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/description/">104. Maximum Depth of Binary Tree</a>
 * <p>
 * Given the root of a binary tree, return its maximum depth.
 * <p>
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaximumDepthOfBinaryTree_104 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
