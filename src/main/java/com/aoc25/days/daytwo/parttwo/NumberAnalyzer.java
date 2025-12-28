package com.aoc25.days.daytwo.parttwo;

import java.util.ArrayList;
import java.util.List;

public class NumberAnalyzer {

    private final String _startNumber;
    private final String _endNumber;
    private final long _validNumberCount;

    public NumberAnalyzer(String startNumber, String endNumber) {
        _startNumber = startNumber;
        _endNumber = endNumber;
        _validNumberCount = analyzeNumbers();
    }

    private long analyzeNumbers() {
        var numberRange = getValidNumbers();
        return sumNumbers(numberRange);
    }

    private long sumNumbers(List<Long> numberRange) {
        long sum = 0;
        for (Long number : numberRange) {
            sum += number;
        }
        return sum;
    }

    private List<Long> getValidNumbers() {
        List<Long> invalidNumbers = new ArrayList<>();

        long start = Long.parseLong(_startNumber);
        long end = Long.parseLong(_endNumber);
        int maxLength = _endNumber.length();

        for (int numberBlockLength = 1; numberBlockLength <= maxLength / 2; numberBlockLength++) {
            for (int repeatCount = 2; numberBlockLength * repeatCount <= maxLength; repeatCount++) {
                invalidNumbers.addAll(build(numberBlockLength, repeatCount, start, end));
            }
        }
        return normalize(invalidNumbers);
    }

    private List<Long> normalize(List<Long> invalidNumbers) {
        List<Long> result = new ArrayList<>();
        for (Long number : invalidNumbers) {
            if (!result.contains(number)) {
                result.add(number);
            }
        }
        return result;
    }

    private List<Long> build(int blockLength,
            int repeatCount,
            long rangeStart,
            long rangeEnd) {

        List<Long> result = new ArrayList<>();

        long smallestBlock = (blockLength == 1) ? 1 : (long) Math.pow(10, blockLength - 1);
        long largestBlock = (long) Math.pow(10, blockLength) - 1;

        for (long blockValue = smallestBlock; blockValue <= largestBlock; blockValue++) {

            String block = Long.toString(blockValue);
            String candidateString = block.repeat(repeatCount);
            long candidate = Long.parseLong(candidateString);

            if (candidate > rangeEnd) {
                break;
            }

            if (candidate >= rangeStart) {
                result.add(candidate);
            }
        }

        return result;
    }

    public long getValidNumberCount() {
        return _validNumberCount;
    }
}
