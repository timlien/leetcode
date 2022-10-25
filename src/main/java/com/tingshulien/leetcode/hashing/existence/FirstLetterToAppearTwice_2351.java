package com.tingshulien.leetcode.hashing.existence;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/first-letter-to-appear-twice/">2351. First Letter to Appear Twice</a>
 * <p>
 * Given a string s consisting of lowercase English letters, return the first letter to appear twice.
 * <p>
 * Note:
 * A letter a appears twice before another letter b if the second occurrence of a is before the second occurrence of b.
 * s will contain at least one letter that appears twice.
 */
public class FirstLetterToAppearTwice_2351 {

    public char repeatedCharacter(String s) {
        char[] array = s.toCharArray();
        Set<Character> characters = new HashSet<>();
        for (char character : array) {
            if (characters.contains(character)) {
                return character;
            }

            characters.add(character);
        }

        throw new IllegalArgumentException();
    }

}
