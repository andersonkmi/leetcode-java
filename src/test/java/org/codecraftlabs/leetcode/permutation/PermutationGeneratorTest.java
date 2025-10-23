package org.codecraftlabs.leetcode.permutation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void testSingleItemArray() {
        int[] numbers = {1};
        var results = this.permutationGenerator.generate(numbers);
        Assertions.assertThat(results).hasSize(1);

        // Verifies the list contents
        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        values.add(1);
        expected.add(values);
        Assertions.assertThat(results).isEqualTo(expected);
    }
}
