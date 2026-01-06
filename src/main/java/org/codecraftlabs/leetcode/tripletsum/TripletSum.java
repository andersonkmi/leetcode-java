package org.codecraftlabs.leetcode.tripletsum;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TripletSum {
    @Nonnull
    public List<List<Integer>> tripletSumBruteForce(@Nonnull List<Integer> numbers) {
        Set<List<Integer>> results = new HashSet<>();
        for (int index1 = 0; index1 < numbers.size(); index1++) {
            for (int index2 = index1 + 1; index2 < numbers.size(); index2++) {
                for (int index3 = index2 + 1; index3 < numbers.size(); index3++) {
                    int sum = numbers.get(index1) + numbers.get(index2) + numbers.get(index3);
                    if (sum == 0) {
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(numbers.get(index1));
                        triplet.add(numbers.get(index2));
                        triplet.add(numbers.get(index3));
                        Collections.sort(triplet);
                        results.add(triplet);
                    }
                }
            }
        }
        return results.stream().toList();
    }
}
