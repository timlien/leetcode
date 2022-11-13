package com.tingshulien.leetcode.binarytree;

import com.tingshulien.leetcode.utility.TreeNode;

/**
 * <a href="https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/description/">1026. Maximum Difference Between Node and Ancestor</a>
 * <p>
 * Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b where v = |a.val - b.val| and a is an ancestor of b.
 * <p>
 * A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.
 */
public class MaximumDifferenceBetweenNodeAndAncestor_1026 {

    public int maxAncestorDiff(TreeNode root) {
        return difference(root, root.val, root.val);
    }

    private int difference(TreeNode node, int min, int max) {
        if (node == null) {
            return max - min;
        }

        min = Math.min(node.val, min);
        max = Math.max(node.val, max);

        return Math.max(difference(node.left, min, max), difference(node.right, min, max));
    }

}
