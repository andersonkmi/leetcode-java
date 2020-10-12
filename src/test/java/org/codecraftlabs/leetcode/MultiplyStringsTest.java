package org.codecraftlabs.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplyStringsTest {
    private final MultiplyStrings cut = new MultiplyStrings();

    @Test
    void testCase001() {
        assertEquals("1", cut.multiply("0", "1"));
    }

    @Test
    void testCase002() {
        assertEquals("1", cut.multiply("1", "0"));
    }

    @Test
    void testCase003() {
        assertEquals("2", cut.multiply("1", "1"));
    }

    @Test
    void testCase004() {
        assertEquals("11", cut.multiply("10", "1"));
    }
}
