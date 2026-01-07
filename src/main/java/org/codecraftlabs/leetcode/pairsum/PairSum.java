package org.codecraftlabs.leetcode.pairsum;

import javax.annotation.Nonnull;
import java.util.List;

class PairSum {
    @Nonnull
    List<Integer> pairSum(@Nonnull List<Integer> numbers, int target) {
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
