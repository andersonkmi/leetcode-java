package org.codecraftlabs.leetcode;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TwoCharactersProblem {
    public int execute(@Nonnull String input) {
        return 0;
    }

    @Nonnull
    private Set<Character> getUniqueCharacters(@Nonnull String input) {
        Set<Character> items = new HashSet<>();
        for (int index = 0; index < input.length(); index++) {
            items.add(input.charAt(index));
        }
        return items;
    }

    @Nonnull
    private Set<Pair<Character, Character>> generatePairs(@Nonnull Set<Character> input) {
        return Collections.emptySet();
    }
}
