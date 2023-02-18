package com.tingshulien.leetcode.binarysearch.solutionspace;

/**
 * <a href="https://leetcode.com/problems/minimum-speed-to-arrive-on-time/">1870. Minimum Speed to Arrive on Time</a>
 * <p>
 * You are given a floating-point number hour, representing the amount of time you have to reach the office.
 * To commute to the office, you must take n trains in sequential order. You are also given an integer array dist of length n,
 * where dist[i] describes the distance (in kilometers) of the ith train ride.
 * <p>
 * Each train can only depart at an integer hour, so you may need to wait in between each train ride.
 * <p>
 * For example, if the 1st train ride takes 1.5 hours,
 * you must wait for an additional 0.5 hours before you can depart on the 2nd train ride at the 2 hour mark.
 * Return the minimum positive integer speed (in kilometers per hour) that all the trains must travel at for you to reach the office on time,
 * or -1 if it is impossible to be on time.
 * <p>
 * Tests are generated such that the answer will not exceed 107 and hour will have at most two digits after the decimal point.
 */
public class MinimumSpeedToArriveOnTime_1870 {

    public int minSpeedOnTime(int[] dist, double hour) {
        if (hour <= dist.length) {
            return -1;
        }

        int left = 1;
        int right = (int) Math.pow(10, 7);

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (validate(mid, hour, dist)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean validate(int speed, double hour, int[] distances) {
        double time = 0;

        for (int i = 0; i < distances.length; i++) {
            if (i != distances.length - 1) {
                time += Math.ceil(distances[i] / (double) speed);
            } else {
                time += distances[i] / (double) speed;
            }
        }

        return hour >= time;
    }

}
