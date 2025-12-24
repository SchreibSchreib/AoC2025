package com.aoc25.days.dayone.partone;

import java.util.List;

public class RotationAnalyzer {

    private final int _dialStartingPoint = 50;
    private final int _dialEndingPoint = 100;
    private int _dialPositionHitsZero = 0;

    public RotationAnalyzer(List<String> rotationLines) {
        _dialPositionHitsZero = analyzeRotations(rotationLines);
    }

    private int analyzeRotations(List<String> rotationLines) {
        int hitsZeroCount = 0;
        int currentPosition = _dialStartingPoint;

        for (String line : rotationLines) {
            char direction = line.charAt(0);
            int degrees = Integer.parseInt(line.substring(1));
            if (direction == 'L') {
                currentPosition = (currentPosition - degrees) % _dialEndingPoint;
                if (currentPosition < 0) {
                    currentPosition += _dialEndingPoint;
                } else if (currentPosition == 0)
                    hitsZeroCount++;
            } else {
                currentPosition = (currentPosition + degrees) % _dialEndingPoint;
                if (currentPosition == 0)
                    hitsZeroCount++;
            }
        }
        return hitsZeroCount;
    }

    public int getDialPositionHitsZero() {
        return _dialPositionHitsZero;
    }
}
