package com.tingshulien.leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/remove-stones-to-minimize-the-total/description/">1962. Remove Stones to Minimize the Total</a>
 * <p>
 * You are given a 0-indexed integer array piles, where piles[i] represents the number of stones in the ith pile, and an integer k.
 * You should apply the following operation exactly k times:
 * <p>
 * Choose any piles[i] and remove floor(piles[i] / 2) stones from it.
 * Notice that you can apply the operation on the same pile more than once.
 * <p>
 * Return the minimum possible total number of stones remaining after applying the k operations.
 * <p>
 * floor(x) is the greatest integer that is smaller than or equal to x (i.e., rounds x down).
 */
public class RemoveStonesToMinimizeTheTotal_1962 {

    public int minStoneSum(int[] piles, int k) {
        int sum = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int pile : piles) {
            sum += pile;
            priorityQueue.add(pile);
        }

        for (int i = 0; i < k; i++) {
            int maxPile = priorityQueue.poll();
            int roundedPile = Math.round(maxPile / 2f);
            sum -= (maxPile - roundedPile);
            priorityQueue.add(roundedPile);
        }

        return sum;
    }

}
