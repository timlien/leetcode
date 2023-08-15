package com.tingshulien.leetcode.stack.stringproblems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/">1047. Remove All Adjacent Duplicates In String</a>
 * <p>
 * You are given a string s consisting of lowercase English letters.
 * A duplicate removal consists of choosing two adjacent and equal letters and removing them.
 * <p>
 * We repeatedly make duplicate removals on s until we no longer can.
 * <p>
 * Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.
 */
public class RemoveAllAdjacentDuplicatesInString_1047 {

    public String removeDuplicates(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char character : s.toCharArray()) {
            if (!deque.isEmpty() && deque.getLast() == character) {
                deque.removeLast();
            } else {
                deque.addLast(character);
            }
        }

        StringBuilder builder = new StringBuilder();
        for (char character : deque) {
            builder.append(character);
        }

        return builder.toString();
    }

}
