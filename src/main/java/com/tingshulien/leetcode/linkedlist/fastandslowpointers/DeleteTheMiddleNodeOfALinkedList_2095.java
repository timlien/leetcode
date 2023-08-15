package com.tingshulien.leetcode.linkedlist.fastandslowpointers;

import com.tingshulien.leetcode.utility.ListNode;

/**
 * <a href="https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/submissions/">2095. Delete the Middle Node of a Linked List</a>
 * <p>
 * You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.
 * <p>
 * The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing,
 * where ⌊x⌋ denotes the largest integer less than or equal to x.
 */
public class DeleteTheMiddleNodeOfALinkedList_2095 {

    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }

        final ListNode sentinel = new ListNode();
        sentinel.next = head;

        ListNode slow = sentinel;
        ListNode fast = sentinel;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;

        return head;
    }

}
