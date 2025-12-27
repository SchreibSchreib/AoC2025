package com.aoc25.days.daytwo.partone;

import com.aoc25.io.input.refined.api.InputManipulator;
import com.aoc25.io.input.refined.Input;

public class Main {

    private InputManipulator _input;

    public Main() {
        _input = new Input("input/test/DayTwo.txt");
    }

    public static void main(String[] args) {
        Main dayTwo = new Main();
        for (String line : dayTwo._input.splitBySeparator(",")) {
            System.out.println(line);
        }
    }
}
