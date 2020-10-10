package org.codecraftlabs.leetcode;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class ValidParentheses {
    private final Map<Character, Character> symbolMapping = new HashMap<>();

    public ValidParentheses() {
        symbolMapping.put(']', '[');
        symbolMapping.put('}', '{');
        symbolMapping.put(')', '(');
    }

    public boolean isValid(String input) {
        if (input == null || input.isEmpty()) {
            return true;
        }

        if (input.length() % 2 == 1) {
            return false;
        }

        var allowedChars = new ArrayList<>(symbolMapping.keySet());
        allowedChars.addAll(symbolMapping.values());
        if (! containsOnlyValidCharacters(input, allowedChars)) {
            return false;
        }

        var characters = convert(input);
        var stack = new Stack<Character>();
        for (var character: characters) {
            if (isOpeningSymbol(character)) {
                stack.push(character);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                var latest = stack.pop();
                var expected = symbolMapping.get(character);
                if (!latest.equals(expected)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isOpeningSymbol(@Nonnull Character item) {
        var openingSymbols = symbolMapping.values();
        return openingSymbols.contains(item);
    }

    private List<Character> convert(@Nonnull String input) {
        var result = new LinkedList<Character>();
        for (char letter : input.toCharArray()) {
            result.add(letter);
        }
        return result;
    }

    private boolean containsOnlyValidCharacters(String input, Collection<Character> validItems) {
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
