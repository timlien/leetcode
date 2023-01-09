package com.tingshulien.leetcode.greedy;

/**
 * <a href="https://leetcode.com/problems/container-with-most-water/description/">11. Container With Most Water</a>
 * <p>
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * <p>
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * <p>
 * Return the maximum amount of water a container can store.
 * <p>
 * Notice that you may not slant the container.
 */
public class ContainerWithMostWater_11 {

    public int maxArea(int[] height) {
        int length = height.length;
        int left = 0;
        int right = length - 1;
        int max = 0;

        while (left < right) {
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }

            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
        }

        return max;
    }

}
