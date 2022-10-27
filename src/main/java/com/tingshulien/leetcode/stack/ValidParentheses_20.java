package com.tingshulien.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/valid-parentheses/">20. Valid Parentheses</a>
 * <p>
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 */
public class ValidParentheses_20 {

    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char character : s.toCharArray()) {
            if (isOpenBracket(character)) {
                deque.addLast(character);
            } else {
                if (deque.isEmpty()) {
                    return false;
                }

                char open = deque.removeLast();
                if (!isPairedBracket(open, character)) {
                    return false;
                }
            }
        }

        return deque.isEmpty();
    }

    private boolean isOpenBracket(char character) {
        return character == '(' || character == '{' || character == '[';
    }

    private boolean isPairedBracket(char open, char close) {
        StringBuilder builder = new StringBuilder();
        builder.append(open);
        builder.append(close);
        return builder.toString().equals("()") || builder.toString().equals("{}") || builder.toString().equals("[]");
    }

}
