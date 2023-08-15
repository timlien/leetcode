package com.tingshulien.leetcode.stack.stringproblems;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.com/problems/make-the-string-great/">1544. Make The String Great</a>
 * <p>
 * Given a string s of lower and upper case English letters.
 * <p>
 * A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:
 * <p>
 * 0 <= i <= s.length - 2
 * s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.
 * To make the string good, you can choose two adjacent characters that make the string bad and remove them.
 * You can keep doing this until the string becomes good.
 * <p>
 * Return the string after making it good. The answer is guaranteed to be unique under the given constraints.
 * <p>
 * Notice that an empty string is also good.
 */
public class MakeTheStringGreat_1544 {

    public String makeGood(String s) {
        char[] characters = s.toCharArray();
        Deque<Character> deque = new LinkedList<>();
        for (char character : characters) {
            if (deque.isEmpty()) {
                deque.addLast(character);
                continue;
            }

            char previous = deque.getLast();
            if (Math.abs(character - previous) == 32) {
                deque.removeLast();
                continue;
            }

            deque.addLast(character);
        }

        StringBuilder builder = new StringBuilder();
        for (char character : deque) {
            builder.append(character);
        }

        return builder.toString();
    }

}
