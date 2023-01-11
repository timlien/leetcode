package com.tingshulien.leetcode.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/">1481. Least Number of Unique Integers after K Removals</a>
 * <p>
 * Given an array of integers arr and an integer k. Find the least number of unique integers after removing exactly k elements.
 */
public class LeastNumberOfUniqueIntegersAfterKRemovals_1481 {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        if (k > arr.length) {
            return 0;
        }

        Map<Integer, Integer> count = new HashMap<>();
        for (int number : arr) {
            count.merge(number, 1, Integer::sum);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(count.values());

        while (k > 0) {
            int frequency = heap.poll();
            k -= frequency;

            if (k < 0) {
                heap.add(-1 * k);
            }
        }

        return heap.size();
    }

}
