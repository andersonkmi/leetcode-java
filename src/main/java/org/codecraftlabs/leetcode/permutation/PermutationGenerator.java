package org.codecraftlabs.leetcode.permutation;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class PermutationGenerator {
    @Nonnull
    public List<List<Integer>> generate(int[] numbers) {
        List<List<Integer>> results = new ArrayList<>();
        for (int index = 0; index < numbers.length; index++) {
            List<Integer> items = new ArrayList<>();
            items.add(numbers[index]);
            for (int index2 = 0; index2 < numbers.length; index2++) {
                if (index == index2) {
                    continue;
                }
                items.add(numbers[index2]);
            }
        }
        return results;
    }
}
