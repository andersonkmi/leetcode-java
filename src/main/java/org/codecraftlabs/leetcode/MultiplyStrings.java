package org.codecraftlabs.leetcode;

public class MultiplyStrings {
    public String multiply(String number1, String number2) {
        long value1 = convert(number1);
        long value2 = convert(number2);
        long total = value1 * value2;
        return Long.toString(total);
    }

    private long convert(String number) {
        var buffer = new StringBuilder(number);
        var reversed = buffer.reverse().toString();

        long total = 0;
        for (int index = 0; index < reversed.length(); index++) {
            int asciiValue = reversed.charAt(index);
            int numValue = asciiValue - 48;
            total += numValue * Math.pow(10, index);
        }
        return total;
    }
}
