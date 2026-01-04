package com.aoc25.days.day08.partone;

import java.util.ArrayList;
import java.util.List;

import com.aoc25.days.day08.partone.utility.Point;

public class pathAnalyzer {

    private final List<Point> _points;

    public pathAnalyzer(List<String> input) {
        _points = parseInput(input);
    }

    private List<Point> parseInput(List<String> input) {
        List<Point> points = new ArrayList<>();

        for (String line : input) {
            String[] parts = line.split(",");
            long x = Long.parseLong(parts[0]);
            long y = Long.parseLong(parts[1]);
            long z = Long.parseLong(parts[2]);
            Point newPoint = new Point(x, y, z);   
            points.add(newPoint);
        }
        return points;
    }
}
