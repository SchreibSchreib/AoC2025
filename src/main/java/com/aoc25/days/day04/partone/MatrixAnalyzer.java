package com.aoc25.days.day04.partone;

public class MatrixAnalyzer {

    private final char[][] _matrix;
    private final int[] _matrixBorderX;
    private final int[] _matrixBorderY;
    private final int _result;

    public MatrixAnalyzer(char[][] matrix) {
        _matrix = matrix;
        _matrixBorderX = new int[] { 0, matrix[0].length - 1 };
        _matrixBorderY = new int[] { 0, matrix.length - 1 };
        _result = analyze();
    }

    private int analyze() {
        int result = 0;
        for (int indexX = 0; indexX < _matrix[0].length; indexX++) {
            for (int indexY = 0; indexY < _matrix.length; indexY++) {
                char currentChar = _matrix[indexY][indexX];
                if (currentChar == '@') {
                    result += broadSearch(indexX, indexY);
                }
            }
        }
        return result;
    }

    private int broadSearch(int indexX, int indexY) {
        int foundObjects = 0;

        for (int x = -1; x <= 1; x++) {
            int fieldToCheckX = indexX + x;

            if (!isFieldInBoundsX(fieldToCheckX))
                continue;

            for (int y = -1; y <= 1; y++) {
                int fieldToCheckY = indexY + y;

                if (!isFieldInBoundsY(fieldToCheckY) || (fieldToCheckX == indexX && fieldToCheckY == indexY))
                    continue;

                if (_matrix[fieldToCheckY][fieldToCheckX] == '@')
                    foundObjects++;
            }
        }
        return (foundObjects < 4) ? 1 : 0;
    }

    private boolean isFieldInBoundsY(int fieldToCheckY) {
        return fieldToCheckY >= _matrixBorderY[0] && fieldToCheckY <= _matrixBorderY[1];
    }

    private boolean isFieldInBoundsX(int index) {
        return index >= _matrixBorderX[0] && index <= _matrixBorderX[1];
    }

    public int getResult() {
        return _result;
    }
}
