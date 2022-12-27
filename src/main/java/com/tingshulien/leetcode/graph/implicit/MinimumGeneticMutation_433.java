package com.tingshulien.leetcode.graph.implicit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/minimum-genetic-mutation/description/">433. Minimum Genetic Mutation</a>
 * <p>
 * A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.
 * <p>
 * Suppose we need to investigate a mutation from a gene string startGene to a gene string endGene where one mutation is defined as one single character changed in the gene string.
 * <p>
 * For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
 * There is also a gene bank bank that records all the valid gene mutations. A gene must be in bank to make it a valid gene string.
 * <p>
 * Given the two gene strings startGene and endGene and the gene bank bank, return the minimum number of mutations needed to mutate from startGene to endGene. If there is no such a mutation, return -1.
 * <p>
 * Note that the starting point is assumed to be valid, so it might not be included in the bank.
 */
public class MinimumGeneticMutation_433 {

    private char[] mutations;

    private Set<String> bank;

    public int minMutation(String startGene, String endGene, String[] bank) {
        this.mutations = new char[]{'A', 'C', 'G', 'T'};

        this.bank = new HashSet<>(List.of(bank));
        Set<String> seen = new HashSet<>();

        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);
        seen.add(startGene);

        int mutation = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String gene = queue.remove();
                if (gene.equals(endGene)) {
                    return mutation;
                }

                for (String neighbor : mutate(gene)) {
                    if (seen.contains(neighbor)) {
                        continue;
                    }

                    queue.add(neighbor);
                    seen.add(neighbor);
                }
            }

            mutation++;
        }

        return -1;
    }

    private List<String> mutate(String gene) {
        int length = gene.length();

        List<String> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            char current = gene.charAt(i);

            for (char mutation : mutations) {
                if (mutation == current) {
                    continue;
                }

                String mutatedGene = gene.substring(0, i) + mutation + gene.substring(i + 1, length);
                if (!bank.contains(mutatedGene)) {
                    continue;
                }

                result.add(mutatedGene);
            }
        }

        return result;
    }

}
