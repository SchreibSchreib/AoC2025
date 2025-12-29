package com.aoc25.days.day01.partone;

import com.aoc25.io.input.refined.api.InputManipulator;
import com.aoc25.io.input.refined.Input;

public class Main {
    
    private InputManipulator _input;

    public Main() {
        _input = new Input("input/puzzle/DayOne.txt");
    }

    public static void main(String[] args) {
        Main dayOne = new Main();
        System.out.println(new RotationAnalyzer(dayOne._input.getLines()).getDialPositionHitsZero());
    }
}
