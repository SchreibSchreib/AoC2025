package com.aoc25.days.daytwo.parttwo;

import java.util.ArrayList;
import java.util.List;

public class NumberAnalyzer {

    private final String _startNumber;
    private final List<Integer> _allPossibleDivisors;
    private final String _endNumber;
    private final long _validNumberCount;

    public NumberAnalyzer(String startNumber, String endNumber) {
        _startNumber = startNumber;
        _endNumber = endNumber;
        _allPossibleDivisors = getPossibleDivisors(_endNumber.length());
        _validNumberCount = analyzeNumbers();
    }

    private List<Integer> getPossibleDivisors(int length) {
        int limit = (int) Math.sqrt(length);
        List<Integer> divisors = new ArrayList<>();

        for (int start = 1; start <= limit; start++) {
            if (length % start == 0) {
                int firstDivisor = start;
                int secondDivisor = length / start;

                if (firstDivisor < length)
                    divisors.add(firstDivisor);
                if (secondDivisor < length && secondDivisor != firstDivisor)
                    divisors.add(secondDivisor);
            }
        }
        return divisors;
    }

    private long analyzeNumbers() {
        var numberRange = getValidRange(_allPossibleDivisors);
        return sumNumbers(numberRange);
    }

    private long sumNumbers(List<Long> numberRange) {
        long sum = 0;
        for (Long number : numberRange) {
            sum += number;
        }
        return sum;
    }

    private List<Long> getValidRange(List<Integer> listOfPossibleDivisors) {
        List<Long> validNumbers = new ArrayList<>();
        Long start = Long.parseLong(_startNumber);
        Long end = Long.parseLong(_endNumber);

        return validNumbers;
    }

    public long getValidNumberCount() {
        return _validNumberCount;
    }
}
