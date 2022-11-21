package com.tingshulien.leetcode.binarytree.breadthfirstsearch;

import com.tingshulien.leetcode.utility.TreeNode;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/deepest-leaves-sum/description/">1302. Deepest Leaves Sum</a>
 * <p>
 * Given the root of a binary tree, return the sum of values of its deepest leaves.
 */
public class DeepestLeavesSum_1302 {

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        int sum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return sum;
    }

}
