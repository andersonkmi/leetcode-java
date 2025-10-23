package org.codecraftlabs.leetcode.twochars;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UniqueCharFinderTest {
    private UniqueCharFinder uniqueCharFinder;

    @BeforeEach
    public void setup() {
        this.uniqueCharFinder = new UniqueCharFinder();
    }

    @Test
    public void testEmptyString() {
        var results = this.uniqueCharFinder.getUniqueCharacters("");
        Assertions.assertThat(results).isEmpty();
    }

    @Test
    public void testOneCharString() {
        var results = this.uniqueCharFinder.getUniqueCharacters("a");
        Assertions.assertThat(results).hasSize(1);
        Assertions.assertThat(results).contains('a');
    }

    @Test
    public void testMultipleCharString() {
        var results = this.uniqueCharFinder.getUniqueCharacters("abssswed");
        Assertions.assertThat(results).hasSize(6);
        Assertions.assertThat(results).containsAll(List.of('a', 'b', 's', 'w', 'e', 'd'));
    }
}
