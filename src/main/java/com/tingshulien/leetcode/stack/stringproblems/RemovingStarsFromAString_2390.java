package com.tingshulien.leetcode.stack.stringproblems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/removing-stars-from-a-string/">2390. Removing Stars From a String</a>
 * <p>
 * You are given a string s, which contains stars *.
 * <p>
 * In one operation, you can:
 * <p>
 * Choose a star in s.
 * Remove the closest non-star character to its left, as well as remove the star itself.
 * Return the string after all stars have been removed.
 * <p>
 * Note:
 * <p>
 * The input will be generated such that the operation is always possible.
 * It can be shown that the resulting string will always be unique.
 */
public class RemovingStarsFromAString_2390 {

    public String removeStars(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char character : s.toCharArray()) {
            if (character == '*') {
                if (!deque.isEmpty()) {
                    deque.removeLast();
                }
            } else {
                deque.addLast(character);
            }
        }

        StringBuilder builder = new StringBuilder();
        for (Character character : deque) {
            builder.append(character);
        }

        return builder.toString();
    }

}
