package com.avantica.tutorial.designpatterns.abstractFactory;

public class ElectricityCar extends Car {
    public ElectricityCar(CarModel model, Color color, int space){
        super(model, color, space);
    }

    @Override
    public String getFeatures() {
        return "Electricity Car -> " + "model: " + model + ", color: " + color + ", seats: " + seats;
    }
}
