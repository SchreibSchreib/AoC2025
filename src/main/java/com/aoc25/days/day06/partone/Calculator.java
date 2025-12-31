package com.aoc25.days.day06.partone;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private long _result;

    public Calculator(List<String> input) {
        List<Integer[]> intsToCalculate = convertToIntegers(input);
        intsToCalculate = rearrangeNumbers(intsToCalculate);
        char[] operations = getOperations(input);
        _result = calculate(intsToCalculate, operations);
    }

    private long calculate(List<Integer[]> intsToCalculate, char[] operations) {
        long result = 0;
        for (int index = 0; index < operations.length; index++){
            char operation = operations[index];
            Integer[] numbers = intsToCalculate.get(index);
            switch (operation) {
                case '+' -> result += sum(numbers);
                case '*' -> result += multiply(numbers);
            }
        }
        return result;
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

    private char[] getOperations(List<String> input) {
        return input.getLast()
                .replaceAll("\\s+", "")
                .toCharArray();
    }

    private List<Integer[]> rearrangeNumbers(List<Integer[]> intsToCalculate) {
        List<Integer[]> rearrangedNumbers = getNewMatrix(intsToCalculate);
        for (int indexY = 0; indexY < intsToCalculate.size(); indexY++) {
            Integer[] newRow = intsToCalculate.get(indexY);
            for (int indexX = 0; indexX < newRow.length; indexX++) {
                rearrangedNumbers.get(indexX)[indexY] = newRow[indexX];
            }
        }
        return rearrangedNumbers;

    }

    private List<Integer[]> getNewMatrix(List<Integer[]> intsToCalculate) {
        List<Integer[]> newMatrix = new ArrayList<>();
        int numberOfRows = intsToCalculate.get(0).length;
        for (int column = 0; column < numberOfRows; column++) {
            Integer[] newColumn = new Integer[intsToCalculate.size()];
            newMatrix.add(newColumn);
        }
        return newMatrix;
    }

    private List<Integer[]> convertToIntegers(List<String> input) {
        List<Integer[]> result = new ArrayList<>();
        for (int i = 0; i < input.size() - 1; i++) {
            String line = input.get(i).trim().replaceAll("\\s+", " ");
            String[] parts = line.split(" ");
            Integer[] numbers = new Integer[parts.length];
            for (int j = 0; j < parts.length; j++) {
                numbers[j] = Integer.parseInt(parts[j]);
            }
            result.add(numbers);
        }
        return result;
    }

    public long getResult() {
        return _result;
    }
}
