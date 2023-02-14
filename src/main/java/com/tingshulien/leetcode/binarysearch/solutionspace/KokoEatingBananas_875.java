package com.tingshulien.leetcode.binarysearch.solutionspace;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/koko-eating-bananas/">875. Koko Eating Bananas</a>
 * <p>
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
 * <p>
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile.
 * If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
 * <p>
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 * <p>
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 */
public class KokoEatingBananas_875 {

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().orElse(0);

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (check(h, mid, piles)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean check(int h, int k, int[] piles) {
        int hour = 0;

        for (int pile : piles) {
            hour += Math.ceil(pile / (double) k);
        }

        return hour <= h;
    }

}
