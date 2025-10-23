package org.codecraftlabs.leetcode.permutation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
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
        Assertions.assertThat(results).contains(Collections.emptyList());
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

    @Test
    public void testWithTwoNumberArray() {
        int[] numbers = {1, 2};
        var results = this.permutationGenerator.generate(numbers);
        Assertions.assertThat(results).hasSize(2);

        // Verifies the list contents
        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> line1 = List.of(1, 2);
        List<Integer> line2 = List.of(2, 1);
        expected.add(line1);
        expected.add(line2);
        Assertions.assertThat(results).isEqualTo(expected);
    }

    @Test
    public void testWithThreeNumberArray() {
        int[] numbers = {1, 2, 3};
        var results = this.permutationGenerator.generate(numbers);
        Assertions.assertThat(results).hasSize(6);

        // Verifies the list contents
        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> line1 = List.of(1, 2, 3);
        List<Integer> line2 = List.of(1, 3, 2);
        List<Integer> line3 = List.of(2, 1, 3);
        List<Integer> line4 = List.of(2, 3, 1);
        List<Integer> line5 = List.of(3, 1, 2);
        List<Integer> line6 = List.of(3, 2, 1);
        expected.add(line1);
        expected.add(line2);
        expected.add(line3);
        expected.add(line4);
        expected.add(line5);
        expected.add(line6);
        Assertions.assertThat(results).isEqualTo(expected);
    }
}
