package com.avantica.tutorial.designpatterns.strategy;

public class RectangleStrategy implements Strategy {
    public double calculateArea(double width, double height) {
        return width * height;
    }
}
