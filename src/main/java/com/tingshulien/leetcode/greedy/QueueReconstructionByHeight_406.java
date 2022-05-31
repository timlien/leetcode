package com.tingshulien.leetcode.greedy;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.com/problems/queue-reconstruction-by-height/">406. Queue Reconstruction by Height</a>
 *
 * You are given an array of people, people, which are the attributes of some people in a queue (not necessarily in order).
 * Each people[i] = [hi, ki] represents the ith person of height hi with exactly ki other people in front who have a height greater than or equal to hi.
 *
 * Reconstruct and return the queue that is represented by the input array people.
 * The returned queue should be formatted as an array queue,
 * where queue[j] = [hj, kj] is the attributes of the jth person in the queue (queue[0] is the person at the front of the queue).
 */
public class QueueReconstructionByHeight_406 {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? Integer.compare(o1[1], o2[1]) : Integer.compare(o2[0], o1[0]));

        final LinkedList<int[]> queue = new LinkedList<>();
        for (int[] person : people) {
            queue.add(person[1], person);
        }

        return queue.toArray(new int[people.length][2]);
    }

}
