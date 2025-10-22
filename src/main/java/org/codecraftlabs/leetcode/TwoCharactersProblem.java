package org.codecraftlabs.leetcode;

import javax.annotation.Nonnull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TwoCharactersProblem {
    private final CharacterPairBuilder characterPairBuilder = new CharacterPairBuilder();
    private final PairFilteringStringGenerator pairFilteringStringGenerator = new PairFilteringStringGenerator();

    public int execute(@Nonnull String input) {
        var uniqueChars = getUniqueCharacters(input);
        var pairs =  characterPairBuilder.generatePairs(uniqueChars);
        var resultingStrings = pairFilteringStringGenerator.filterCharPairsFromString(pairs, input);
        var itemsWithAlternatingChars = resultingStrings.stream().filter(this::isStringWithAlternatingCharacters).collect(Collectors.toSet());
        String longestAlternatingString = itemsWithAlternatingChars.stream().sorted((o1, o2) -> {
            if (o1.length() > o2.length()) {
                return -1;
            } else if (o1.length() < o2.length()) {
                return 1;
            }
            return 0;
        }).toList().getFirst();
        return longestAlternatingString.length();
    }

    @Nonnull
    private List<Character> getUniqueCharacters(@Nonnull String input) {
        Set<Character> items = new HashSet<>();
        for (int index = 0; index < input.length(); index++) {
            items.add(input.charAt(index));
        }
        return items.stream().toList();
    }

    private boolean isStringWithAlternatingCharacters(@Nonnull String input) {
        int previousChar = input.charAt(0);
        for (int index = 1; index < input.length(); index++) {
            char currentChar = input.charAt(index);
            if (currentChar == previousChar) {
                return false;
            }
            previousChar = currentChar;
        }
        return true;
    }
}
