package com.tingshulien.leetcode.twopointers;

/**
 * <a href="https://leetcode.com/problems/valid-palindrome-ii/">680. Valid Palindrome II</a>
 *
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 */
public class ValidPalindromeII_680 {

    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        boolean deleted = false;
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else if (!deleted && isPalindrome(s, start + 1, end)) {
                start++;
                deleted = true;
            } else if (!deleted && isPalindrome(s, start, end - 1)) {
                end--;
                deleted = true;
            } else {
                return false;
            }
        }

        return true;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

}
