package com.tingshulien.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/">17. Letter Combinations of a Phone Number</a>
 * <p>
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 * <p>
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 */
public class LetterCombinationsOfAPhoneNumber_17 {

    private char[][] letters = {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    public List<String> letterCombinations(String digits) {
        if (digits.isBlank() || digits.isEmpty()) {
            return Collections.emptyList();
        }

        int[] numbers = new int[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            numbers[i] = Integer.parseInt(digits.substring(i, i + 1));
        }

        List<String> answer = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        backtracking(current, 0, answer, numbers);
        return answer;
    }

    private void backtracking(StringBuilder current, int index, List<String> answer, int[] numbers) {
        if (index >= numbers.length) {
            answer.add(current.toString());
            return;
        }

        for (char letter : letters[numbers[index]]) {
            current.append(letter);
            backtracking(current, index + 1, answer, numbers);
            current.deleteCharAt(current.length() - 1);
        }
    }

}
