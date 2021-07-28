package com.avantica.tutorial.designpatterns.abstractFactory;

public class ElectricityVehicleFactory implements VehicleFactory{
    public Car createCar(CarModel model, Color color, int seats)
    {
        return new ElectricityCar(model, color, seats);
    }

    public Motorcycle createMotorcycle(MotorcycleModel model, Color color)
    {
        return new ElectricityMotorcycle(model, color);
    }
}
