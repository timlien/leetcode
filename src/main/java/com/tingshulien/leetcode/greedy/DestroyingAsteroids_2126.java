package com.tingshulien.leetcode.greedy;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/destroying-asteroids/">2126. Destroying Asteroids</a>
 * <p>
 * You are given an integer mass, which represents the original mass of a planet.
 * You are further given an integer array asteroids, where asteroids[i] is the mass of the ith asteroid.
 * <p>
 * You can arrange for the planet to collide with the asteroids in any arbitrary order.
 * If the mass of the planet is greater than or equal to the mass of the asteroid,
 * the asteroid is destroyed and the planet gains the mass of the asteroid. Otherwise, the planet is destroyed.
 * <p>
 * Return true if all asteroids can be destroyed. Otherwise, return false.
 */
public class DestroyingAsteroids_2126 {

    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);

        long planet = mass;

        for (int asteroid : asteroids) {
            if (planet < asteroid) {
                return false;
            }

            planet += asteroid;
        }

        return true;
    }

}
