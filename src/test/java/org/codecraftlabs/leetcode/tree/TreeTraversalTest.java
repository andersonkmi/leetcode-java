package org.codecraftlabs.leetcode.tree;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class TreeTraversalTest {
    private TreeTraversal treeTraversal;

    @BeforeEach
    public void setup() {
        this.treeTraversal = new TreeTraversal();
    }

    @Test
    public void multipleLayeredTest() {
        BinaryTree tree = createSampleBinaryTree();
        var result = treeTraversal.traverse(tree);
        Assertions.assertThat(result).isNotEmpty();

        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> rootLevelValues = List.of(1);
        List<Integer> levelOneValues = List.of(2, 3);
        List<Integer> levelTwoValues = List.of(4, 5);
        expected.add(rootLevelValues);
        expected.add(levelOneValues);
        expected.add(levelTwoValues);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void simpleLayeredTest() {
        BinaryTree tree = createSampleBinaryTree();
        var result = treeTraversal.simpleTraversal(tree);
        Assertions.assertThat(result).isNotEmpty();

        List<Integer> expected = List.of(1, 2, 3, 4, 5);
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Nonnull
    private BinaryTree createSampleBinaryTree() {
        // Create a binary tree:
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5
        Node root = new Node(1);
        root.setLeft(new Node(2));
        root.setRight(new Node(3));
        root.getLeft().setLeft(new Node(4));
        root.getLeft().setRight(new Node(5));
        return new BinaryTree(root);
    }
}
