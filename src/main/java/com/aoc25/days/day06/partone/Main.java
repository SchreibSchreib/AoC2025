package com.aoc25.days.day06.partone;

import com.aoc25.io.input.refined.api.InputManipulator;

import java.util.List;

import com.aoc25.io.input.refined.Input;

public class Main {

    private InputManipulator _input;

    public Main() {
        _input = new Input("input/puzzle/DaySix.txt");
    }

    public static void main(String[] args) {
        Main main = new Main();
        List<String> input = main._input.getLines();
        long result = new Calculator(input).getResult();
        System.out.println("Result: " + result);
    }
}