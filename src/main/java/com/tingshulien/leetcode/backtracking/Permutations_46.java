package com.tingshulien.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/permutations/">46. Permutations</a>
 *
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 */
public class Permutations_46 {

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        backtracking(current, answer, nums);
        return answer;
    }

    private void backtracking(List<Integer> current, List<List<Integer>> answer, int[] nums) {
        if (current.size() == nums.length) {
            answer.add(new ArrayList<>(current));
            return;
        }

        for (int num : nums) {
            if (current.contains(num)) {
                continue;
            }

            current.add(num);
            backtracking(current, answer, nums);
            current.remove(current.size() - 1);
        }
    }

}
