package org.codecraftlabs.leetcode;

import java.math.BigDecimal;

public class MultiplyStrings {
    public String multiply(String number1, String number2) {
        BigDecimal value1 = convert(number1);
        BigDecimal value2 = convert(number2);
        BigDecimal total = value1.multiply(value2);
        return total.toString();
    }

    private BigDecimal convert(String number) {
        var buffer = new StringBuilder(number);
        var reversed = buffer.reverse().toString();

        long total = 0;
        for (int index = 0; index < reversed.length(); index++) {
            int asciiValue = reversed.charAt(index);
            long numValue = asciiValue - 48;
            total += numValue * Math.pow(10, index);
        }
        return BigDecimal.valueOf(total);
    }
}
