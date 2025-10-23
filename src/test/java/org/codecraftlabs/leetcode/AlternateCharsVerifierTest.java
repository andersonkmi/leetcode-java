package org.codecraftlabs.leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AlternateCharsVerifierTest {
    private AlternateCharsVerifier alternateCharsVerifier;

    @BeforeEach
    public void setup() {
        this.alternateCharsVerifier = new AlternateCharsVerifier();
    }

    @Test
    public void testWithEmptyString() {
        boolean result = alternateCharsVerifier.isStringWithAlternatingCharacters("");
        Assertions.assertThat(result).isTrue();
    }
}
