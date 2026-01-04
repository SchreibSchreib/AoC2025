package com.aoc25.days.day07.parttwo;

import com.aoc25.io.input.refined.api.InputManipulator;

import com.aoc25.io.input.refined.Input;

public class Main {

    private InputManipulator _input;

    public Main() {
        _input = new Input("input/puzzle/DaySeven.txt");
    }

    public static void main(String[] args) {
        Main main = new Main();
        TimeLineAnalyzer analyzer = new TimeLineAnalyzer(main._input.getCharMatrix());
        System.out.println("Result: " + analyzer.getResult());
    }
}
