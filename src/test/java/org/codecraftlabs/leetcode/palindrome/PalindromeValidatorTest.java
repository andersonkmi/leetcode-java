package org.codecraftlabs.leetcode.palindrome;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PalindromeValidatorTest {
    private PalindromeValidator palindromeValidator;

    @BeforeEach
    public void setup() {
        this.palindromeValidator = new PalindromeValidator();
    }

    @Test
    public void when_string_is_empty_should_return_true() {
        boolean result = this.palindromeValidator.isValid("");
        Assertions.assertThat(result).isTrue();
    }
}
