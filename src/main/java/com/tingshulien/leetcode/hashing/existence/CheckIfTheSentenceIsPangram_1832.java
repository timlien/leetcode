package com.tingshulien.leetcode.hashing.existence;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/check-if-the-sentence-is-pangram/">1832. Check if the Sentence Is Pangram</a>
 * <p>
 * A pangram is a sentence where every letter of the English alphabet appears at least once.
 * <p>
 * Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.
 */
public class CheckIfTheSentenceIsPangram_1832 {

    public boolean checkIfPangram(String sentence) {
        char[] characters = sentence.toCharArray();
        Set<Character> alphabets = new HashSet<>();
        for (char character : characters) {
            alphabets.add(character);

            if (alphabets.size() >= 26) {
                return true;
            }
        }

        return false;
    }
}