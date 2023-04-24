package com.tingshulien.leetcode.backtracking.constrained;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/numbers-with-same-consecutive-differences/description/">967. Numbers With Same Consecutive Differences</a>
 * <p>
 * Given two integers n and k, return an array of all the integers of length n where the difference between every two consecutive digits is k.
 * You may return the answer in any order.
 * <p>
 * Note that the integers should not have leading zeros. Integers as 02 and 043 are not allowed.
 */
public class NumbersWithSameConsecutiveDifferences_967 {

    private int difference;

    public int[] numsSameConsecDiff(int n, int k) {
        this.difference = k;

        List<Integer> answer = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            backtracking(0, i, n, answer);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    private void backtracking(int value, int number, int digit, List<Integer> answer) {
        digit -= 1;

        int increment = (int) (number * Math.pow(10, digit));
        value += increment;

        if (digit == 0) {
            answer.add(value);
            return;
        }

        if (number - difference >= 0) {
            backtracking(value, number - difference, digit, answer);
        }

        if (number + difference <= 9) {
            backtracking(value, number + difference, digit, answer);
        }
    }

}
