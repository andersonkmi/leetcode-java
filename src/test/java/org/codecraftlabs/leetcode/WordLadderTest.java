package org.codecraftlabs.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class WordLadderTest {
    private WordLadder wordLadder = new WordLadder();

    @Test
    void testCase001() {
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        wordLadder.ladderLength("hit", "cog", wordList);
    }
}
