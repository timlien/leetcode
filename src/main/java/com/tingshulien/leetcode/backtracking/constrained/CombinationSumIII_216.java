package com.tingshulien.leetcode.backtracking.constrained;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/combination-sum-iii/description/">216. Combination Sum III</a>
 * <p>
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
 * <p>
 * Only numbers 1 through 9 are used.
 * Each number is used at most once.
 * Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
 */
public class CombinationSumIII_216 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtracking(answer, current, 0, k, n);
        return answer;
    }

    private void backtracking(List<List<Integer>> answer, List<Integer> current, int floor, int count, int sum) {
        if (current.size() == count) {
            final int currentSum = current.stream().mapToInt(e -> e).sum();
            if (currentSum == sum) {
                answer.add(new ArrayList<>(current));
            }

            return;
        }

        if (floor == 9) {
            return;
        }

        for (int i = floor + 1; i <= 9; i++) {
            current.add(i);
            backtracking(answer, current, i, count, sum);
            current.remove(current.size() - 1);
        }
    }

}
