package org.codecraftlabs.leetcode.permutation;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PermutationGenerator {
    @Nonnull
    public List<List<Integer>> generate(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPermutation = new LinkedList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(nums, currentPermutation, used, result);
        return result;
    }

    /**
     * Recursive helper method using backtracking to generate permutations
     */
    private void backtrack(int[] nums,
                                  List<Integer> currentPermutation,
                                  boolean[] used,
                                  List<List<Integer>> result) {
        if (currentPermutation.size() == nums.length) {
            result.add(new LinkedList<>(currentPermutation));
            return;
        }

        // Try adding each unused number to the current permutation
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            currentPermutation.add(nums[i]);
            used[i] = true;

            // Explore: recursively generate permutations with this choice
            backtrack(nums, currentPermutation, used, result);

            // Unchoose: backtrack by removing the last added number
            currentPermutation.removeLast();
            used[i] = false;
        }
    }
}
