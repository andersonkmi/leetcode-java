package org.codecraftlabs.leetcode;

import javax.annotation.Nonnull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class CharacterPairBuilder {
    @Nonnull
    Set<Pair<Character, Character>> generatePairs(@Nonnull Set<Character> characters) {
        Set<Pair<Character, Character>> resultingPairs = new HashSet<>();

        List<Character> converted = characters.stream().sorted().toList();
        for(int index1 = 0; index1 < converted.size() - 1; index1++) {
            for (int index2 = index1 + 1; index2 < converted.size(); index2++) {
                var pair = new Pair<>(converted.get(index1), converted.get(index2));
                resultingPairs.add(pair);
            }
        }
        return resultingPairs;
    }
}
