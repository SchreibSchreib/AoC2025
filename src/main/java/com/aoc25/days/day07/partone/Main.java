package com.aoc25.days.day07.partone;

import com.aoc25.io.input.refined.api.InputManipulator;

import com.aoc25.io.input.refined.Input;

public class Main {

    private InputManipulator _input;

    public Main() {
        _input = new Input("input/puzzle/DaySeven.txt");
    }

    public static void main(String[] args) {
        Main main = new Main();
        BeamMapAnalyzer beamMapBuilder = new BeamMapAnalyzer(main._input.getLinesDeque());
        System.out.println("Result: " + beamMapBuilder.getResult());
    }
}