package com.avantica.tutorial.designpatterns.abstractFactory;

public abstract class Car {
    protected CarModel model;
    protected Color color;
    protected int seats;

    public Car(CarModel model, Color color, int seats)
    {
        this.model = model;
        this.color = color;
        this.seats = seats;
    }

    public abstract String getFeatures();

    public Color getColor() {
        return color;
    }

    public int getSeats() {
        return seats;
    }
}
