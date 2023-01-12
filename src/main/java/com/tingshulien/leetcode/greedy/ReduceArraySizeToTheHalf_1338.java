package com.tingshulien.leetcode.greedy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/reduce-array-size-to-the-half/description/">1338. Reduce Array Size to The Half</a>
 * <p>
 * You are given an integer array arr. You can choose a set of integers and remove all the occurrences of these integers in the array.
 * <p>
 * Return the minimum size of the set so that at least half of the integers of the array are removed.
 */
public class ReduceArraySizeToTheHalf_1338 {

    public int minSetSize(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : arr) {
            count.merge(num, 1, Integer::sum);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        heap.addAll(count.values());

        int set = 0;
        int size = 0;
        int floor = (int) Math.round(arr.length / 2D);
        while (size < floor) {
            size += heap.remove();
            set++;
        }

        return set;
    }

}
