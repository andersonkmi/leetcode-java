package org.codecraftlabs.leetcode;

import java.util.ArrayList;
import java.util.List;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        int steps = 0;
        boolean found = false;

        while (!found) {

        }
        List<String> nextSteps = getNextWords(beginWord, wordList);

        return steps;
    }

    private List<String> getNextWords(String word, List<String> wordList) {
        List<String> results = new ArrayList<>();
        for (String item : wordList) {
            if (differentChars(word, item) == 1) {
                results.add(item);
            }
        }
        return results;
    }

    private int differentChars(String str1, String str2) {
        int total = 0;
        for (int index = 0; index < str1.length(); index++) {
            if (str1.charAt(index) != str2.charAt(index)) {
                total++;
            }
        }
        return total;
    }
}
