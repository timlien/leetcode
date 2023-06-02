package com.tingshulien.leetcode.dynamicprogramming.twodimension;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/">309. Best Time to Buy and Sell Stock with Cooldown</a>
 * <p>
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * Find the maximum profit you can achieve. You may complete as many transactions as you like
 * (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
 * <p>
 * After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStockWithCooldown_309 {

    private int[] prices;

    private int n;

    private int[][] memo;

    public int maxProfit(int[] prices) {
        this.prices = prices;
        this.n = prices.length;
        this.memo = new int[n][2];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(0, 0);
    }

    private int dp(int i, int holding) {
        if (i >= n) {
            return 0;
        }

        if (memo[i][holding] != -1) {
            return memo[i][holding];
        }

        if (holding == 0) {
            memo[i][holding] = Math.max(dp(i + 1, holding), -1 * prices[i] + dp(i + 1, 1));
        } else {
            memo[i][holding] = Math.max(dp(i + 1, holding), prices[i] + dp(i + 2, 0));
        }

        return memo[i][holding];
    }

}
