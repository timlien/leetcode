package com.tingshulien.leetcode.binarysearch;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/successful-pairs-of-spells-and-potions/">2300. Successful Pairs of Spells and Potions</a>
 * <p>
 * You are given two positive integer arrays spells and potions, of length n and m respectively,
 * where spells[i] represents the strength of the ith spell and potions[j] represents the strength of the jth potion.
 * <p>
 * You are also given an integer success. A spell and potion pair is considered successful if the product of their strengths is at least success.
 * <p>
 * Return an integer array pairs of length n where pairs[i] is the number of potions that will form a successful pair with the ith spell.
 */
public class SuccessfulPairsOfSpellsAndPotions_2300 {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);

        int[] answer = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            double target = (success / (double) spells[i]);
            int index = bs(potions, target);
            answer[i] = potions.length - index;
        }

        return answer;
    }

    private int bs(int[] arr, double target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

}
