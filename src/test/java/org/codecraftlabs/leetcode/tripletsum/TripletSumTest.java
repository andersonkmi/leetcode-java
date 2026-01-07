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
}
