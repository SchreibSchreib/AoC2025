package com.aoc25.days.day08.partone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aoc25.days.day08.partone.utility.Point;

public class PathAnalyzer {

    private final List<Point> _points;
    private final Map<String, List<Point>> _circuits = new HashMap<>();
    private int _nextCircuitId = 1;
    private final long _result;

    public PathAnalyzer(List<String> input) {
        _points = parseInput(input);
        _result = analyzePaths();
    }

    private long analyzePaths() {
        int iterator = 0;
        for (Point firstPoint : _points) {
            if (iterator++ == 10){
                break;
            }
            double closestDistance = Double.MAX_VALUE;
            Point closestPoint = null;
            for (Point secondPoint : _points) {
                if (firstPoint == secondPoint) {
                    continue;
                }
                double currentDistance = firstPoint.getDistanceToOtherPoint(secondPoint);
                if (currentDistance < closestDistance) {
                    closestDistance = currentDistance;
                    closestPoint = secondPoint;
                }
            }
            loadCircuits(firstPoint, closestPoint);
        }
        return 1l;
    }

    private void loadCircuits(Point firstPoint, Point closestPoint) {
        if (firstPoint.isInCircuit() && closestPoint.isInCircuit()) {
            String firstPointCircuitName = firstPoint.getCircuitName();
            String closestPointCircuitName = closestPoint.getCircuitName();
            if (firstPointCircuitName.equals(closestPointCircuitName)) {
                return;
            }
            mergeCircuits(firstPointCircuitName, closestPointCircuitName);
        } else if (firstPoint.isInCircuit()) {
            addPointToCircuit(firstPoint, closestPoint);
        } else if (closestPoint.isInCircuit()) {
            addPointToCircuit(closestPoint, firstPoint);
        } else {
            createNewCircuit(firstPoint, closestPoint);
        }
    }

    private void createNewCircuit(Point firstPoint, Point closestPoint) {
        String circuitName = "Circuit_" + (_nextCircuitId++);
        firstPoint.setCircuitName(circuitName);
        closestPoint.setCircuitName(circuitName);
        firstPoint.turnCircuitStatusOn();
        closestPoint.turnCircuitStatusOn();
        loadToMap(firstPoint, closestPoint);
    }

    private void loadToMap(Point firstPoint, Point closestPoint) {
        List<Point> pointsToLoad = new ArrayList<>();
        pointsToLoad.add(firstPoint);
        pointsToLoad.add(closestPoint);
        _circuits.put(firstPoint.getCircuitName(), pointsToLoad);
    }

    private void addPointToCircuit(Point pointInCircuit, Point pointWithoutCircuit) {
        String circuitName = pointInCircuit.getCircuitName();
        pointWithoutCircuit.setCircuitName(circuitName);
        pointWithoutCircuit.turnCircuitStatusOn();
        _circuits.get(circuitName).add(pointWithoutCircuit);
    }

    private void mergeCircuits(String firstPointCircuitName, String closestPointCircuitName) {
        List<Point> circuitFirstPoint = _circuits.get(firstPointCircuitName);
        List<Point> circuitClosestPoint = _circuits.get(closestPointCircuitName);

        if (circuitFirstPoint.size() <= circuitClosestPoint.size()) {
            merge(circuitFirstPoint, circuitClosestPoint);
        } else {
            merge(circuitClosestPoint, circuitFirstPoint);
        }
    }

    private void merge(List<Point> smallerList, List<Point> biggerList) {
        String oldCircuitName = smallerList.getFirst().getCircuitName();
        String newCircuitName = biggerList.getFirst().getCircuitName();
        for (Point point : smallerList) {
            point.setCircuitName(newCircuitName);
            point.turnCircuitStatusOn();
        }
        _circuits.remove(oldCircuitName);
        _circuits.get(newCircuitName).addAll(smallerList);
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
