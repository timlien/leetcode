package com.tingshulien.leetcode.hashing.grouping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/group-anagrams/">49. Group Anagrams</a>
 * <p>
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 */
public class GroupAnagrams_49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> stringsByCharacters = new HashMap<>();
        for (String str : strs) {
            char[] characters = str.toCharArray();
            Arrays.sort(characters);
            String key = String.valueOf(characters);

            if (!stringsByCharacters.containsKey(key)) {
                List<String> strings = new ArrayList<>();
                strings.add(str);
                stringsByCharacters.put(key, strings);
            } else {
                List<String> strings = stringsByCharacters.get(key);
                strings.add(str);
            }
        }

        return new ArrayList<>(stringsByCharacters.values());
    }

}
