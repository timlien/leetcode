package com.tingshulien.leetcode.dynamicprogramming.twodimension;

import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/maximum-value-of-k-coins-from-piles/">2218. Maximum Value of K Coins From Piles</a>
 * <p>
 * There are n piles of coins on a table. Each pile consists of a positive number of coins of assorted denominations.
 * <p>
 * In one move, you can choose any coin on top of any pile, remove it, and add it to your wallet.
 * <p>
 * Given a list piles, where piles[i] is a list of integers denoting the composition of the ith pile from top to bottom, and a positive integer k,
 * return the maximum total value of coins you can have in your wallet if you choose exactly k coins optimally.
 */
public class MaximumValueOfKCoinsFromPiles_2218 {

    private List<List<Integer>> piles;

    private int size;

    private int[][] memo;

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        this.piles = piles;
        this.size = piles.size();
        this.memo = new int[size][k + 1];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(0, k);
    }

    private int dp(int i, int remain) {
        if (i == size || remain == 0) {
            return 0;
        }

        int maxValue = memo[i][remain];
        if (maxValue != -1) {
            return maxValue;
        }

        int answer = dp(i + 1, remain);
        int current = 0;
        int size = Math.min(remain, piles.get(i).size());
        for (int j = 0; j < size; j++) {
            current += piles.get(i).get(j);
            answer = Math.max(answer, current + dp(i + 1, remain - j - 1));
        }

        memo[i][remain] = answer;
        return answer;
    }

}
