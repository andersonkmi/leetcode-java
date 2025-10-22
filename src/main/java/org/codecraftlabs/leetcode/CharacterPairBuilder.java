package org.codecraftlabs.leetcode;

import javax.annotation.Nonnull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CharacterPairBuilder {
    @Nonnull
    public Set<Pair<Character, Character>> generatePairs(@Nonnull List<Character> characters) {
        Set<Pair<Character, Character>> resultingPairs = new HashSet<>();
        for(int index1 = 0; index1 < characters.size() - 1; index1++) {
            for (int index2 = index1 + 1; index2 < characters.size(); index2++) {
                var pair = new Pair<>(characters.get(index1), characters.get(index2));
                resultingPairs.add(pair);
            }
        }
        return resultingPairs;
    }
}
