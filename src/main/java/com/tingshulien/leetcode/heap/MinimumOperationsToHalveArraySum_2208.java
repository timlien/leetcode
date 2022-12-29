package com.tingshulien.leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/minimum-operations-to-halve-array-sum/">2208. Minimum Operations to Halve Array Sum</a>
 * <p>
 * You are given an array nums of positive integers. In one operation, you can choose any number from nums and reduce it to exactly half the number.
 * (Note that you may choose this reduced number in future operations.)
 * <p>
 * Return the minimum number of operations to reduce the sum of nums by at least half.
 */
public class MinimumOperationsToHalveArraySum_2208 {

    public int halveArray(int[] nums) {
        double sum = 0;
        double reduction = 0;
        PriorityQueue<Double> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int num : nums) {
            sum += num;
            priorityQueue.offer((double) num);
        }

        int operations = 0;
        while (reduction < sum / 2) {
            double max = priorityQueue.poll();
            double halved = max / 2;

            reduction += halved;
            priorityQueue.add(halved);

            operations++;
        }

        return operations;
    }

}
