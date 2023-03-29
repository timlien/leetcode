package com.tingshulien.leetcode.backtracking.constrained;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/combination-sum/">39. Combination Sum</a>
 * <p>
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen numbers sum to target.
 * You may return the combinations in any order.
 * <p>
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
 * frequency
 * of at least one of the chosen numbers is different.
 * <p>
 * The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 */
public class CombinationSum_39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        backtracking(current, 0, 0, answer, candidates, target);
        return answer;
    }

    private void backtracking(List<Integer> current, int index , int sum, List<List<Integer>> answer, int[] candidates, int target) {
        if (sum == target) {
            answer.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                continue;
            }

            current.add(candidates[i]);
            backtracking(current, i, sum + candidates[i], answer, candidates, target);
            current.remove(current.size() - 1);
        }
    }

}
