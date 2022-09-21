package com.tingshulien.leetcode.sorting;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/top-k-frequent-elements/">347. Top K Frequent Elements</a>
 * <p>
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 */
public class TopKFrequentElements_349 {

    private Map<Integer, Integer> hash;

    public int[] topKFrequent(int[] nums, int k) {
        hash = new HashMap<>();
        for (int num : nums) {
            hash.merge(num, 1, Integer::sum);
        }

        final int[] uniques = new int[hash.size()];
        int index = 0;
        for (int element : hash.keySet()) {
            uniques[index] = element;
            index++;
        }

        final int kthIndex = findKthFrequentIndex(uniques, uniques.length - k, 0, uniques.length - 1);
        final int[] result = new int[k];
        for (int i = kthIndex; i < uniques.length; i++) {
            result[i - kthIndex] = uniques[i];
        }

        return result;
    }

    private int findKthFrequentIndex(int[] nums, int k, int left, int right) {
        final int pivotIndex = partition(nums, left, right);
        if (pivotIndex == k) {
            return pivotIndex;
        } else if (pivotIndex < k) {
            return findKthFrequentIndex(nums, k, pivotIndex + 1, right);
        } else {
            return findKthFrequentIndex(nums, k, left, pivotIndex - 1);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int i = left - 1;
        int pivot = nums[right];

        for (int j = left; j < right; j++) {
            if (hash.get(nums[j]) < hash.get(pivot)) {
                i++;
                swap(nums, i, j);
            }
        }

        i++;
        swap(nums, i, right);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
