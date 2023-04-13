package com.tingshulien.leetcode.backtracking.constrained;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/generate-parentheses/description/">22. Generate Parentheses</a>
 * <p>
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
public class GenerateParentheses_22 {

    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        backtracking(0, 0, n, builder, answer);
        return answer;
    }

    private void backtracking(int left, int right, int max, StringBuilder builder, List<String> answer) {
        if (builder.length() == max * 2) {
            answer.add(builder.toString());
            return;
        }

        if (left < max) {
            builder.append("(");
            backtracking(left + 1, right, max, builder, answer);
            builder.deleteCharAt(builder.length() - 1);
        }

        if (right < left) {
            builder.append(")");
            backtracking(left, right + 1, max, builder, answer);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

}
