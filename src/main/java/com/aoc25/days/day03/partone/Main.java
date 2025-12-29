package com.aoc25.days.day03.partone;

import com.aoc25.io.input.refined.api.InputManipulator;
import com.aoc25.io.input.refined.Input;

public class Main {

    private InputManipulator _input;

    public Main() {
        _input = new Input("input/puzzle/DayThree.txt");
    }

    public static void main(String[] args) {
        Main dayThree = new Main();
        int result = 0;
        for (String line : dayThree._input.getLines()) {
            result += new LineAnalyzer(line).getResult();
        }
        System.out.println("Total joltage: " + result);
    }
}
