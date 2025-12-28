package com.aoc25.days.daythree.partone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LineAnalyzer {

    private final String _line;
    private final int _result;

    public LineAnalyzer(String line) {
        _line = line;
        _result = analyzeLine();
    }

    private int analyzeLine() {
        Map<Integer, List<Integer>> mappedLine = mapLine(_line);
        return constructJoltage(mappedLine);
    }

    private int constructJoltage(Map<Integer, List<Integer>> mappedLine) {
        int builtJoltage = 0;
        for (int key = 9; key > 0; key--) {
            if (!mappedLine.containsKey(key)) {
                continue;
            }
            builtJoltage = buildJoltage(key, mappedLine.get(key));
            break;
        }
        return builtJoltage;
    }

    private int buildJoltage(int key, List<Integer> list) {
        if (list.size() > 1) {
            return Integer.valueOf(key + "" + key);
        }
        int resultLeft = buildNumberLeft(key, list.getFirst());
        int resultRight = buildNumberRight(key, list.getFirst());

        return (resultLeft > resultRight) ? resultLeft : resultRight;
    }

    private int buildNumberRight(int key, Integer index) {
        if (index == _line.length() - 1) {
            return key;
        }
        String result = String.valueOf(key) + "" + 1;
        for (int i = index + 1; i < _line.length(); i++) {
            String tempNumber = result.charAt(0) + "" + _line.charAt(i);
            if (Integer.parseInt(result) < Integer.parseInt(tempNumber)) {
                result = tempNumber;
            }
        }
        return Integer.parseInt(result);
    }

    private int buildNumberLeft(int key, Integer index) {
        if (index == 0) {
            return key;
        }
        String result = 1 + "" + String.valueOf(key);
        for (int i = index - 1; i >= 0; i--) {
            String tempNumber = _line.charAt(i) + "" + result.charAt(1);
            if (Integer.parseInt(result) < Integer.parseInt(tempNumber)) {
                result = tempNumber;
            }
        }
        return Integer.parseInt(result);
    }

    private Map<Integer, List<Integer>> mapLine(String line) {
        Map<Integer, List<Integer>> result = new HashMap<>();

        for (int index = 0; index < line.length(); index++) {
            int key = Integer.parseInt(String.valueOf(line.charAt(index)));
            if (!result.containsKey(key)) {
                result.put(key, new ArrayList<>());
            }
            result.get(key).add(index);
        }
        return result;
    }

    public int getResult() {
        return _result;
    }
}
