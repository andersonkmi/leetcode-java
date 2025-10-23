package org.codecraftlabs.leetcode.twochars;

import org.assertj.core.api.Assertions;
import org.codecraftlabs.leetcode.permutation.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class CharacterPairBuilderTest {
    private CharacterPairBuilder characterPairBuilder;

    @BeforeEach
    public void setup() {
        this.characterPairBuilder = new CharacterPairBuilder();
    }

    @Test
    public void testPairGenerationEmptyList() {
        var results = this.characterPairBuilder.generatePairs(Set.of());
        Assertions.assertThat(results).isEmpty();
    }

    @Test
    public void testPairGenerationListWithOneChar() {
        var results = this.characterPairBuilder.generatePairs(Set.of('a'));
        Assertions.assertThat(results).isEmpty();
    }

    @Test
    public void testPairGenerationListWithTwoChars() {
        var results = this.characterPairBuilder.generatePairs(Set.of('a', 'd'));
        Assertions.assertThat(results).hasSize(1);
        Assertions.assertThat(results).containsOnly(new Pair<>('a', 'd'));
    }

    @Test
    public void testPairGenerationListWithABD() {
        var results = this.characterPairBuilder.generatePairs(Set.of('a', 'b', 'd'));
        Assertions.assertThat(results).hasSize(3);
        Assertions.assertThat(results).containsAll(
                Set.of(new Pair<>('a', 'b'),
                        new Pair<>('a', 'd'),
                        new Pair<>('b', 'd'))
        );
    }

    @Test
    public void testPairGenerationListWithABDG() {
        var results = this.characterPairBuilder.generatePairs(Set.of('a', 'b', 'd', 'g'));
        Assertions.assertThat(results).hasSize(6);
        Assertions.assertThat(results).containsAll(
                Set.of(new Pair<>('a', 'b'),
                        new Pair<>('a', 'd'),
                        new Pair<>('a', 'g'),
                        new Pair<>('b', 'd'),
                        new Pair<>('b', 'g'),
                        new Pair<>('d', 'g'))
        );
    }
}
