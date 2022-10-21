package com.tingshulien.leetcode.hashing.counting;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/maximum-number-of-balloons/">1189. Maximum Number of Balloons</a>
 * <p>
 * Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
 * <p>
 * You can use each character in text at most once. Return the maximum number of instances that can be formed.
 */
public class MaximumNumberOfBalloons_1189 {

    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> count = new HashMap<>();
        for (char character : text.toCharArray()) {
            count.merge(character, 1, Integer::sum);
        }

        Map<Character, Integer> balloonCount = new HashMap<>();
        for (char character : "balloon".toCharArray()) {
            balloonCount.merge(character, 1, Integer::sum);
        }

        int number = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : balloonCount.entrySet()) {
            number = Math.min(number , count.getOrDefault(entry.getKey(), 0) / entry.getValue());

            if (number == 0) {
                return 0;
            }
        }

        return number;
    }

}
