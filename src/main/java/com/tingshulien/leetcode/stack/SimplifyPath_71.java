package com.tingshulien.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/simplify-path/">71. Simplify Path</a>
 * <p>
 * Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system,
 * convert it to the simplified canonical path.
 * <p>
 * In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level,
 * and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'.
 * For this problem, any other format of periods such as '...' are treated as file/directory names.
 */
public class SimplifyPath_71 {

    public String simplifyPath(String path) {
        String[] words = path.split("/");
        Deque<String> deque = new ArrayDeque<>();
        for (String word : words) {
            if (word.isEmpty() || word.equals(".")) {
                continue;
            } else if (word.equals("..")) {
                if (!deque.isEmpty()) {
                    deque.removeLast();
                }
            } else {
                deque.addLast(word);
            }
        }

        StringBuilder builder = new StringBuilder();
        if (deque.isEmpty()) {
            return "/";
        }

        for (String word : deque) {
            builder.append("/");
            builder.append(word);
        }

        return builder.toString();
    }

}
