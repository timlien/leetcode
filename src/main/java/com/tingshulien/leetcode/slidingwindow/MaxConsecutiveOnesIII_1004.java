package com.tingshulien.leetcode.slidingwindow;

/**
 * <a href="https://leetcode.com/problems/max-consecutive-ones-iii/">1004. Max Consecutive Ones III</a>
 * <p>
 * Given a binary array nums and an integer k,return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 */
public class MaxConsecutiveOnesIII_1004 {

    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int flip = 0;

        int current = 0;
        int max = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                flip++;
            }

            if (flip > k) {
                do {
                    left++;
                } while (nums[left - 1] == 1);

                flip--;
            }

            current = right - left + 1;
            max = Math.max(current, max);
        }

        return max;
    }

}
