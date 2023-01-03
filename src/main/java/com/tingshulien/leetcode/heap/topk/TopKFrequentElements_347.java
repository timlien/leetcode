package com.tingshulien.leetcode.heap.topk;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/top-k-frequent-elements/description/">347. Top K Frequent Elements</a>
 * <p>
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 */
public class TopKFrequentElements_347 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.merge(num, 1, Integer::sum);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            priorityQueue.add(entry);

            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        int[] answer = new int[k];
        for (int i = 0; i < k; i++) {
            answer[i] = priorityQueue.poll().getKey();
        }

        return answer;
    }

}
