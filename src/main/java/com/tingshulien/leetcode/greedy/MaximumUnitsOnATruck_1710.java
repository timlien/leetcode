package com.tingshulien.leetcode.greedy;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/maximum-units-on-a-truck/description/">1710. Maximum Units on a Truck</a>
 * <p>
 * You are assigned to put some amount of boxes onto one truck. You are given a 2D array boxTypes, where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:
 * <p>
 * numberOfBoxesi is the number of boxes of type i.
 * numberOfUnitsPerBoxi is the number of units in each box of the type i.
 * You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck. You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize.
 * <p>
 * Return the maximum total number of units that can be put on the truck.
 */
public class MaximumUnitsOnATruck_1710 {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (o1, o2) -> Integer.compare(o1[1], o2[1]) * -1);

        int size = 0;
        int units = 0;
        for (int[] box : boxTypes) {
            size += box[0];
            units += box[0] * box[1];

            if (size > truckSize) {
                units -= (size - truckSize) * box[1];
                break;
            }
        }

        return units;
    }

}
