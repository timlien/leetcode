package com.tingshulien.leetcode.heap.topk;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/find-k-closest-elements/">658. Find K Closest Elements</a>
 * <p>
 * Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.
 * <p>
 * An integer a is closer to x than an integer b if:
 * <p>
 * |a - x| < |b - x|, or
 * |a - x| == |b - x| and a < b
 */
public class FindKClosestElements_658 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            int x1 = Integer.compare(o1[1], o2[1]) * -1;
            if (x1 == 0) {
                return Integer.compare(o1[0], o2[0]) * -1;
            } else {
                return x1;
            }
        });

        for (int number : arr) {
            int[] distanceByNumber = new int[2];
            distanceByNumber[0] = number;
            distanceByNumber[1] = Math.abs(x - number);

            priorityQueue.add(distanceByNumber);

            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        List<Integer> answer = new ArrayList<>(k);
        while (!priorityQueue.isEmpty()) {
            answer.add(priorityQueue.poll()[0]);
        }

        answer.sort(Integer::compare);
        return answer;
    }

}
