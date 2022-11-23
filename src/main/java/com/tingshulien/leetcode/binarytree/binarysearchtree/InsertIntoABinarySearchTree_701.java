package com.tingshulien.leetcode.binarytree.binarysearchtree;

import com.tingshulien.leetcode.utility.TreeNode;

/**
 * <a href="https://leetcode.com/problems/insert-into-a-binary-search-tree/description/">701. Insert into a Binary Search Tree</a>
 * <p>
 * You are given the root node of a binary search tree (BST) and a value to insert into the tree.
 * Return the root node of the BST after the insertion.
 * It is guaranteed that the new value does not exist in the original BST.
 * <p>
 * Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
 */
public class InsertIntoABinarySearchTree_701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }

}
