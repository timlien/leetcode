package com.tingshulien.leetcode.heap;

import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/minimum-cost-to-connect-sticks/description/">1167. Minimum Cost to Connect Sticks</a>
 * <p>
 * You have some number of sticks with positive integer lengths. These lengths are given as an array sticks, where sticks[i] is the length of the ith stick.
 * <p>
 * You can connect any two sticks of lengths x and y into one stick by paying a cost of x + y. You must connect all the sticks until there is only one stick remaining.
 * <p>
 * Return the minimum cost of connecting all the given sticks into one stick in this way.
 */
public class MinimumCostToConnectSticks_1167 {

    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int stick : sticks) {
            priorityQueue.add(stick);
        }

        int cost = 0;
        while (priorityQueue.size() > 1) {
            int x = priorityQueue.poll();
            int y = priorityQueue.poll();
            cost += x + y;
            priorityQueue.add(x + y);
        }

        return cost;
    }

}
