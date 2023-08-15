package com.tingshulien.leetcode.stack.stringproblems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/backspace-string-compare/">844. Backspace String Compare</a>
 * <p>
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
 * <p>
 * Note that after backspacing an empty text, the text will continue empty.
 */
public class BackspaceStringCompare_844 {

    public boolean backspaceCompare(String s, String t) {
        return backspace(s).equals(backspace(t));
    }

    private String backspace(String str) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char character : str.toCharArray()) {
            if (character == '#') {
                if (!deque.isEmpty()) {
                    deque.removeLast();
                }
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
