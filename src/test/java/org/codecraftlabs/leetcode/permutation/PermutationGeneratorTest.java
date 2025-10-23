package org.codecraftlabs.leetcode.permutation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PermutationGeneratorTest {
    private PermutationGenerator permutationGenerator;

    @BeforeEach
    public void setup() {
        this.permutationGenerator = new PermutationGenerator();
    }

    @Test
    public void testEmptyArray() {
        int[] numbers = {};
        var results = this.permutationGenerator.generate(numbers);
        Assertions.assertThat(results).isEmpty();
    }
}
