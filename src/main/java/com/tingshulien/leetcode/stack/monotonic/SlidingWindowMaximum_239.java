package com.tingshulien.leetcode.stack.monotonic;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/sliding-window-maximum/">239. Sliding Window Maximum</a>
 * <p>
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * <p>
 * Return the max sliding window.
 */
public class SlidingWindowMaximum_239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] answer = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.removeLast();
            }

            while (!deque.isEmpty() && deque.getFirst() < i - k + 1) {
                deque.removeFirst();
            }

            deque.addLast(i);

            if (i >= k - 1) {
                answer[i - k + 1] = nums[deque.getFirst()];
            }
        }

        return answer;
    }

}
