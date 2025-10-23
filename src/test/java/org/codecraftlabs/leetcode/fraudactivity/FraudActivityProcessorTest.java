package org.codecraftlabs.leetcode.fraudactivity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FraudActivityProcessorTest {
    private FraudActivityProcessor fraudActivityProcessor;

    @BeforeEach
    public void setup() {
        fraudActivityProcessor = new FraudActivityProcessor();
    }

    @Test
    public void testWithSampleDataFromExercise() {
        List<Integer> expenditures = List.of(2, 3, 4, 2, 3, 6, 8, 4, 5);
        int lookbackDays = 5;

        var result = this.fraudActivityProcessor.notifyFraudulentExpenditures(expenditures, lookbackDays);
        Assertions.assertThat(result).isEqualTo(2);
    }
}
