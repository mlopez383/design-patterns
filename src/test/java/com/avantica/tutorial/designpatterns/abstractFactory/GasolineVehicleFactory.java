package com.avantica.tutorial.designpatterns.abstractFactory;

public class GasolineVehicleFactory implements VehicleFactory {
    public Car createCar(CarModel model, Color color, int seats)
    {
        return new GasolineCar(model, color, seats);
    }

    public Motorcycle createMotorcycle(MotorcycleModel model, Color color)
    {
        return new GasolineMotorcycle(model, color);
    }
}
