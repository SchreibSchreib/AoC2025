package com.aoc25.days.day06.parttwo;

import com.aoc25.io.input.refined.api.InputManipulator;

import com.aoc25.io.input.refined.Input;

public class Main {

    private InputManipulator _input;

    public Main() {
        _input = new Input("input/puzzle/DaySix.txt");
    }

    public static void main(String[] args) {
        Main main = new Main();
        char[][] input = main._input.getCharMatrix();
        Calculator calculator = new Calculator(input);
        System.out.println(calculator.getResult());
    }
}
