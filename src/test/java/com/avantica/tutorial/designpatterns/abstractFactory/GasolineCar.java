package com.avantica.tutorial.designpatterns.abstractFactory;

public class GasolineCar extends Car {
    public GasolineCar(CarModel model, Color color, int seats){
        super(model, color, seats);
    }

    @Override
    public String getFeatures() {
        return "Gasoline Car -> " + "model: " + model + ", color: " + color + ", seats: " + seats;
    }
}
