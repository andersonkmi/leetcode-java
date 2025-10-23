package org.codecraftlabs.leetcode;

import javax.annotation.Nonnull;
import java.util.stream.Collectors;

public class TwoCharactersProblem {
    private final UniqueCharFinder uniqueCharFinder = new UniqueCharFinder();
    private final CharacterPairBuilder characterPairBuilder = new CharacterPairBuilder();
    private final PairFilteringStringGenerator pairFilteringStringGenerator = new PairFilteringStringGenerator();
    private final AlternateCharsVerifier alternateCharsVerifier = new AlternateCharsVerifier();

    public int execute(@Nonnull String input) {
        var uniqueChars = uniqueCharFinder.getUniqueCharacters(input);
        var pairs = characterPairBuilder.generatePairs(uniqueChars);
        var resultingStrings = pairFilteringStringGenerator.filterCharPairsFromString(pairs, input);
        var itemsWithAlternatingChars = resultingStrings.stream()
                .filter(alternateCharsVerifier::isStringWithAlternatingCharacters)
                .collect(Collectors.toSet());
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
}
