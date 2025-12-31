package com.aoc25.days.day05.parttwo;

import com.aoc25.io.input.refined.api.InputManipulator;

import java.util.List;

import com.aoc25.io.input.refined.Input;

public class Main {

    private InputManipulator _input;

    public Main() {
        _input = new Input("input/puzzle/DayFive.txt");
    }

    public static void main(String[] args) {
        Main main = new Main();
        List<String> input = main._input.getLines();
        int indexToSplit = input.indexOf("");
        List<String> freshIngredientRanges = input.subList(0, indexToSplit);
        IngredientAnalyzer analyzer = new IngredientAnalyzer(freshIngredientRanges);
        System.out.println("Result: " + analyzer.getResult());
    }
}
