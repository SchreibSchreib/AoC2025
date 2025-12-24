package com.aoc25.days.dayone.parttwo;

import java.util.List;

public class RotationAnalyzer {

    private final int _dialStartingPoint = 50;
    private final int _dialEndingPoint = 100;
    private int _dialPositionHitsZero = 0;

    public RotationAnalyzer(List<String> rotationLines) {
        _dialPositionHitsZero = analyzeRotations(rotationLines);
    }

    private int analyzeRotations(List<String> rotationLines) {
        int ticksToZeroCount = 0;
        int currentPosition = _dialStartingPoint;

        for (String line : rotationLines) {
            char direction = line.charAt(0);
            int degrees = Integer.parseInt(line.substring(1));
            int fullRotations = getFullRotations(direction, degrees, currentPosition);
            if (direction == 'L') {
                if (currentPosition - _dialStartingPoint <= 0) {
                    // Calculate ticks to zero + full rotations * 100
                } else {
                    currentPosition -= degrees;
                    continue;
                }
            } else {
                if (currentPosition + _dialStartingPoint >= 100) {
                    // Calculate ticks to zero + full rotations * 100
                } else {
                    currentPosition += degrees;
                    continue;
                }
            }
        }
        return ticksToZeroCount;
    }

    private int getFullRotations(char direction, int degrees, int currentPosition) {
        if (degrees < 100) {
            return 0;
        }
        if (direction == 'L') {
            return (degrees + (0 - currentPosition)) / 100;
        } else {
            return (degrees - (currentPosition % _dialEndingPoint)) / 100;
        }
    }

    public int getDialPositionHitsZero() {
        return _dialPositionHitsZero;
    }
}
