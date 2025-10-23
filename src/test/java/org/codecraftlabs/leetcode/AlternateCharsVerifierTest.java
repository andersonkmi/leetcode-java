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
        Assertions.assertThat(result).isFalse();
    }

    @Test
    public void testWithNullString() {
        boolean result = alternateCharsVerifier.isStringWithAlternatingCharacters(null);
        Assertions.assertThat(result).isFalse();
    }

    @Test
    public void testWithSingleCharString() {
        boolean result = alternateCharsVerifier.isStringWithAlternatingCharacters("a");
        Assertions.assertThat(result).isTrue();
    }

    @Test
    public void testWithTwoCharString() {
        boolean result = alternateCharsVerifier.isStringWithAlternatingCharacters("ac");
        Assertions.assertThat(result).isTrue();
    }

    @Test
    public void testWithThreeCharString() {
        boolean result = alternateCharsVerifier.isStringWithAlternatingCharacters("aca");
        Assertions.assertThat(result).isTrue();
    }
}
