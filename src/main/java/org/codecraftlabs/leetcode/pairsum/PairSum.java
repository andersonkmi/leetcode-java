package org.codecraftlabs.leetcode.pairsum;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import java.util.List;

public class PairSum {
    @Nonnull
    List<Integer> pairSum(@CheckForNull List<Integer> numbers, int target) {
        if (numbers == null) {
            return List.of();
        }

        int leftIndex = 0;
        int rightIndex = numbers.size() - 1;
        while (leftIndex < rightIndex) {
            int sum = numbers.get(leftIndex) + numbers.get(rightIndex);

            if (sum < target) {
                leftIndex++;
            } else if (sum > target) {
                rightIndex--;
            } else {
                return List.of(numbers.get(leftIndex), numbers.get(rightIndex));
            }
        }
        return List.of();
    }
}
