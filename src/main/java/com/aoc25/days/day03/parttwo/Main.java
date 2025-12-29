package com.aoc25.days.day03.parttwo;

import com.aoc25.io.input.refined.api.InputManipulator;
import com.aoc25.io.input.refined.Input;

public class Main {

    private InputManipulator _input;

    public Main() {
        _input = new Input("input/puzzle/DayThree.txt");
    }

    public static void main(String[] args) {
        Main main = new Main();
        Long result = 0L;
        for (String line : main._input.getLines()) {
            result += new LineAnalyzer(line).getResult();
        }
        System.out.println("The result is: " + result);
    }
}
