package com.avantica.tutorial.designpatterns.abstractFactory;

public abstract class Motorcycle {
    protected MotorcycleModel model;
    protected Color color;

    public Motorcycle(MotorcycleModel model, Color color)
    {
        this.model = model;
        this.color = color;
    }

    public abstract String getFeatures();

    public Color getColor() {
        return color;
    }
}