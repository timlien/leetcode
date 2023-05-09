package com.tingshulien.leetcode.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/coin-change/description/">322. Coin Change</a>
 * <p>
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * <p>
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange_322 {

    private Map<Integer, Integer> countByAmount = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        int count = dp(amount, coins);
        return count == Integer.MAX_VALUE ? -1 : count;
    }

    private int dp(int amount, int[] coins) {
        if (amount == 0) {
            return 0;
        }

        if (countByAmount.containsKey(amount)) {
            return countByAmount.get(amount);
        }

        int minCount = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount < coin) {
                continue;
            }

            int count = dp(amount - coin, coins);
            minCount = Math.min(minCount, count == Integer.MAX_VALUE ? Integer.MAX_VALUE : count + 1);
        }

        countByAmount.put(amount, minCount);

        return minCount;
    }

}
