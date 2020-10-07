package org.codecraftlabs.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidParenthesesTests {
    private final ValidParentheses cut = new ValidParentheses();

    @Test
    void validateNullString() {
        assertTrue(cut.isValid(null));
    }

    @Test
    void validateEmptyString() {
        assertTrue(cut.isValid(""));
    }

    @Test
    void validateOddLengthString() {
        assertFalse(cut.isValid("("));
    }

    @Test
    void validateOddLengthStringWithInvalidChars() {
        assertFalse(cut.isValid("<"));
    }
}
