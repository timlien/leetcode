package com.tingshulien.leetcode.stack.monotonic;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.com/problems/daily-temperatures/">739. Daily Temperatures</a>
 * <p>
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 */
public class DailyTemperatures_739 {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!deque.isEmpty()) {
                int index = deque.getLast();
                if (temperatures[index] < temperatures[i]) {
                    answer[index] = i - index;
                    deque.removeLast();
                } else {
                    break;
                }
            }

            deque.addLast(i);
        }

        return answer;
    }

}
