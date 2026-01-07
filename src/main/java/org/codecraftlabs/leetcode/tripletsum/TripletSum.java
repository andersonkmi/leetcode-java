package org.codecraftlabs.leetcode.tripletsum;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
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

    @Nonnull
    public List<List<Integer>> tripletSum(@Nonnull List<Integer> numbers) {
        List<List<Integer>> triplets = new ArrayList<>();
        // Sort the input array
        Collections.sort(numbers);
        for (int index = 0; index < numbers.size(); index++) {
            if (numbers.get(index) > 0) {
                break;
            }

            // Move forward if the number is the same value as the previous one
            if (index > 0 && numbers.get(index) == numbers.get(index - 1)) {
                continue;
            }

            // Find the triplets
            var results = findAllPairsWithSum(numbers, index + 1, numbers.get(index) * -1);
            for (List<Integer> pair : results) {
                List<Integer> triplet = new ArrayList<>();
                triplet.add(numbers.get(index));
                triplet.addAll(pair);
                triplets.add(triplet);
            }
        }
        return triplets;
    }

    @Nonnull
    private List<List<Integer>> findAllPairsWithSum(@Nonnull List<Integer> numbers, int startPosition, int target) {
        List<List<Integer>> pairs = new ArrayList<>();
        int left = startPosition;
        int right = numbers.size() - 1;
        while (left < right) {
            int leftValue = numbers.get(left);
            int rightValue = numbers.get(right);
            int sum = leftValue + rightValue;
            if (sum == target) {
                List<Integer> pair = List.of(leftValue, rightValue);
                pairs.add(pair);
                do {
                    left++;
                } while ((left < right) && Objects.equals(numbers.get(left), numbers.get(left - 1)));
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return pairs;
    }
}
