package com.aoc25.days.day08.partone;

import com.aoc25.io.input.refined.api.InputManipulator;

import com.aoc25.io.input.refined.Input;

public class Main {

    private InputManipulator _input;

    public Main() {
        _input = new Input("input/test/DayEight.txt");
    }

    public static void main(String[] args) {
        Main main = new Main();
        PathAnalyzer analyzer = new PathAnalyzer(main._input.getLines());
        System.out.println("Result: " + analyzer);
    }
}