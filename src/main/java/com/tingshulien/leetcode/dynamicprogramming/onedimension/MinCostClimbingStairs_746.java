package com.tingshulien.leetcode.dynamicprogramming.onedimension;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/min-cost-climbing-stairs/description/">746. Min Cost Climbing Stairs</a>
 * <p>
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
 * <p>
 * You can either start from the step with index 0, or the step with index 1.
 * <p>
 * Return the minimum cost to reach the top of the floor.
 */
public class MinCostClimbingStairs_746 {

    private Map<Integer, Integer> costByIndex;

    private int[] cost;

    public int minCostClimbingStairs(int[] cost) {
        this.costByIndex = new HashMap<>();
        this.cost = cost;

        return dp(cost.length);
    }

    private int dp(int index) {
        if (index <= 1) {
            return 0;
        }

        if (!costByIndex.containsKey(index)) {
            costByIndex.put(index, Math.min(dp(index - 1) + cost[index - 1], dp(index - 2) + cost[index - 2]));
        }

        return costByIndex.get(index);
    }

}
