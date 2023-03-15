package com.tingshulien.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/combinations/">77. Combinations</a>
 * <p>
 * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 * You may return the answer in any order.
 */
public class Combinations_77 {

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        backtracking(current, 1, answer, n, k);
        return answer;
    }

    private void backtracking(List<Integer> current, int index, List<List<Integer>> answer, int n, int k) {
        if (current.size() == k) {
            answer.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i <= n; i++) {
            current.add(i);
            backtracking(current, i + 1, answer, n, k);
            current.remove(current.size() - 1);
        }
    }

}
