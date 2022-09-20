package com.tingshulien.leetcode.sorting;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
class QuickSortTest {

    @Test
    void quickSortTest() {
        final int[] nums = {1, 5, 7, 4, 8, 2, 3};

        QuickSort.sort(nums, 0, nums.length - 1);

        final int[] expected = {1, 2, 3, 4, 5, 7, 8};
        assertThat(nums, is(expected));
    }

}