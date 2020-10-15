package org.codecraftlabs.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int steps = 0;

        List<Node> nodes = createNodes(wordList);
        List<String> startingString = getNextWords(beginWord, wordList);
        Optional<Node> startNodeOpt = nodes.stream().filter(item -> item.getWord().equals(startingString.get(0))).findFirst();

        if (startNodeOpt.isPresent()) {
            Node startingNode = startNodeOpt.get();
        }

        return steps;
    }

    private List<Node> createNodes(List<String> wordList) {
        List<Node> nodes = new ArrayList<>();
        for (String word : wordList) {
            Node node = new Node(word);
            nodes.add(node);
        }

        // for each node create the neighbor items
        for (Node item : nodes) {
            String word = item.getWord();
            List<String> others = getNextWords(word, wordList);
            for (String other : others) {
                Optional<Node> node = nodes.stream().filter(element -> element.getWord().equals(other)).findFirst();
                node.ifPresent(item::addNode);
            }
        }
        return nodes;
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
