package com.avantica.tutorial.designpatterns.prototype;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PrototypeTest {
    static final String FORD = "Ford";
    static final String CHEVROLET = "Chevrolet";
    static final String RED_CHEVROLET_CAR_EXPECTED = "The Chevrolet car is red";
    static final String RED_FORD_CAR_EXPECTED = "The Ford car is red";
    static final String BLUE_CHEVROLET_CAR_EXPECTED = "The Chevrolet car is blue";
    static final String BLUE_FORD_CAR_EXPECTED = "The Ford car is blue";

    private void validatePaintedCar(String color, String FordCarExpected, String ChevroletCarExpected){
        PaintedCarList paintedCar = new PaintedCarList(color);

        for (Car car: paintedCar.getPaintedCars()) {
            if(FORD.equalsIgnoreCase(car.getClass().getSimpleName())){
                Assert.assertTrue("Failure - expected Ford car feature does not match", FordCarExpected.equals(car.getFeatures()));
            }

            if(CHEVROLET.equalsIgnoreCase(car.getClass().getSimpleName())){
                Assert.assertTrue("Failure - expected Chevrolet car feature does not match", ChevroletCarExpected.equals(car.getFeatures()));
            }
        }
    }

    @Before
    public void initialize() {
        BlankCarsList blankCar = BlankCarsList.Instance();
        blankCar.initialize();
    }

    @Test
    public void validateRedCarsCreation() {
        validatePaintedCar("red", RED_FORD_CAR_EXPECTED, RED_CHEVROLET_CAR_EXPECTED);
    }

    @Test
    public void validateBlueCarsCreation() {
        validatePaintedCar("blue", BLUE_FORD_CAR_EXPECTED, BLUE_CHEVROLET_CAR_EXPECTED);
    }

    @Test
    public void validateCarCreationAndPaintingWithNullColorValue() {
        PaintedCarList paintedCar = new PaintedCarList("green");
        for (Car car: paintedCar.getPaintedCars()) {
            Assert.assertNotNull("Failure - expected car color is null", car);
            Assert.assertNotNull("Failure - expected " + car.getClass().getSimpleName() + " car color is null", car.getColor());
        }
    }
}


