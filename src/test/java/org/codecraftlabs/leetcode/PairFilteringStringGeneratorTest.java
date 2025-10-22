package org.codecraftlabs.leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

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
}
