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
}
