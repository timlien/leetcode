package com.tingshulien.leetcode.heap;

import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/kth-largest-element-in-a-stream/description/">703. Kth Largest Element in a Stream</a>
 * <p>
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Implement KthLargest class:
 * <p>
 * KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
 * int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.
 */
public class KthLargestElementInAStream_703 {

    private int k;

    private PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    public KthLargestElementInAStream_703(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            priorityQueue.add(num);
        }
    }

    public int add(int val) {
        priorityQueue.add(val);

        while (priorityQueue.size() > 3) {
            priorityQueue.poll();
        }

        return priorityQueue.peek();
    }

}
