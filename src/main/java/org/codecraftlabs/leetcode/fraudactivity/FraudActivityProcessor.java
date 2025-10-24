package org.codecraftlabs.leetcode.fraudactivity;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FraudActivityProcessor {
    public int notifyFraudulentExpenditures(List<Integer> expenditures, int trailingDays) {
        int notificationCounter = 0;
        for (int index = trailingDays; index < expenditures.size(); index++) {
            int currentExpenditure = expenditures.get(index);
            var pastExpenditures = createExpenditureList(index - trailingDays, index, expenditures);
            int median = calculateMedian(pastExpenditures);
            int threshold = calculateThreshold(median);
            notificationCounter = incrementNotificationCounter(threshold, currentExpenditure, notificationCounter);
        }
        return notificationCounter;
    }

    @Nonnull
    private List<Integer> createExpenditureList(int start, int end, List<Integer> original) {
        return new ArrayList<>(original.subList(start, end));
    }

    private int calculateThreshold(int referenceValue) {
        return referenceValue * 2;
    }

    private int incrementNotificationCounter(int threshold, int currentExpenditure, int notificationCounter) {
        if (currentExpenditure < threshold) {
            return notificationCounter;
        }
        return notificationCounter + 1;
    }

    private int calculateMedian(@Nonnull List<Integer> numbers) {
        Collections.sort(numbers);
        if (numbers.size() % 2 == 0) {
            int middleIndex = numbers.size() / 2;
            int value1 = numbers.get(middleIndex);
            int value2 = numbers.get(middleIndex - 1);
            return (value1 + value2) / 2;
        }
        int middleIndex = numbers.size() / 2;
        return numbers.get(middleIndex);
    }
}
