package org.codecraftlabs.leetcode.mutiplication;

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

        BigDecimal total = BigDecimal.ZERO;
        BigDecimal value = new BigDecimal(10);
        for (int index = 0; index < reversed.length(); index++) {
            int asciiValue = reversed.charAt(index);
            long numValue = asciiValue - 48;
            total = total.add(value.pow(index).multiply(new BigDecimal(numValue)));
        }
        return total;
    }
}
