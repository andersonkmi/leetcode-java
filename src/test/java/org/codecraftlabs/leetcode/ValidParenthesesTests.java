package org.codecraftlabs.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidParenthesesTests {
    private ValidParentheses cut;

    @BeforeEach
    void setup() {
        cut = new ValidParentheses();
    }

    @Test
    void validateNullString() {
        assertTrue(cut.isValid(null));
    }

    @Test
    void validateEmptyString() {
        assertTrue(cut.isValid(""));
    }
}
