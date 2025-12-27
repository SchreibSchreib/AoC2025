package com.aoc25.io.input.refined;

import java.util.Deque;
import java.util.List;
import java.util.ArrayDeque;
import java.util.ArrayList;

import com.aoc25.io.input.raw.RessourceInput;
import com.aoc25.io.input.raw.api.InputSource;

import com.aoc25.io.input.refined.api.InputManipulator;

public class Input implements InputManipulator {

    private final InputSource _inputSource;
    private final String _inputText;
    private final List<String> _inputLines;

    public Input(String inputSource) {
        _inputSource = new RessourceInput(inputSource);
        _inputText = _inputSource.readInput();
        _inputLines = _inputText.lines().toList();
    }

    @Override
    public String getText() {
        return _inputText;
    }

    @Override
    public List<String> getLines() {
        return _inputLines;
    }

    @Override
    public List<String> splitBySeparator(String separator) {
        List<String> separatorList = new ArrayList<>();
        for (String line : _inputLines) {
            String[] splitLines = line.split(separator);
            for (String splitLine : splitLines) {
                separatorList.add(splitLine);
            }
        }
        return separatorList;
    }

    @Override
    public Deque<String> getLinesDeque() {
        Deque<String> linesDeque = new ArrayDeque<>();
        for (String line : getLines()) {
            linesDeque.add(line);
        }
        return linesDeque;
    }

    @Override
    public char[][] getCharMatrix() {
        String[] lines = _inputText.split("\n");
        int rowCount = lines.length;
        int colCount = lines[0].length();

        char[][] charMatrix = new char[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            charMatrix[i] = lines[i].toCharArray();
        }
        return charMatrix;
    }
}
