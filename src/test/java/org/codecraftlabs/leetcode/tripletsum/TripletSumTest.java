package org.codecraftlabs.leetcode.tripletsum;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TripletSumTest {
    private TripletSum tripletSum;

    @BeforeEach
    public void setup() {
        this.tripletSum = new TripletSum();
    }

    @Test
    public void testTripletSumBruteForce() {
        List<List<Integer>> expectedResults = new ArrayList<>();
        expectedResults.add(List.of(-3, 1, 2));
        expectedResults.add(List.of(-1, 0, 1));

        List<List<Integer>> results = this.tripletSum.tripletSumBruteForce(List.of(0, -1, 2, -3, 1));
        Assertions.assertThat(results).isEqualTo(expectedResults);
    }

    @Test
    public void when_number_list_is_empty_should_return_empty_results() {
        var result = this.tripletSum.tripletSum(new ArrayList<>());
        Assertions.assertThat(result).isEmpty();
    }

    @Test
    public void when_input_list_single_item_should_return_empty_results() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(0);

        var result = this.tripletSum.tripletSum(numbers);
        Assertions.assertThat(result).isEmpty();
    }

    @Test
    public void when_input_list_has_two_items_should_return_empty_result() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(-1);
        numbers.add(1);

        var result = this.tripletSum.tripletSum(numbers);
        Assertions.assertThat(result).isEmpty();
    }

    @Test
    public void when_input_list_has_same_values_should_return_value() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(0);
        numbers.add(0);
        numbers.add(0);

        var result = this.tripletSum.tripletSum(numbers);
        Assertions.assertThat(result).containsExactly(List.of(0, 0, 0));
    }

    @Test
    public void when_no_triplets_sum_should_return_empty_result() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(0);
        numbers.add(1);

        var result = this.tripletSum.tripletSum(numbers);
        Assertions.assertThat(result).isEmpty();
    }

    @Test
    public void when_input_has_triplets_should_return() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(0);
        numbers.add(0);
        numbers.add(1);
        numbers.add(-1);
        numbers.add(1);
        numbers.add(-1);

        var result = this.tripletSum.tripletSum(numbers);
        Assertions.assertThat(result).containsExactly(List.of(-1, 0, 1));
    }

    @Test
    public void when_three_elements_sum_to_zero_should_return_triplet() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(-1);
        numbers.add(0);
        numbers.add(1);

        var result = this.tripletSum.tripletSum(numbers);
        Assertions.assertThat(result).containsExactly(List.of(-1, 0, 1));
    }

    @Test
    public void when_three_elements_dont_sum_to_zero_should_return_empty() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        var result = this.tripletSum.tripletSum(numbers);
        Assertions.assertThat(result).isEmpty();
    }

    @Test
    public void when_all_positive_numbers_should_return_empty() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        var result = this.tripletSum.tripletSum(numbers);
        Assertions.assertThat(result).isEmpty();
    }

    @Test
    public void when_all_negative_numbers_should_return_empty() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(-5);
        numbers.add(-4);
        numbers.add(-3);
        numbers.add(-2);
        numbers.add(-1);

        var result = this.tripletSum.tripletSum(numbers);
        Assertions.assertThat(result).isEmpty();
    }

    @Test
    public void when_multiple_triplets_exist_should_return_all() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(-1);
        numbers.add(0);
        numbers.add(1);
        numbers.add(2);
        numbers.add(-1);
        numbers.add(-4);

        var result = this.tripletSum.tripletSum(numbers);
        Assertions.assertThat(result).containsExactlyInAnyOrder(
            List.of(-1, -1, 2),
            List.of(-1, 0, 1)
        );
    }

    @Test
    public void when_large_array_with_multiple_triplets() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(-4);
        numbers.add(-2);
        numbers.add(-2);
        numbers.add(-2);
        numbers.add(0);
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);
        numbers.add(2);
        numbers.add(4);

        var result = this.tripletSum.tripletSum(numbers);
        Assertions.assertThat(result).containsExactlyInAnyOrder(
            List.of(-4, 0, 4),
            List.of(-4, 2, 2),
            List.of(-2, -2, 4),
            List.of(-2, 0, 2)
        );
    }

    @Test
    public void when_duplicates_should_not_return_duplicate_triplets() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(0);
        numbers.add(0);
        numbers.add(0);
        numbers.add(0);

        var result = this.tripletSum.tripletSum(numbers);
        Assertions.assertThat(result).containsExactly(List.of(0, 0, 0));
    }

    @Test
    public void when_many_duplicates_with_valid_triplets() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(-2);
        numbers.add(-2);
        numbers.add(-2);
        numbers.add(1);
        numbers.add(1);
        numbers.add(1);
        numbers.add(1);

        var result = this.tripletSum.tripletSum(numbers);
        Assertions.assertThat(result).containsExactly(List.of(-2, 1, 1));
    }

    @Test
    public void when_mixed_values_with_zeros() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(-3);
        numbers.add(0);
        numbers.add(0);
        numbers.add(0);
        numbers.add(3);
        numbers.add(3);
        numbers.add(-3);

        var result = this.tripletSum.tripletSum(numbers);
        Assertions.assertThat(result).containsExactlyInAnyOrder(
            List.of(-3, 0, 3),
            List.of(0, 0, 0)
        );
    }
}
