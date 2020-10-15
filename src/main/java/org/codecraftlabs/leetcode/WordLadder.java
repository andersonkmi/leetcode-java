package org.codecraftlabs.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        // Creates the graph with the existing dictionary words
        List<Node> nodes = createNodes(wordList);

        // this implementation assumes it has one and only one possible starting node
        // Retrieves the starting node
        List<String> startingString = getNextWords(beginWord, wordList);
        Optional<Node> startNodeOpt = nodes.stream().filter(item -> item.getWord().equals(startingString.get(0))).findFirst();

        // Retrieves the end node
        Optional<Node> endNodeOpt = nodes.stream().filter(item -> item.getWord().equals(endWord)).findFirst();

        int steps = 0;
        if (startNodeOpt.isPresent() && endNodeOpt.isPresent()) {
            Node startNode = startNodeOpt.get();
            Node endNode = endNodeOpt.get();

            LinkedList<Node> nextToVisit = new LinkedList<>();
            nextToVisit.add(startNode);

            while(!nextToVisit.isEmpty()) {
                Node currentNode = nextToVisit.remove();
                if (currentNode.equals(endNode)) {
                    break;
                }

                if (currentNode.isVisited()) {
                    continue;
                }
                currentNode.setIsVisited(true);

                nextToVisit.addAll(currentNode.getNodes());
                steps++;
            }
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
