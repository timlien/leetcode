package com.tingshulien.leetcode.hashing.grouping;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up/">2260. Minimum Consecutive Cards to Pick Up</a>
 * <p>
 * You are given an integer array cards where cards[i] represents the value of the ith card.
 * A pair of cards are matching if the cards have the same value.
 * <p>
 * Return the minimum number of consecutive cards you have to pick up to have a pair of matching cards among the picked cards.
 * If it is impossible to have matching cards, return -1.
 */
public class MinimumConsecutiveCardsToPickUp_2260 {

    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> indexByNumber = new HashMap<>();

        int number = Integer.MAX_VALUE;
        for (int i = 0; i < cards.length; i++) {
            if (indexByNumber.containsKey(cards[i])) {
                number = Math.min(number, i - indexByNumber.get(cards[i]) + 1);
            }

            indexByNumber.put(cards[i], i);
        }

        return number == Integer.MAX_VALUE ? -1 : number;
    }

}
