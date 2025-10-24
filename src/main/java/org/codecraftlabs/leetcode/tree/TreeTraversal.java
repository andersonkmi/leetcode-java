package org.codecraftlabs.leetcode.tree;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

public class TreeTraversal {
    public List<List<Integer>> traverse(@Nonnull BinaryTree tree) {
        List<List<Integer>> results = new ArrayList<>();
        if (tree.getRoot() == null) {
            return results;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.offer(tree.getRoot());

        while (!nodes.isEmpty()) {
            int size = nodes.size();
            List<Integer> numbersCurrentLevel = new ArrayList<>();
            results.add(numbersCurrentLevel);
            for (int index = 0; index < size; index++) {
                Optional<Node> currentNode = Optional.ofNullable(nodes.poll());
                if (currentNode.isEmpty()) {
                    continue;
                }

                numbersCurrentLevel.add(currentNode.get().getValue());

                if (currentNode.get().getLeft() != null) {
                    nodes.offer(currentNode.get().getLeft());
                }

                if (currentNode.get().getRight() != null) {
                    nodes.offer(currentNode.get().getRight());
                }
            }
        }

        return results;
    }

    public List<Integer> simpleTraversal(@Nonnull BinaryTree tree) {
        List<Integer> results = new ArrayList<>();
        if (tree.getRoot() == null) {
            return results;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.offer(tree.getRoot());

        while (!nodes.isEmpty()) {
            int size = nodes.size();
            for (int index = 0; index < size; index++) {
                Optional<Node> currentNode = Optional.ofNullable(nodes.poll());
                if (currentNode.isEmpty()) {
                    continue;
                }

                // Inserts the current value into the resulting list
                results.add(currentNode.get().getValue());

                // Adds the child nodes to be processed later
                if (currentNode.get().getLeft() != null) {
                    nodes.offer(currentNode.get().getLeft());
                }

                if (currentNode.get().getRight() != null) {
                    nodes.offer(currentNode.get().getRight());
                }
            }
        }

        return results;
    }
}
