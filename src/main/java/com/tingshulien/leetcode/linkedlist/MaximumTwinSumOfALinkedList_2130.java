package com.tingshulien.leetcode.linkedlist;

import com.tingshulien.leetcode.utility.ListNode;

/**
 * <a href="https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/">2130. Maximum Twin Sum of a Linked List</a>
 * <p>
 * In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node,
 * if 0 <= i <= (n / 2) - 1.
 * <p>
 * For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
 * The twin sum is defined as the sum of a node and its twin.
 * <p>
 * Given the head of a linked list with even length, return the maximum twin sum of the linked list.
 */
public class MaximumTwinSumOfALinkedList_2130 {

    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode current = slow.next;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        slow.next = prev;
        ListNode left = head;
        ListNode right = slow.next;

        int maxSum = 0;
        while (right != null) {
            maxSum = Math.max(maxSum, left.val + right.val);
            left = left.next;
            right = right.next;
        }

        return maxSum;
    }

}
