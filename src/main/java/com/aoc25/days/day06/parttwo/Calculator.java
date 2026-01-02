package com.aoc25.days.day06.parttwo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Calculator {

    private final long _result;
    private final Deque<Integer> _indexOfOperators = new ArrayDeque<>();
    private final Deque<Character> _operators = new ArrayDeque<>();
    private final Deque<List<Integer>> _intsToCalculate;

    public Calculator(char[][] input) {
        getIndexOfOperators(input);
        _intsToCalculate = getIntsToCalculate(input);
        _result = calculateResult();
    }

    private long calculateResult() {
        long result = 0;
        while (!_intsToCalculate.isEmpty()) {
            List<Integer> currentInts = _intsToCalculate.pop();
            Character operator = _operators.pop();
            if (operator == '+') {
                result += sum(currentInts.toArray(new Integer[0]));
            } else {
                result += multiply(currentInts.toArray(new Integer[0]));
            }

        }
        return result;
    }

    private Deque<List<Integer>> getIntsToCalculate(char[][] input) {
        Deque<List<Integer>> intsToCalculate = new ArrayDeque<>();
        while (!_indexOfOperators.isEmpty()) {
            List<Integer> currentInts = buildNumbers(_indexOfOperators.removeLast(), input);
            intsToCalculate.push(currentInts);
        }
        return intsToCalculate;
    }

    private List<Integer> buildNumbers(Integer indexX, char[][] input) {
        List<Integer> numbers = new ArrayList<>();
        if (_indexOfOperators.isEmpty()) {
            return buildLastNumber(indexX, input[0].length, input);
        }
        Integer stopIndex = _indexOfOperators.peekLast() - 1;

        for (; indexX < stopIndex; indexX++) {
            StringBuilder currentNumber = new StringBuilder();
            for (int indexY = 0; indexY < input.length - 1; indexY++) {
                char currentChar = input[indexY][indexX];
                if (Character.isDigit(currentChar)) {
                    currentNumber.append(currentChar);
                }
            }
            numbers.add(Integer.parseInt(currentNumber.toString()));
        }
        return numbers;
    }

    private List<Integer> buildLastNumber(Integer indexX, int stopIndex, char[][] input) {
        List<Integer> numbers = new ArrayList<>();

        for (; indexX < stopIndex; indexX++) {
            StringBuilder currentNumber = new StringBuilder();
            for (int indexY = 0; indexY < input.length - 1; indexY++) {
                char currentChar = input[indexY][indexX];
                if (Character.isDigit(currentChar)) {
                    currentNumber.append(currentChar);
                }
            }
            numbers.add(Integer.parseInt(currentNumber.toString()));
        }
        return numbers;

    }

    private void getIndexOfOperators(char[][] input) {
        int lastLineOfMatrix = input.length - 1;

        for (int index = 0; index < input[lastLineOfMatrix].length; index++) {
            char currentChar = input[lastLineOfMatrix][index];
            if (currentChar == '+' || currentChar == '*') {
                _operators.push(currentChar);
                _indexOfOperators.push(index);
            }
        }
    }

    private long multiply(Integer[] numbers) {
        long result = 1;
        for (Integer number : numbers) {
            result *= number;
        }
        return result;
    }

    private long sum(Integer[] numbers) {
        long result = 0;
        for (Integer number : numbers) {
            result += number;
        }
        return result;
    }

    public long getResult() {
        return _result;
    }
}
