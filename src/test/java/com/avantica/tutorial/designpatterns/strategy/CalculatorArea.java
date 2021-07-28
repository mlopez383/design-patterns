package com.avantica.tutorial.designpatterns.strategy;

public class CalculatorArea {
    static final double CONVERSION_FACTOR_METERS_TO_CM = 100;
    private Strategy strategy;
    private double dimensionX;
    private double dimensionY;

    public void setStrategy (Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setDimensions(double dimensionA, double dimensionB){
        this.dimensionX = dimensionA;
        this.dimensionY = dimensionB;
    }

    public double calculateAreaInMeters(){
        return strategy.calculateArea(dimensionX, dimensionY);
    }

    public double calculateAreaInCentimeters(){
        return strategy.calculateArea(dimensionX, dimensionY) * CONVERSION_FACTOR_METERS_TO_CM;
    }

    public double getDimensionX(){
        return dimensionX;
    }

    public double getDimensionY(){
        return dimensionY;
    }
}