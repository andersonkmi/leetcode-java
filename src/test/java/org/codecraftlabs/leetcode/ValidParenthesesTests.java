package org.codecraftlabs.leetcode;

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

    @Test
    void validateWithInvalidChars() {
        assertFalse(cut.isValid("<>"));
    }

    @Test
    void validateSimpleCase() {
        assertTrue(cut.isValid("()"));
    }

    @Test
    void validateDoubleOpeningParentheses() {
        assertFalse(cut.isValid("(("));
    }

    @Test
    void validateDoubleOpeningBrackets() {
        assertFalse(cut.isValid("[["));
    }

    @Test
    void validateDoubleOpeningSets() {
        assertFalse(cut.isValid("{{"));
    }


    @Test
    void validateOnlyClosingParentheses() {
        assertFalse(cut.isValid(")"));
    }

    @Test
    void validateOnlyClosingBracket() {
        assertFalse(cut.isValid("]"));
    }

    @Test
    void validateOnlyClosingSet() {
        assertFalse(cut.isValid("}"));
    }

    @Test
    void validateInvertedSymbols() {
        assertFalse(cut.isValid("]["));
    }

    @Test
    void validateCombinations1() {
        assertTrue(cut.isValid("{}()"));
    }

    @Test
    void validateCombinations2() {
        assertTrue(cut.isValid("([])"));
    }
}
