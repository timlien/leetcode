package com.tingshulien.leetcode.greedy;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/boats-to-save-people/">881. Boats to Save People</a>
 * <p>
 * You are given an array people where people[i] is the weight of the ith person,
 * and an infinite number of boats where each boat can carry a maximum weight of limit.
 * Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.
 * <p>
 * Return the minimum number of boats to carry every given person.
 */
public class BoatsToSavePeople_881 {

    public int numRescueBoats(int[] people, int limit) {
        if (people.length == 0) {
            return 0;
        }

        Arrays.sort(people);

        int left = 0;
        int answer = 0;

        for (int right = people.length - 1; right >= left; right--) {
            if (left == right || people[left] + people[right] <= limit) {
                left++;
            }

            right--;
            answer++;
        }

        return answer;
    }

}
