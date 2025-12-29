package com.aoc25.days.daythree.parttwo;

public class LineAnalyzer {

    private final String _line;
    private final Long _result;
    private final int _joltageLength = 12;
    private final int _lineLength;

    public LineAnalyzer(String line) {
        _line = line;
        _lineLength = line.length();
        _result = analyzeLine();
    }

    private Long analyzeLine() {
        int numbersToRemove = _lineLength - _joltageLength;
        char[] finishedNumber = new char[_lineLength];
        int resultSize = 0;

        for (int index = 0; index < _lineLength; index++) {
            char currentChar = _line.charAt(index);

            while(numbersToRemove > 0 && resultSize > 0 && finishedNumber[resultSize - 1] < currentChar) {
                resultSize--;
                numbersToRemove--;
            }
            finishedNumber[resultSize] = currentChar;
            resultSize++;
        }
        resultSize -= numbersToRemove;

        return Long.parseLong(new String(finishedNumber, 0, _joltageLength));
    }

    public Long getResult() {
        return _result;
    }
}
