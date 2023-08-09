package com.tingshulien.leetcode.hashing.grouping;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/isomorphic-strings/">205. Isomorphic Strings</a>
 * <p>
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character, but a character may map to itself.
 */
public class IsomorphicStrings_205 {

    public boolean isIsomorphic(String s, String t) {
        char[] first = s.toCharArray();
        char[] second = t.toCharArray();

        Map<Character, Character> firstGroup = new HashMap<>();
        Map<Character, Character> secondGroup = new HashMap<>();

        int length = first.length;

        for (int i = 0; i < length; i++) {
            if (!firstGroup.containsKey(first[i]) && !secondGroup.containsKey(second[i])) {
                firstGroup.put(first[i], second[i]);
                secondGroup.put(second[i], first[i]);
                continue;
            }

            if (firstGroup.containsKey(first[i]) && secondGroup.containsKey(second[i])) {
                if ((firstGroup.get(first[i]) == second[i]) && (secondGroup.get(second[i]) == first[i])) {
                    continue;
                }
            }

            return false;
        }

        return true;
    }

}
