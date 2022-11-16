package com.tingshulien.leetcode.binarytree.breadthfirstsearch;

import com.tingshulien.leetcode.utility.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/binary-tree-right-side-view/description/">199. Binary Tree Right Side View</a>
 * <p>
 * Given the root of a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 */
public class BinaryTreeRightSideView_199 {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> rightSide = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            TreeNode previous = null;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                previous = node;

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            rightSide.add(previous.val);
        }

        return rightSide;
    }

}
