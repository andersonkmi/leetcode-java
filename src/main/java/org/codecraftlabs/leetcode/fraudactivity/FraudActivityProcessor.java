package org.codecraftlabs.leetcode.fraudactivity;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FraudActivityProcessor {
    public int notifyFraudulentExpenditures(List<Integer> expenditures, int lookbackDays) {
        int notificationCounter = 0;

        for (int index = lookbackDays; index < expenditures.size(); index++) {
            // Save the current expenditure
            int currentExpenditure = expenditures.get(index);

            // Create a sub-array with size lookbackDays from the current position
            var pastExpenditures = createExpenditureList(index - lookbackDays, index, expenditures);

            // Calculate the median from the array generated
            int median = calculateMedian(pastExpenditures);

            // Calculate the threshold
            int threshold = median * 2;

            // Compare the current expenditure with the threshold and increase the notification counter if necessary
            if (currentExpenditure >= threshold) {
                notificationCounter++;
            }
        }
        return notificationCounter;
    }

    @Nonnull
    private List<Integer> createExpenditureList(int start, int end, List<Integer> original) {
        return new ArrayList<>(original.subList(start, end));
    }

    private int calculateMedian(@Nonnull List<Integer> numbers) {
        Collections.sort(numbers);
        if (numbers.size() % 2 == 0) {
            int middleIndex = numbers.size() / 2;
            int value1 = numbers.get(middleIndex);
            int value2 = numbers.get(middleIndex - 1);

            return (value1 + value2) / 2;
            // calculate the value
        }
        int middleIndex = numbers.size() / 2;
        return numbers.get(middleIndex);
    }
}
