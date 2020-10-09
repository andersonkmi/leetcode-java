package org.codecraftlabs.leetcode;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ValidParentheses {
    private final Map<Character, Character> symbolMapping = new HashMap<>();
    private final char[] validChars = {'(', ')', '[', ']', '{', '}'};

    public ValidParentheses() {
        symbolMapping.put('[', ']');
        symbolMapping.put('{', '}');
        symbolMapping.put('(', ')');
    }

    public boolean isValid(String input) {
        if (input == null || input.isEmpty()) {
            return true;
        }

        // Convert input string into a list of Characters
        var characters = convert(input);

        if (! containsOnlyValidCharacters(input, validChars)) {
            return false;
        }

        return false;
    }

    private List<Character> convert(@Nonnull String input) {
        var result = new LinkedList<Character>();
        for (char letter : input.toCharArray()) {
            result.add(letter);
        }
        return result;
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
