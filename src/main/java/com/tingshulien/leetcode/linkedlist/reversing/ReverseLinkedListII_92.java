package com.tingshulien.leetcode.linkedlist.reversing;

import com.tingshulien.leetcode.utility.ListNode;

/**
 * <a href="https://leetcode.com/problems/reverse-linked-list-ii/">92. Reverse Linked List II</a>
 * <p>
 * Given the head of a singly linked list and two integers left and right where left <= right,
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 */
public class ReverseLinkedListII_92 {

    /**
     * [1,2,3,4,5]
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode sentinel = new ListNode();
        sentinel.next = head;

        int count = right;

        ListNode startPrev = sentinel;
        ListNode start = sentinel;
        ListNode end = sentinel;

        while (count > 0) {
            end = end.next;
            count--;

            if (left > count) {
                startPrev = start;
                start = start.next;
            }
        }

        count = right - left + 1;

        ListNode prev = end.next;
        ListNode current = start;
        while (count > 0) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;

            count--;
        }

        startPrev.next = prev;
        return sentinel.next;
    }

}
