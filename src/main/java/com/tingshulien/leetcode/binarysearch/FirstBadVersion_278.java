package com.tingshulien.leetcode.binarysearch;

/**
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version,
 * all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which returns whether version is bad.
 * Implement a function to find the first bad version. You should minimize the number of calls to the API.
 */
public class FirstBadVersion_278 {

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int pivot;

        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (isBadVersion(pivot)) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }

        return left;
    }

    private static final int FIRST_BAD_VERSION = 2;

    private boolean isBadVersion(int version) {
        return version >= FIRST_BAD_VERSION;
    }

}
