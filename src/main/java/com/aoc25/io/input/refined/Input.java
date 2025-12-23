package com.aoc25.io.input.refined;

import java.util.Deque;
import java.util.List;
import java.util.ArrayDeque;

import com.aoc25.io.input.raw.RessourceInput;
import com.aoc25.io.input.raw.api.InputSource;

import com.aoc25.io.input.refined.api.InputManipulator;

public class Input implements InputManipulator {

    private final InputSource _inputSource;
    private final String _inputText;

    public Input(String inputSource) {
        _inputSource = new RessourceInput(inputSource);
        _inputText = _inputSource.readInput();
    }

    @Override
    public String getText() {
        return _inputText;
    }

    @Override
    public List<String> getLines() {
        return List.of(_inputText.split("\n"));
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
