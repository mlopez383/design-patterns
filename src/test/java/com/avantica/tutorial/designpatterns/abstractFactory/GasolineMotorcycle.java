package com.avantica.tutorial.designpatterns.abstractFactory;

public class GasolineMotorcycle extends Motorcycle{
    public GasolineMotorcycle(MotorcycleModel model, Color color) {
        super(model, color);
    }

    @Override
    public String getFeatures() {
        return "Gasoline Motorcycle -> " + "model: " + model + ", color: " + color;
    }
}