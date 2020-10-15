package org.codecraftlabs.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {
    private final String word;
    private List<Node> nodes = new ArrayList<>();

    Node(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public List<Node> getNodes() {
        return nodes;
    }

    @Override
    public int hashCode() {
        return word.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (!getClass().equals(other.getClass())) {
            return false;
        }

        Node instance = (Node) other;

        return Objects.equals(this.word, instance.word);
    }
}