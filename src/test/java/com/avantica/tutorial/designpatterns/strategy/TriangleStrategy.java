package com.avantica.tutorial.designpatterns.strategy;

public class TriangleStrategy implements Strategy {
    public double calculateArea(double base, double height) {
        return base * height / 2.0;
    }
}
