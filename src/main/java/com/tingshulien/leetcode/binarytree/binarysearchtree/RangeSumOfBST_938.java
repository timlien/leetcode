package com.tingshulien.leetcode.binarytree.binarysearchtree;

import com.tingshulien.leetcode.utility.TreeNode;

/**
 * <a href="https://leetcode.com/problems/range-sum-of-bst/">938. Range Sum of BST</a>
 * <p>
 * Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].
 */
public class RangeSumOfBST_938 {

    public int rangeSumBST(TreeNode root, int low, int high) {
        int ans = 0;

        if (root == null) {
            return ans;
        }

        if (root.val >= low && root.val <= high) {
            ans += root.val;
        }

        if (root.val > low) {
            ans += rangeSumBST(root.left, low, high);
        }

        if (root.val < high) {
            ans += rangeSumBST(root.right, low, high);
        }

        return ans;
    }

}
