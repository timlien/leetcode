package com.tingshulien.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/">https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/</a>
 *
 * There are some spherical balloons taped onto a flat wall that represents the XY-plane.
 * The balloons are represented as a 2D integer array points where points[i] = [xstart, xend] denotes a balloon
 * whose horizontal diameter stretches between xstart and xend.
 * You do not know the exact y-coordinates of the balloons.
 *
 * Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis.
 * A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend.
 * There is no limit to the number of arrows that can be shot.
 * A shot arrow keeps traveling up infinitely, bursting any balloons in its path.
 *
 * Given the array points, return the minimum number of arrows that must be shot to burst all balloons.
 */
public class MinimumNumberOfArrowsToBurstBalloons_452 {

    /**
     * Minimum Number of Arrows to Burst Balloons
     *
     * @param points [[3,9],[7,12],[3,8],[6,8],[9,10],[2,9],[0,9],[3,9],[0,6],[2,8]]
     * @return 2
     */
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));

        int shots = 1;
        int shotX = points[0][1];
        for (int[] point : points) {
           if (shotX >= point[0]) {
                continue;
           }

            shotX = point[1];
            shots++;
        }

        return shots;
    }

}
