package com.aoc25.days.day04.partone;

import com.aoc25.io.input.refined.api.InputManipulator;
import com.aoc25.io.input.refined.Input;

public class Main {

    private InputManipulator _input;

    public Main() {
        _input = new Input("input/puzzle/DayFour.txt");
    }

    public static void main(String[] args) {
        Main main = new Main();
        char[][] matrix = main._input.getCharMatrix();
        int result = new MatrixAnalyzer(matrix).getResult();
        System.out.println("Result: " + result);
    }
}