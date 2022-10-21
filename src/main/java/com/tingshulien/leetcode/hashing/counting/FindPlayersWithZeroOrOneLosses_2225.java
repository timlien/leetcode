package com.tingshulien.leetcode.hashing.counting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * <a href="https://leetcode.com/problems/find-players-with-zero-or-one-losses/">2225. Find Players With Zero or One Losses</a>
 * <p>
 * You are given an integer array matches where matches[i] = [winneri, loseri] indicates that the player winneri defeated player loseri in a match.
 * <p>
 * Return a list answer of size 2 where:
 * <p>
 * answer[0] is a list of all players that have not lost any matches.
 * answer[1] is a list of all players that have lost exactly one match.
 * The values in the two lists should be returned in increasing order.
 * <p>
 * Note:
 * <p>
 * You should only consider the players that have played at least one match.
 * The testcases will be generated such that no two matches will have the same outcome.
 */
public class FindPlayersWithZeroOrOneLosses_2225 {

    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> countByWinner = new HashMap<>();
        Map<Integer, Integer> countByLoser = new HashMap<>();

        for (int[] array : matches) {
            countByWinner.merge(array[0], 1, Integer::sum);
            countByLoser.merge(array[1], 1, Integer::sum);
        }

        List<Integer> winnerNotLost = new ArrayList<>();
        for (Entry<Integer, Integer> winner : countByWinner.entrySet()) {
            if (countByLoser.containsKey(winner.getKey())) {
                continue;
            }

            winnerNotLost.add(winner.getKey());
        }

        List<Integer> loserLostOnce = new ArrayList<>();
        for (Entry<Integer, Integer> loser : countByLoser.entrySet()) {
            if (loser.getValue() != 1) {
                continue;
            }

            loserLostOnce.add(loser.getKey());
        }

        Collections.sort(winnerNotLost);
        Collections.sort(loserLostOnce);

        List<List<Integer>> result = new ArrayList<>();
        result.add(winnerNotLost);
        result.add(loserLostOnce);

        return result;
    }

}
