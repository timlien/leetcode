package com.tingshulien.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/subsets/">78. Subsets</a>
 * <p>
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 */
public class Subsets_78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        backtracking(current, 0, answer, nums);
        return answer;
    }

    private void backtracking(List<Integer> current, int level, List<List<Integer>> answer, int[] nums) {
        if (level > nums.length) {
            return;
        }

        answer.add(new ArrayList<>(current));

        for (int i = level; i < nums.length; i++) {
            current.add(nums[i]);
            backtracking(current, i + 1, answer, nums);
            current.remove(current.size() - 1);
        }
    }

}
