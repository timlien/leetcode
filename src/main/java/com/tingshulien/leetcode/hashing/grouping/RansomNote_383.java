package com.tingshulien.leetcode.hashing.grouping;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/ransom-note/">383. Ransom Note</a>
 * <p>
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 * <p>
 * Each letter in magazine can only be used once in ransomNote.
 */
public class RansomNote_383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char character : magazine.toCharArray()) {
            counts.merge(character, 1, Integer::sum);
        }

        for (char character : ransomNote.toCharArray()) {
            counts.merge(character, -1, Integer::sum);
        }

        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            if (entry.getValue() < 0) {
                return false;
            }
        }

        return true;
    }

}
