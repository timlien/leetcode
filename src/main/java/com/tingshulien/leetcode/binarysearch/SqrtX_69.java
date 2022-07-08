package com.tingshulien.leetcode.binarysearch;

/**
 * <a href="https://leetcode.com/problems/sqrtx/">69. Sqrt(x)</a>
 *
 * Given a non-negative integer x, compute and return the square root of x.
 *
 * Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
 *
 * Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
 */
public class SqrtX_69 {

    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }

        int left = 2;
        int right = x / 2;
        int pivot;
        long number;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            number = (long) pivot * pivot;
            if (number > x) {
                right = pivot - 1;
            } else if (number < x) {
                left = pivot + 1;
            } else {
                return pivot;
            }
        }

        return right;
    }

}
