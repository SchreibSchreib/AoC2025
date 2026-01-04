package com.aoc25.days.day08.partone.utility;

public class Point {
    
    private final double _x;
    private final double _y;
    private final double _z;

    public Point(double x, double y, double z) {
        _x = x;
        _y = y;
        _z = z;
    }

    public double getDistanceToOtherPoint(Point otherPoint) {
        double distanceX = otherPoint._x - this._x;
        double distanceY = otherPoint._y - this._y;
        double distanceZ = otherPoint._z - this._z;

        return Math.sqrt(distanceX * distanceX + distanceY * distanceY + distanceZ * distanceZ);
    }
}