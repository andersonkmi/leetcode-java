package org.codecraftlabs.leetcode.muitiplication;

import org.codecraftlabs.leetcode.mutiplication.MultiplyStrings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplyStringsTest {
    private final MultiplyStrings cut = new MultiplyStrings();

    @Test
    void testCase001() {
        assertEquals("0", cut.multiply("0", "1"));
    }

    @Test
    void testCase002() {
        assertEquals("0", cut.multiply("1", "0"));
    }

    @Test
    void testCase003() {
        assertEquals("1", cut.multiply("1", "1"));
    }

    @Test
    void testCase004() {
        assertEquals("10", cut.multiply("10", "1"));
    }

    @Test
    void testCase005() {
        assertEquals("56088", cut.multiply("123", "456"));
    }

    @Test
    void testCase006() {
        assertEquals("419254329864656431168468", cut.multiply("498828660196", "840477629533"));
    }

    @Test
    void testCase007() {
        assertEquals("800207406037324579815815608581", cut.multiply("9333852702227987", "85731737104263"));
    }
}
