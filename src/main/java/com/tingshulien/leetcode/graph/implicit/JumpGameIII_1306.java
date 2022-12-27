package com.tingshulien.leetcode.graph.implicit;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/jump-game-iii/description/">1306. Jump Game III</a>
 * <p>
 * Given an array of non-negative integers arr, you are initially positioned at start index of the array.
 * When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.
 * <p>
 * Notice that you can not jump outside of the array at any time.
 */
public class JumpGameIII_1306 {

    private int[] array;

    public boolean canReach(int[] arr, int start) {
        this.array = arr;
        boolean[] seen = new boolean[array.length];

        Queue<Integer> queue = new ArrayDeque<>(array.length);
        queue.add(start);

        while (!queue.isEmpty()) {
            int index = queue.remove();
            for (int nextIndex : jump(index)) {
                if (array[nextIndex] == 0) {
                    return true;
                }

                if (seen[nextIndex]) {
                    continue;
                }

                queue.add(nextIndex);
                seen[nextIndex] = true;
            }

        }

        return false;
    }

    public List<Integer> jump(int index) {
        int length = array.length;

        List<Integer> destinations = new ArrayList<>();

        int rightIndex = index + array[index];
        if (rightIndex < length) {
            destinations.add(rightIndex);
        }

        int leftIndex = index - array[index];
        if (leftIndex >= 0) {
            destinations.add(leftIndex);
        }

        return destinations;
    }

}
