package com.tingshulien.leetcode.dynamicprogramming.twodimension;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/">188. Best Time to Buy and Sell Stock IV</a>
 * <p>
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
 * <p>
 * Find the maximum profit you can achieve.
 * You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.
 * <p>
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStockIV_188 {

    private int days;

    private int[] prices;

    private int[][][] profits;

    public int maxProfit(int k, int[] prices) {
        this.days = prices.length;
        this.prices = prices;
        this.profits = new int[days][2][k];
        for (int[][] table : this.profits) {
            for (int[] row : table) {
                Arrays.fill(row, -1);
            }
        }

        return dp(0, false, k);
    }

    private int dp(int index, boolean holding, int remain) {
        if (index >= days || remain <= 0) {
            return 0;
        }

        int cache = this.profits[index][holding ? 1 : 0][remain - 1];
        if (cache != -1) {
            return cache;
        }

        int profit;
        if (!holding) {
            profit = Math.max(
                    -1 * prices[index] + dp(index + 1, true, remain),
                    dp(index + 1, false, remain)
            );
        } else {
            profit = Math.max(
                    prices[index] + dp(index + 1, false, remain - 1),
                    dp(index + 1, true, remain)
            );
        }

        this.profits[index][holding ? 1 : 0][remain - 1] = profit;
        return profit;
    }

}
