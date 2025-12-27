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
        int zeroCounter = 0;
        int actualPosition = _dialStartingPoint;

        for (String line : rotationLines) {
            char direction = line.charAt(0);
            int degrees = Integer.parseInt(line.substring(1).trim());
            int fullRounds = degrees / _dialEndingPoint;
            int remainder = degrees % _dialEndingPoint;

            zeroCounter += fullRounds;

            if (remainder != 0) {
                if (direction == 'L') {
                    if (actualPosition != 0 && remainder >= actualPosition)
                        zeroCounter++;
                    actualPosition = normalizePosition(actualPosition - remainder);
                } else {
                    if (actualPosition != 0 && actualPosition + remainder >= _dialEndingPoint)
                        zeroCounter++;
                    actualPosition = normalizePosition(actualPosition + remainder);
                }
            }
        }
        return zeroCounter;
    }

    private int normalizePosition(int position) {
        return Math.floorMod(position, _dialEndingPoint);
    }

    public int getDialPositionHitsZero() {
        return _dialPositionHitsZero;
    }
}
