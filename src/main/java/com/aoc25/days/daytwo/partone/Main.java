package com.aoc25.days.daytwo.partone;

import com.aoc25.io.input.refined.api.InputManipulator;
import com.aoc25.io.input.refined.Input;

public class Main {

    private InputManipulator _input;

    public Main() {
        _input = new Input("input/puzzle/DayTwo.txt");
    }

    public static void main(String[] args) {
        Main dayTwo = new Main();
        long validNumberCount = 0;
        for (String line : dayTwo._input.splitBySeparator(",")) {
            validNumberCount += new NumberAnalyzer(line.split("-")[0], line.split("-")[1]).getValidNumberCount();
        }
        System.out.println("Valid number count: " + validNumberCount);
    }
}
