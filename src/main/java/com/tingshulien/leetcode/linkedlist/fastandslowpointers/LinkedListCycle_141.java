package com.tingshulien.leetcode.linkedlist.fastandslowpointers;

import com.tingshulien.leetcode.utility.ListNode;

/**
 * <a href="https://leetcode.com/problems/linked-list-cycle/">141. Linked List Cycle</a>
 * <p>
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * <p>
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
 * Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 * <p>
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 */
public class LinkedListCycle_141 {

    public boolean hasCycle(ListNode head) {
        ListNode sentinel = new ListNode();
        sentinel.next = head;

        ListNode slow = sentinel;
        ListNode fast = sentinel;

        do {
            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);

        return true;
    }

}
