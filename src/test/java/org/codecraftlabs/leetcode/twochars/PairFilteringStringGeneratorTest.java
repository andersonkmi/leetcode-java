package org.codecraftlabs.leetcode.twochars;

import org.assertj.core.api.Assertions;
import org.codecraftlabs.leetcode.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Set;

public class PairFilteringStringGeneratorTest {
    private PairFilteringStringGenerator pairFilteringStringGenerator;

    @BeforeEach
    public void setup() {
        this.pairFilteringStringGenerator = new PairFilteringStringGenerator();
    }

    @Test
    public void testWithEmptyPairSet() {
        var results = this.pairFilteringStringGenerator.filterCharPairsFromString(Collections.emptySet(), "abdefc");
        Assertions.assertThat(results).isEmpty();
    }

    @Test
    public void testWithValidPairSet() {
        var results = this.pairFilteringStringGenerator.filterCharPairsFromString(Set.of(new Pair<>('a', 'b')), "abaabcda");
        Assertions.assertThat(results).hasSize(1);
        Assertions.assertThat(results).contains("abaaba");
    }
}
