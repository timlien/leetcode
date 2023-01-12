package com.tingshulien.leetcode.greedy;

/**
 * <a href="https://leetcode.com/problems/maximum-69-number/description/">1323. Maximum 69 Number</a>
 * <p>
 * You are given a positive integer num consisting only of digits 6 and 9.
 * <p>
 * Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).
 */
public class Maximum69Number_1323 {

    public int maximum69Number(int num) {
        String str = Integer.toString(num);
        char[] numbers = str.toCharArray();

        boolean changed = false;
        for (int i = 0; i < numbers.length; i++) {
            if (!changed && numbers[i] == '6') {
                numbers[i] = '9';
                changed = true;
            }
        }

        return Integer.parseInt(String.valueOf(numbers));
    }

}
