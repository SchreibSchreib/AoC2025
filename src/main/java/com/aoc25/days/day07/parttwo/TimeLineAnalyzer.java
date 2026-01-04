package com.aoc25.days.day07.parttwo;

public class TimeLineAnalyzer {

    private final char[][] _input;
    private final long[][] _timeLines;
    private final long _result;

    public TimeLineAnalyzer(char[][] input) {
        _input = input;
        _timeLines = new long[_input.length][_input[0].length];
        _result = buildAndAnalyzeBeamMap();
    }

    private long buildAndAnalyzeBeamMap() {
        createInitialBeam();
        for (int indexY = 0; indexY < _timeLines.length - 1; indexY++) {
            for (int indexX = 0; indexX < _timeLines[indexY].length; indexX++) {
                buildMap(indexX, indexY);
            }
        }
        return sumArray(_timeLines[_timeLines.length - 1]);
    }

    private void createInitialBeam() {
        for (int indexX = 0; indexX < _input[0].length; indexX++) {
            if (_input[0][indexX] == 'S') {
                _timeLines[0][indexX] = 1;
                return;
            }

        }
    }

    private long sumArray(long[] lastLine) {
        long sum = 0;
        for (long number : lastLine) {
            sum += number;
        }
        return sum;
    }

    private void buildMap(int indexX, int indexY) {
        long currentTimeLine = _timeLines[indexY][indexX];
        if (currentTimeLine == 0) {
            return;
        }

        char nextSpace = _input[indexY + 1][indexX];

        if (nextSpace == '^') {
            _timeLines[indexY + 1][indexX - 1] += currentTimeLine;
            _timeLines[indexY + 1][indexX + 1] += currentTimeLine;
        } else {
            _timeLines[indexY + 1][indexX] += currentTimeLine;
        }
    }

    public long getResult() {
        return _result;
    }
}
