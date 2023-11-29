package com.tingshulien.leetcode.graph.depthfirstsearch;

/**
 * <a href="https://leetcode.com/problems/find-the-town-judge/description/">997. Find the Town Judge</a>
 * <p>
 * In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.
 * <p>
 * If the town judge exists, then:
 * <p>
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 * You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi. If a trust relationship does not exist in trust array, then such a trust relationship does not exist.
 * <p>
 * Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.
 */
public class FindTheTownJudge_997 {

    public int findJudge(int n, int[][] trust) {
        int[] believers = new int[n];
        int[] believing = new int[n];

        for (int[] edge : trust) {
            believers[edge[1] - 1] += 1;
            believing[edge[0] - 1] += 1;
        }

        for (int j = 1; j <= n; j++) {
            if (believers[j - 1] == n - 1 && believing[j - 1] == 0) {
                return j;
            }
        }

        return -1;
    }

}
