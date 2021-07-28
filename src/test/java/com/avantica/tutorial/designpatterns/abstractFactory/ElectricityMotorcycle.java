package com.avantica.tutorial.designpatterns.abstractFactory;

public class ElectricityMotorcycle extends Motorcycle{
    public ElectricityMotorcycle(MotorcycleModel model, Color color) {
        super(model, color);
    }

    @Override
    public String getFeatures() {
        return "Electricity Motorcycle -> " + "model: " + model + ", color: " + color;
    }
}
