package com.tingshulien.leetcode.dynamicprogramming.onedimension;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/climbing-stairs/description/">70. Climbing Stairs</a>
 * <p>
 * You are climbing a staircase. It takes n steps to reach the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs_70 {

    private Map<Integer, Integer> countBySteps = new HashMap<>();

    public int climbStairs(int n) {
        return dp(0, n);
    }

    private int dp(int i, int n) {
        if (i >= n - 1) {
            return 1;
        }

        if (!countBySteps.containsKey(i)) {
            countBySteps.put(i, dp(i + 1, n) + dp(i + 2, n));
        }

        return countBySteps.get(i);
    }

}
