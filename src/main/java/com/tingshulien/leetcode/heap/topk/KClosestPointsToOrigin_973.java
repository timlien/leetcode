package com.tingshulien.leetcode.heap.topk;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/k-closest-points-to-origin/description/">973. K Closest Points to Origin</a>
 * <p>
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
 * <p>
 * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
 * <p>
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
 */
public class KClosestPointsToOrigin_973 {

    public int[][] kClosest(int[][] points, int k) {
        Map<int[], Integer> count = new HashMap<>();
        for (int[] point : points) {
            count.put(point, point[0] * point[0] + point[1] * point[1]);
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(count::get));

        for (int[] point : points) {
            priorityQueue.offer(point);
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll();
        }

        return result;
    }

}
