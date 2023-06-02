package com.tingshulien.leetcode.dynamicprogramming.twodimension;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/">714. Best Time to Buy and Sell Stock with Transaction Fee</a>
 * <p>
 * You are given an array prices where prices[i] is the price of a given stock on the ith day,
 * and an integer fee representing a transaction fee.
 * <p>
 * Find the maximum profit you can achieve. You may complete as many transactions as you like,
 * but you need to pay the transaction fee for each transaction.
 * <p>
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStockWithTransactionFee_714 {

    private int[] prices;

    private int fee;

    private int[][] memo;

    private int n;

    public int maxProfit(int[] prices, int fee) {
        this.prices = prices;
        this.fee = fee;
        this.memo = new int[prices.length][2];
        this.n = prices.length;

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(0, 0);
    }

    private int dp(int i, int holding) {
        if (i == n) {
            return 0;
        }

        if (memo[i][holding] != -1) {
            return memo[i][holding];
        }

        if (holding == 0) {
            memo[i][holding] = Math.max(dp(i + 1, holding), -1 * prices[i] + dp(i + 1, 1));
        } else {
            memo[i][holding] = Math.max(dp(i + 1, holding), prices[i] - fee + dp(i + 1, 0));
        }

        return memo[i][holding];
    }

}
