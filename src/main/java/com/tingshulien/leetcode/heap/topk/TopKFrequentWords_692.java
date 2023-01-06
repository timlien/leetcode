package com.tingshulien.leetcode.heap.topk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/top-k-frequent-words/description/">692. Top K Frequent Words</a>
 * <p>
 * Given an array of strings words and an integer k, return the k most frequent strings.
 * <p>
 * Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.
 */
public class TopKFrequentWords_692 {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.merge(word, 1, Integer::sum);
        }

        PriorityQueue<String> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            int frequency = Integer.compare(count.get(o1), count.get(o2));
            if (frequency == 0) {
                return String.CASE_INSENSITIVE_ORDER.compare(o1, o2) * -1;
            } else {
                return frequency;
            }
        });

        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            priorityQueue.offer(entry.getKey());

            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        List<String> result = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            result.add(priorityQueue.poll());
        }

        Collections.reverse(result);
        return result;
    }

}
