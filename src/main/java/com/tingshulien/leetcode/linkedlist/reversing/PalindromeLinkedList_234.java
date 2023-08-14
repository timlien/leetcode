package com.tingshulien.leetcode.linkedlist.reversing;

import com.tingshulien.leetcode.utility.ListNode;

/**
 * <a href="https://leetcode.com/problems/palindrome-linked-list/">234. Palindrome Linked List</a>
 * <p>
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 */
public class PalindromeLinkedList_234 {

    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }

        if (head.next.next == null) {
            return head.val == head.next.val;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode current = fast.next == null ? slow : slow.next;
        ListNode prev = null;
        ListNode next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        while (prev != null) {
            if (prev.val != head.val) {
                return false;
            }

            prev = prev.next;
            head = head.next;
        }

        return true;
    }

}
