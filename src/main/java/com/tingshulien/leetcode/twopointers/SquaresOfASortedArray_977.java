package com.tingshulien.leetcode.twopointers;

/**
 * <a href="https://leetcode.com/problems/squares-of-a-sorted-array/description/">977. Squares of a Sorted Array</a>
 * <p>
 * Given an integer array nums sorted in non-decreasing order,
 * return an array of the squares of each number sorted in non-decreasing order.
 */
public class SquaresOfASortedArray_977 {

    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        int[] answer = new int[nums.length];
        int index = answer.length - 1;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (left == right) {
                answer[index] = nums[left];
                left++;
            } else if (nums[left] == nums[right]) {
                answer[index--] = nums[left++];
                answer[index--] = nums[right--];
            } else if (nums[left] > nums[right]) {
                answer[index--] = nums[left++];
            } else {
                answer[index--] = nums[right--];
            }
        }

        return answer;
    }

}
