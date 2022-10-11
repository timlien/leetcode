package com.tingshulien.leetcode.linkedlist;

import com.tingshulien.leetcode.utility.ListNode;

/**
 * <a href="https://leetcode.com/problems/swap-nodes-in-pairs/">24. Swap Nodes in Pairs</a>
 * <p>
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 */
public class SwapNodesInPairs_24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode left = head;
        ListNode right = head.next;

        head = head.next;

        while (left != null && right != null) {
            ListNode next = right.next;
            left.next = next;
            right.next = left;

            if (prev != null) {
                prev.next = right;
            }

            prev = left;
            left = next;

            if (next != null) {
                right = left.next;
            }
        }

        return head;
    }

}
