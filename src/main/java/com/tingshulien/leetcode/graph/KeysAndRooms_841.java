package com.tingshulien.leetcode.graph;

import java.util.List;

/**
 * <a href="https://leetcode.com/problems/keys-and-rooms/">841. Keys and Rooms</a>
 * <p>
 * There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to visit all the rooms.
 * However, you cannot enter a locked room without having its key.
 * <p>
 * When you visit a room, you may find a set of distinct keys in it.
 * Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.
 * <p>
 * Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i,
 * return true if you can visit all the rooms, or false otherwise.
 */
public class KeysAndRooms_841 {

    private boolean[] seen;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int size = rooms.size();
        seen = new boolean[size];
        int count = dfs(0, rooms);
        return size == count;
    }

    private int dfs(int node, List<List<Integer>> rooms) {
        int count = 1;

        seen[node] = true;

        for (int room : rooms.get(node)) {
            if (seen[room]) {
                continue;
            }

            seen[room] = true;
            count += dfs(room, rooms);
        }

        return count;
    }

}
