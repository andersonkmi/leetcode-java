package org.codecraftlabs.leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CharacterPairBuilderTest {
    private CharacterPairBuilder characterPairBuilder;

    @BeforeEach
    public void setup() {
        this.characterPairBuilder = new CharacterPairBuilder();
    }

    @Test
    public void testPairGenerationEmptyList() {
        var results = this.characterPairBuilder.generatePairs(List.of());
        Assertions.assertThat(results).isEmpty();
    }

    @Test
    public void testPairGenerationListWithOneChar() {
        var results = this.characterPairBuilder.generatePairs(List.of('a'));
        Assertions.assertThat(results).isEmpty();
    }

    @Test
    public void testPairGenerationListWithTwoChars() {
        var results = this.characterPairBuilder.generatePairs(List.of('a', 'd'));
        Assertions.assertThat(results).hasSize(1);
        Assertions.assertThat(results).containsOnly(new Pair<>('a', 'd'));
    }
}
