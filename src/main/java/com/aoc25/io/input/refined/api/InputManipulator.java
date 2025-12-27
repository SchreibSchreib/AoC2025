package com.aoc25.io.input.refined.api;


import java.util.Deque;
import java.util.List;

public interface InputManipulator {
    public String getText();
    public List<String> getLines();
    public List<String> splitBySeparator(String separator);
    public Deque<String> getLinesDeque();
    public char[][] getCharMatrix();
}
