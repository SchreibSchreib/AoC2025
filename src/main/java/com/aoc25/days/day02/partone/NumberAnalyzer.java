package com.aoc25.days.day02.partone;

import java.util.ArrayList;
import java.util.List;

public class NumberAnalyzer {

    private final String _startNumber;
    private final String _startNumberFirstHalf;
    private final String _endNumber;
    private final long _validNumberCount;

    public NumberAnalyzer(String startNumber, String endNumber) {
        _startNumber = startNumber;
        _startNumberFirstHalf = String.valueOf(Math.max(1, startNumber.length() / 2));
        _endNumber = endNumber;
        _validNumberCount = analyzeNumbers();
    }

    private long analyzeNumbers() {
        var numberRange = getValidNumbers(_startNumberFirstHalf);
        return sumNumbers(numberRange);
    }

    private long sumNumbers(List<Long> numberRange) {
        long sum = 0;
        for (Long number : numberRange) {
            sum += number;
        }
        return sum;
    }

    private List<Long> getValidNumbers(String startNumberFirstHalf) {
        List<Long> validNumbers = new ArrayList<>();
        Long start = Long.parseLong(_startNumber);
        Long end = Long.parseLong(_endNumber);

        while (true) {
            Long candidate = Long.parseLong(startNumberFirstHalf + startNumberFirstHalf);
            if (candidate > end) {
                break;
            }
            if (candidate >= start) {
                validNumbers.add(candidate);
                System.out.println("Valid number: " + startNumberFirstHalf + startNumberFirstHalf);
            }
            startNumberFirstHalf = String.valueOf(Long.parseLong(startNumberFirstHalf) + 1);
        }
        return validNumbers;
    }

    public long getValidNumberCount() {
        return _validNumberCount;
    }
}
