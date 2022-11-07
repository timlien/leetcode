package com.tingshulien.leetcode.stack.monotonic;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/next-greater-element-i/description/">496. Next Greater Element I</a>
 * <p>
 * The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
 * <p>
 * You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
 * <p>
 * For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2.
 * If there is no next greater element, then the answer for this query is -1.
 * <p>
 * Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
 */
public class NextGreaterElementI_496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> decreasing = new ArrayDeque<>(nums2.length);
        Map<Integer, Integer> nextGreaterByElement = new HashMap<>(nums2.length);

        for (int num2 : nums2) {
            while (!decreasing.isEmpty() && decreasing.getLast() <= num2) {
                int element = decreasing.removeLast();
                nextGreaterByElement.put(element, num2);
            }

            decreasing.addLast(num2);
        }

        int[] answer = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            answer[i] = nextGreaterByElement.getOrDefault(nums1[i], -1);
        }

        return answer;
    }

}
