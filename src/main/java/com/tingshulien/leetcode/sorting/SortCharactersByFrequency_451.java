package com.tingshulien.leetcode.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/sort-characters-by-frequency/">451. Sort Characters By Frequency</a>
 * <p>
 * Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
 * <p>
 * Return the sorted string. If there are multiple answers, return any of them.
 */
public class SortCharactersByFrequency_451 {

    public String frequencySort(String s) {
        final Map<Character, Integer> count = new HashMap<>();
        for (Character character : s.toCharArray()) {
            count.merge(character, 1, Integer::sum);
        }

        final List<Character> unique = new ArrayList<>(count.keySet());
        unique.sort(Comparator.comparingInt(count::get).reversed());

        final StringBuilder builder = new StringBuilder();
        for (Character character : unique) {
            for (int i = 1; i <= count.get(character); i++) {
                builder.append(character);
            }
        }

        return builder.toString();
    }

}
