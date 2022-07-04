package com.tingshulien.leetcode.twopointers;

/**
 * <a href="https://leetcode.com/problems/sum-of-square-numbers/">633. Sum of Square Numbers</a>
 *
 * Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.
 */
public class SumOfSquareNumbers_633 {

    public boolean judgeSquareSum(int c) {
        long powMax = (int) Math.sqrt(c);
        long i = 0;
        long j = powMax;
        while (i <= j) {
            long sum = i * i + j * j;
            if (sum == c) {
                return true;
            } else if (c > sum) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

}
