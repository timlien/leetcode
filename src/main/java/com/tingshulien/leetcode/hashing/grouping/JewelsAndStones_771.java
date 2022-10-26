package com.tingshulien.leetcode.hashing.grouping;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/jewels-and-stones/">771. Jewels and Stones</a>
 *
 * You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.
 *
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 */
public class JewelsAndStones_771 {

    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char character : jewels.toCharArray()) {
            counts.put(character, 0);
        }

        for (char character : stones.toCharArray()) {
            if (!counts.containsKey(character)) {
                continue;
            }

            counts.merge(character, 1, Integer::sum);
        }

        int number = 0;
        for (int count : counts.values()) {
            number += count;
        }

        return number;
    }

}
