package org.codecraftlabs.leetcode.palindrome;

import javax.annotation.Nonnull;

public class PalindromeValidator {
    public boolean isValid(@Nonnull String input) {
        int left = 0;
        int right = input.length() - 1;
        while(left < right) {
            while (left < right && !Character.isLetterOrDigit(input.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(input.charAt(right))) {
                right--;
            }

            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }
}
