package com.avantica.tutorial.designpatterns.abstractFactory;

public interface VehicleFactory {
    Car createCar(CarModel model, Color color, int seats);

    Motorcycle createMotorcycle(MotorcycleModel model, Color color);
}
