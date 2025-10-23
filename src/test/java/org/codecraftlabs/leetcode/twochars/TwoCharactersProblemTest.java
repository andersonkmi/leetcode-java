package org.codecraftlabs.leetcode.twochars;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TwoCharactersProblemTest {
    private TwoCharactersProblem twoCharactersProblem;

    @BeforeEach
    public void setup() {
        this.twoCharactersProblem = new TwoCharactersProblem();
    }

    @Test
    public void testSimpleCase() {
        int result = this.twoCharactersProblem.execute("beabeefeab");
        Assertions.assertThat(result).isEqualTo(5);
    }

    @Test
    public void testAnotherCase() {
        int result = this.twoCharactersProblem.execute("abaacdabd");
        Assertions.assertThat(result).isEqualTo(4);
    }
}
