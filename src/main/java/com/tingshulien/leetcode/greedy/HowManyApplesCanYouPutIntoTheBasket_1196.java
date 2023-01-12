package com.tingshulien.leetcode.greedy;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/how-many-apples-can-you-put-into-the-basket/description/">1196. How Many Apples Can You Put into the Basket</a>
 * <p>
 * You have some apples and a basket that can carry up to 5000 units of weight.
 * <p>
 * Given an integer array weight where weight[i] is the weight of the ith apple, return the maximum number of apples you can put in the basket.
 */
public class HowManyApplesCanYouPutIntoTheBasket_1196 {

    public int maxNumberOfApples(int[] weight) {
        Arrays.sort(weight);

        int number = 0;
        int count = 0;

        for (int j : weight) {
            if (j + number > 5000) {
                break;
            }

            number += j;
            count++;
        }

        return count;
    }

}
