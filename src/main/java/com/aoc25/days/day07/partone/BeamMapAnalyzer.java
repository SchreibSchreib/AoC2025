package com.aoc25.days.day07.partone;

import java.util.ArrayDeque;
import java.util.Deque;

public class BeamMapAnalyzer {

    private final Deque<String> _input;
    private int _result;

    public BeamMapAnalyzer(Deque<String> input) {
        _input = input;
        buildAndAnalyzeBeamMap();
    }

    private void buildAndAnalyzeBeamMap() {
        Deque<String> resultDeque = new ArrayDeque<>();
        while (true) {
            if (_input.size() == 1) {
                break;
            }
            String currentLine = _input.pop();
            String nextLine = _input.pop();
            resultDeque.add(buildLineAndUpdateNextLine(currentLine, nextLine));
        }
    }

    private String buildLineAndUpdateNextLine(String currentLine, String nextLine) {
        StringBuilder resultLine = new StringBuilder();
        for (int indexString = 0; indexString < currentLine.length(); indexString++) {
            char currentChar = currentLine.charAt(indexString);
            char nextChar = nextLine.charAt(indexString);
            if (currentChar == '.' || currentChar == '^') {
                resultLine.append('.');
                continue;
            }
            if (currentChar == '|' || currentChar == 'S') {
                if (nextChar == '.') {
                    resultLine.append('|');
                }
                if (nextChar == '^') {
                    resultLine.replace(indexString - 1, indexString, "|^|");
                    indexString++;
                    _result++;
                }

            }
        }
        String result = resultLine.toString();
        adjustNextLine(result);
        return result;
    }

    private void adjustNextLine(String resultLine) {
        _input.addFirst(resultLine);
    }

    public int getResult() {
        return _result;
    }
}
