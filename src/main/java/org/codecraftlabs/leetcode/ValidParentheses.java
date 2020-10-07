package org.codecraftlabs.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ValidParentheses {
    public boolean isValid(String input) {
        if (input == null || input.isEmpty()) {
            return true;
        }

        char[] validChars = {'(', ')', '[', ']', '{', '}'};
        if (! containsOnlyValidCharacters(input, validChars)) {
            return false;
        }

        return false;
    }

    private boolean containsOnlyValidCharacters(String input, char[] validChars) {
        List<Character> validItems = new ArrayList<>();
        for (char item : validChars) {
            validItems.add(item);
        }

        var elements = input
                                        .chars()
                                        .mapToObj(item -> (char) item)
                                        .collect(Collectors.toList())
                                        .stream()
                                        .distinct().collect(Collectors.toList());

        for (Character item : elements) {
            if (! validItems.contains(item)) {
                return false;
            }
        }
        return true;
    }
}
