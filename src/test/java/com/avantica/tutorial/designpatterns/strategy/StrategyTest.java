package com.avantica.tutorial.designpatterns.strategy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StrategyTest {
    static final double RECTANGLE_WIDTH = 10;
    static final double RECTANGLE_HEIGHT = 11;
    static final double AREA_RECTANGLE_EXPECTED_METERS = 110;
    static final double AREA_RECTANGLE_EXPECTED_CENTIMETERS = 11000;
    static final String RECTANGLE_CLASS_NAME_EXPECTED = "RectangleStrategy";

    static final double TRIANGLE_BASE = 10;
    static final double TRIANGLE_HEIGHT = 12;
    static final double AREA_TRIANGLE_EXPECTED_METERS = 60;
    static final double AREA_TRIANGLE_EXPECTED_CENTIMETERS = 6000;
    static final String TRIANGLE_CLASS_NAME_EXPECTED = "TriangleStrategy";

    private CalculatorArea calculatorArea;

    @Before
    public void initObjects() {
        calculatorArea = new CalculatorArea();
    }

    private void calculateAreaInSeveralMeasures(double dimensionX, double dimensionY, double expectedAreaInMeters, double expectedAreaInCentimeters, String expectedClassName){
        calculatorArea.setDimensions(dimensionX, dimensionY);
        double areaInMeters = calculatorArea.calculateAreaInMeters();
        double areaInCentimeters = calculatorArea.calculateAreaInCentimeters();
        Assert.assertTrue("Failure - expected area in meters does not match", expectedAreaInMeters == areaInMeters);
        Assert.assertTrue("Failure - expected area in centimeters does not match", expectedAreaInCentimeters == areaInCentimeters);
        Assert.assertEquals("Failure - expected class name does not match", calculatorArea.getStrategy().getClass().getSimpleName(), expectedClassName);
    }

    private void isPositiveMeasures(double dimensionX, double dimensionY){
        calculatorArea.setDimensions(dimensionX, dimensionY);
        Assert.assertTrue("Failure - expected dimensionX is negative or zero", calculatorArea.getDimensionX() > 0);
        Assert.assertTrue("Failure - expected dimensionY is negative or zero", calculatorArea.getDimensionY() > 0);
    }

    private void isPositiveArea(double dimensionX, double dimensionY){
        calculatorArea.setDimensions(dimensionX, dimensionY);
        Assert.assertTrue("Failure - expected area in meters is negative or zero", calculatorArea.calculateAreaInMeters() > 0);
        Assert.assertTrue("Failure - expected area in centimeters is negative or zero", calculatorArea.calculateAreaInCentimeters() > 0);
    }

    @Test
    public void calculateRectangleArea() {
        calculatorArea.setStrategy(new RectangleStrategy());
        calculateAreaInSeveralMeasures(RECTANGLE_WIDTH, RECTANGLE_HEIGHT, AREA_RECTANGLE_EXPECTED_METERS, AREA_RECTANGLE_EXPECTED_CENTIMETERS, RECTANGLE_CLASS_NAME_EXPECTED);
    }

    @Test
    public void calculateTriangleArea() {
        calculatorArea.setStrategy(new TriangleStrategy());
        calculateAreaInSeveralMeasures(TRIANGLE_BASE, TRIANGLE_HEIGHT, AREA_TRIANGLE_EXPECTED_METERS, AREA_TRIANGLE_EXPECTED_CENTIMETERS, TRIANGLE_CLASS_NAME_EXPECTED);
    }

    @Test
    public void isPositiveRectangleDimensions(){
        calculatorArea.setStrategy(new RectangleStrategy());
        isPositiveMeasures(RECTANGLE_WIDTH, RECTANGLE_HEIGHT);
    }

    @Test
    public void isPositiveTriangleDimensions(){
        calculatorArea.setStrategy(new TriangleStrategy());
        isPositiveMeasures(TRIANGLE_BASE, TRIANGLE_HEIGHT);
    }

    @Test
    public void isPositiveRectangleArea(){
        calculatorArea.setStrategy(new RectangleStrategy());
        isPositiveArea(RECTANGLE_WIDTH, RECTANGLE_HEIGHT);
    }

    @Test
    public void isPositiveTriangleArea(){
        calculatorArea.setStrategy(new TriangleStrategy());
        isPositiveArea(TRIANGLE_BASE, TRIANGLE_HEIGHT);
    }
}
