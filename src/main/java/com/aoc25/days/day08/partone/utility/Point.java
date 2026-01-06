package com.aoc25.days.day08.partone.utility;

public class Point {

    private final double _x;
    private final double _y;
    private final double _z;
    private String _circuitName;

    private boolean _isInCircuit = false;

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

    public void setCircuitName(String circuitName) {
        _circuitName = circuitName;
    }

    public String getCircuitName() {
        if (!_isInCircuit) {
            return "No Circuit";
        }
        return _circuitName;
    }

    public void turnCircuitStatusOn() {
        _isInCircuit = true;
    }

    public void turnCircuitStatusOff() {
        _isInCircuit = false;
    }

    public boolean isInCircuit() {
        return _isInCircuit;
    }
}