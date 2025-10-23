package org.codecraftlabs.leetcode;

import javax.annotation.CheckForNull;

class AlternateCharsVerifier {
    boolean isStringWithAlternatingCharacters(@CheckForNull String input) {
        if (input == null || input.isBlank()) {
            return true;
        }

        int previousChar = input.charAt(0);
        for (int index = 1; index < input.length(); index++) {
            char currentChar = input.charAt(index);
            if (currentChar == previousChar) {
                return false;
            }
            previousChar = currentChar;
        }
        return true;
    }
}
