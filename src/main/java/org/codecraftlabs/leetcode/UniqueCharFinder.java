package org.codecraftlabs.leetcode;

import javax.annotation.Nonnull;
import java.util.HashSet;
import java.util.Set;

class UniqueCharFinder {
    @Nonnull
    Set<Character> getUniqueCharacters(@Nonnull String input) {
        Set<Character> items = new HashSet<>();
        for (int index = 0; index < input.length(); index++) {
            items.add(input.charAt(index));
        }
        return items;
    }
}
