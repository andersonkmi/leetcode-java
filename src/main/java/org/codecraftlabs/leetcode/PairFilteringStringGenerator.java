package org.codecraftlabs.leetcode;

import javax.annotation.Nonnull;
import java.util.Set;
import java.util.stream.Collectors;

class PairFilteringStringGenerator {
    @Nonnull
    Set<String> filterCharPairsFromString(@Nonnull Set<Pair<Character, Character>> pairs, @Nonnull String input) {
        return pairs.stream()
                .map(item -> filterPairFromInput(item, input))
                .collect(Collectors.toSet());
    }

    @Nonnull
    private String filterPairFromInput(@Nonnull Pair<Character, Character> pair, @Nonnull String input) {
        char first = pair.first();
        char second = pair.second();
        StringBuilder buffer = new StringBuilder();
        for (int index = 0; index < input.length(); index++) {
            if (input.charAt(index) == first || input.charAt(index) == second) {
                buffer.append(input.charAt(index));
            }
        }
        return buffer.toString();
    }
}
