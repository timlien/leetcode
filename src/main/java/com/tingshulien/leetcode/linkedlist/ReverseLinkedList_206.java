package com.tingshulien.leetcode.linkedlist;

import com.tingshulien.leetcode.utility.ListNode;

/**
 * <a href="https://leetcode.com/problems/reverse-linked-list/">https://leetcode.com/problems/reverse-linked-list/</a>
 *
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class ReverseLinkedList_206 {

    public ListNode iterativeReverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        ListNode temp;
        while (current != null) {
            temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }

        return previous;
    }

    public ListNode recursiveReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        final ListNode node = recursiveReverseList(head.next);
        node.next.next = head;
        node.next = null;
        return node;
    }

}
