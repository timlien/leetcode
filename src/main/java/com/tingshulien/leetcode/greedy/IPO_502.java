package com.tingshulien.leetcode.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/ipo/">502. IPO</a>
 * <p>
 * Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital,
 * LeetCode would like to work on some projects to increase its capital before the IPO. Since it has limited resources,
 * it can only finish at most k distinct projects before the IPO.
 * Help LeetCode design the best way to maximize its total capital after finishing at most k distinct projects.
 * <p>
 * You are given n projects where the ith project has a pure profit profits[i] and a minimum capital of capital[i] is needed to start it.
 * <p>
 * Initially, you have w capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.
 * <p>
 * Pick a list of at most k distinct projects from given projects to maximize your final capital, and return the final maximized capital.
 * <p>
 * The answer is guaranteed to fit in a 32-bit signed integer.
 */
public class IPO_502 {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<Project> projects = new ArrayList<>();

        int length = profits.length;
        for (int i = 0; i < length; i++) {
            projects.add(Project.newInstance(profits[i], capital[i]));
        }

        projects.sort((o1, o2) -> {
            int cost = Integer.compare(o1.capital, o2.capital);
            if (cost != 0) {
                return cost;
            } else {
                return Integer.compare(o1.profit, o2.profit) * -1;
            }
        });

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        int index = 0;
        for (int i = 0; i < k; i++) {
            while (index < length && projects.get(index).capital <= w) {
                priorityQueue.add(projects.get(index).profit);
                index++;
            }

            if (priorityQueue.isEmpty()) {
                return w;
            }

            w += priorityQueue.remove();
        }

        return w;
    }

    private static class Project {

        private int profit;

        private int capital;

        private static Project newInstance(int profit, int capital) {
            Project project = new Project();
            project.profit = profit;
            project.capital = capital;
            return project;
        }

    }

}
