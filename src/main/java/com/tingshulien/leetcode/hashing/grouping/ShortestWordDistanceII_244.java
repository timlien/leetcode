package com.tingshulien.leetcode.hashing.grouping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/shortest-word-distance-ii/">244. Shortest Word Distance II</a>
 * <p>
 * Design a data structure that will be initialized with a string array,
 * and then it should answer queries of the shortest distance between two different strings from the array.
 * <p>
 * Implement the WordDistance class:
 * <p>
 * WordDistance(String[] wordsDict) initializes the object with the strings array wordsDict.
 * int shortest(String word1, String word2) returns the shortest distance between word1 and word2 in the array wordsDict.
 */
public class ShortestWordDistanceII_244 {

    private final Map<String, List<Integer>> indexes;

    public ShortestWordDistanceII_244(String[] wordsDict) {
        this.indexes = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            if (indexes.containsKey(wordsDict[i])) {
                indexes.get(wordsDict[i]).add(i);
            } else {
                List<Integer> index = new ArrayList<>();
                index.add(i);
                indexes.put(wordsDict[i], index);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> indexes1 = indexes.get(word1);
        List<Integer> indexes2 = indexes.get(word2);

        int shortest = Integer.MAX_VALUE;
        int i1 = 0;
        int i2 = 0;
        while (i1 < indexes1.size() && i2 < indexes2.size()) {
            if (indexes1.get(i1) < indexes2.get(i2)) {
                i1++;
            } else {
                i2++;
            }

            shortest = Math.min(shortest, Math.abs(i1 - i2));
        }

        return shortest;
    }

}
