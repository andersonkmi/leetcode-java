package org.codecraftlabs.leetcode.pairsum;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PairSumTest {
    private PairSum pairSum;

    @BeforeEach
    public void setup() {
        this.pairSum = new PairSum();
    }

    @Test
    public void test_empty_list_should_return_empty_result() {
        var result = this.pairSum.pairSum(List.of(), 3);
        Assertions.assertThat(result).isEmpty();
    }

    @Test
    public void when_list_single_element_should_return_empty_result() {
        var result = this.pairSum.pairSum(List.of(1), 5);
        Assertions.assertThat(result).isEmpty();
    }

    @Test
    public void when_pair_found_at_beginning_and_end() {
        var result = this.pairSum.pairSum(List.of(1, 2, 3, 4, 5), 6);
        Assertions.assertThat(result).containsExactly(1, 5);
    }

    @Test
    public void when_pair_found_in_middle() {
        var result = this.pairSum.pairSum(List.of(1, 2, 3, 4, 5, 6, 7), 9);
        Assertions.assertThat(result).containsExactly(2, 7);
    }

    @Test
    public void when_pair_found_with_two_elements() {
        var result = this.pairSum.pairSum(List.of(2, 7), 9);
        Assertions.assertThat(result).containsExactly(2, 7);
    }

    @Test
    public void when_no_pair_found_target_too_large() {
        var result = this.pairSum.pairSum(List.of(1, 2, 3, 4), 10);
        Assertions.assertThat(result).isEmpty();
    }

    @Test
    public void when_no_pair_found_target_too_small() {
        var result = this.pairSum.pairSum(List.of(5, 6, 7, 8), 3);
        Assertions.assertThat(result).isEmpty();
    }

    @Test
    public void when_two_elements_dont_match_target() {
        var result = this.pairSum.pairSum(List.of(1, 3), 5);
        Assertions.assertThat(result).isEmpty();
    }

    @Test
    public void when_list_contains_negative_numbers() {
        var result = this.pairSum.pairSum(List.of(-5, -2, 0, 3, 7), 5);
        Assertions.assertThat(result).containsExactly(-2, 7);
    }

    @Test
    public void when_both_numbers_are_negative() {
        var result = this.pairSum.pairSum(List.of(-10, -5, -3, -1), -8);
        Assertions.assertThat(result).containsExactly(-5, -3);
    }

    @Test
    public void when_list_contains_duplicates_and_pair_found() {
        var result = this.pairSum.pairSum(List.of(1, 2, 2, 3, 4, 4, 5), 8);
        Assertions.assertThat(result).containsExactly(3, 5);
    }

    @Test
    public void when_target_requires_same_number_twice() {
        var result = this.pairSum.pairSum(List.of(2, 3, 4, 4, 5), 8);
        Assertions.assertThat(result).containsExactly(3, 5);
    }

    @Test
    public void when_pair_found_with_zero() {
        var result = this.pairSum.pairSum(List.of(-3, 0, 1, 3, 5), 3);
        Assertions.assertThat(result).containsExactly(0, 3);
    }

    @Test
    public void when_target_is_zero() {
        var result = this.pairSum.pairSum(List.of(-5, -2, 0, 2, 5), 0);
        Assertions.assertThat(result).containsExactly(-5, 5);
    }
}
