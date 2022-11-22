package com.tingshulien.leetcode.binarytree.binarysearchtree;

import com.tingshulien.leetcode.utility.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/minimum-absolute-difference-in-bst/">530. Minimum Absolute Difference in BST</a>
 * <p>
 * Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.
 */
public class MinimumAbsoluteDifferenceInBST_530 {

    List<Integer> ascending = new ArrayList<>();

    public int getMinimumDifference(TreeNode root) {
        updateAscending(root);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < ascending.size() - 1; i++) {
            minDiff = Math.min(minDiff, ascending.get(i + 1) - ascending.get(i));
        }
        return minDiff;
    }

    private void updateAscending(TreeNode node) {
        if (node == null) {
            return;
        }

        updateAscending(node.left);
        ascending.add(node.val);
        updateAscending(node.right);
    }

}
