package com.avantica.tutorial.designpatterns.abstractFactory;

import org.junit.Assert;
import org.junit.Test;

public class AbstractFactoryTest {
    static final String ELECTRICITY_CAR_EXPECTED = "Electricity Car -> model: ECONOMY, color: RED, seats: 5";
    static final String GASOLINE_CAR_EXPECTED = "Gasoline Car -> model: SPORT, color: BLACK, seats: 4";
    static final String ELECTRICITY_MOTORCYCLE_EXPECTED = "Electricity Motorcycle -> model: STANDARD, color: BLUE";
    static final String GASOLINE_MOTORCYCLE_EXPECTED = "Gasoline Motorcycle -> model: CRUISER, color: GREEN";
    static final String CLASS_NAME_EXPECTED_ELECTRICTY_VEHICLE_FACTORY = "ElectricityVehicleFactory";
    static final String CLASS_NAME_EXPECTED_GASOLINE_VEHICLE_FACTORY = "GasolineVehicleFactory";
    private VehicleFactory vehicleFactory;

    private void initVehicleFactory(String classNameExpected){
        if (classNameExpected.equals("ElectricityVehicleFactory")){
            this.vehicleFactory = new ElectricityVehicleFactory();
        }else if(classNameExpected.equals("GasolineVehicleFactory")){
            this.vehicleFactory = new GasolineVehicleFactory();
        }
    }

    private void validateCarCreation(CarModel carModel, Color color, int seats, String carExpected, String classNameExpected){
        initVehicleFactory(classNameExpected);
        Car car = this.vehicleFactory.createCar(carModel, color, seats);
        Assert.assertTrue("Failure - expected car features do not match", carExpected.equals(car.getFeatures()));
        Assert.assertEquals("Failure - expected class name of vehicle factory do not match", this.vehicleFactory.getClass().getSimpleName(), classNameExpected);
    }

    private void validateMotorcycleCreation(MotorcycleModel motorcycleModel, Color color, String motorcycleExpected, String classNameExpected){
        initVehicleFactory(classNameExpected);
        Motorcycle motorcycle = this.vehicleFactory.createMotorcycle(motorcycleModel, color);
        Assert.assertTrue("Failure - expected motorcycle features do not match", motorcycleExpected.equals(motorcycle.getFeatures()));
        Assert.assertEquals("Failure - expected class name of vehicle factory do not match", this.vehicleFactory.getClass().getSimpleName(), classNameExpected);
    }

    @Test
    public void validateElectricityCarCreation() {
        validateCarCreation(CarModel.ECONOMY, Color.RED, 5, ELECTRICITY_CAR_EXPECTED, CLASS_NAME_EXPECTED_ELECTRICTY_VEHICLE_FACTORY);
    }

    @Test
    public void validateGasolineCarCreation() {
        validateCarCreation(CarModel.SPORT, Color.BLACK, 4, GASOLINE_CAR_EXPECTED, CLASS_NAME_EXPECTED_GASOLINE_VEHICLE_FACTORY);
    }

    @Test
    public void validateElectricityMotorcycleCreation() {
        validateMotorcycleCreation(MotorcycleModel.STANDARD, Color.BLUE, ELECTRICITY_MOTORCYCLE_EXPECTED, CLASS_NAME_EXPECTED_ELECTRICTY_VEHICLE_FACTORY);
    }

    @Test
    public void validateGasolineMotorcycleCreation() {
        validateMotorcycleCreation(MotorcycleModel.CRUISER, Color.GREEN, GASOLINE_MOTORCYCLE_EXPECTED, CLASS_NAME_EXPECTED_GASOLINE_VEHICLE_FACTORY);
    }

    @Test
    public void validateElectricityCarCreationWithNullColor() {
        this.vehicleFactory = new GasolineVehicleFactory();
        Motorcycle motorcycle = this.vehicleFactory.createMotorcycle(MotorcycleModel.CRUISER, Color.WHITE);
        Assert.assertNotNull("Failure - expected car color is null", motorcycle.getColor());
    }

    @Test
    public void validateGasolineMotorcycleCreationWithNullColor() {
        this.vehicleFactory = new ElectricityVehicleFactory();
        Car car = this.vehicleFactory.createCar(CarModel.ECONOMY, Color.RED, 5);
        Assert.assertNotNull("Failure - expected motorcycle color is null", car.getColor());
    }

    @Test
    public void validateGasolineCarCreationWithSeatsGreaterThanOne() {
        this.vehicleFactory = new GasolineVehicleFactory();
        Car car = this.vehicleFactory.createCar(CarModel.ECONOMY, Color.RED, 5);
        Assert.assertTrue("Failure - expected quantity of seats is lower than 2 (the minimum seats permitted)", car.getSeats() > 1);
    }
}
