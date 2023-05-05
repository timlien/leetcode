package com.tingshulien.leetcode.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/solving-questions-with-brainpower/">2140. Solving Questions With Brainpower</a>
 * <p>
 * You are given a 0-indexed 2D integer array questions where questions[i] = [pointsi, brainpoweri].
 * <p>
 * The array describes the questions of an exam, where you have to process the questions in order (i.e., starting from question 0)
 * and make a decision whether to solve or skip each question. Solving question i will earn you pointsi points
 * but you will be unable to solve each of the next brainpoweri questions.
 * If you skip question i, you get to make the decision on the next question.
 * <p>
 * For example, given questions = [[3, 2], [4, 3], [4, 4], [2, 5]]:
 * If question 0 is solved, you will earn 3 points but you will be unable to solve questions 1 and 2.
 * If instead, question 0 is skipped and question 1 is solved, you will earn 4 points but you will be unable to solve questions 2 and 3.
 * Return the maximum points you can earn for the exam.
 */
public class SolvingQuestionsWithBrainpower_2140 {

    private Map<Integer, Long> scoreByIndex = new HashMap<>();

    public long mostPoints(int[][] questions) {
        return dp(0, questions);
    }

    private long dp(int i, int[][] questions) {
        if (i >= questions.length) {
            return 0;
        }

        if (!scoreByIndex.containsKey(i)) {
            scoreByIndex.put(i, Math.max(questions[i][0] + dp(i + questions[i][1] + 1, questions), dp(i + 1, questions)));
        }

        return scoreByIndex.get(i);
    }

}
