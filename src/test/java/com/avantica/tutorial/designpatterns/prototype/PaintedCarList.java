package com.avantica.tutorial.designpatterns.prototype;

import org.apache.log4j.Logger;

import java.util.*;
public class PaintedCarList extends CarsList
{
    final static Logger logger = Logger.getLogger(Car.class);
    public PaintedCarList(String color)
    {
        cars = new ArrayList<Car>();
        BlankCarsList blankCarsList = BlankCarsList.Instance();
        List<Car> blankCars = blankCarsList.getCars();

        for (Car car: blankCars)
        {
            try {
                Car carCopy = car.duplicate();
                carCopy.create(color);
                cars.add(carCopy);
            }catch (Exception e){
                logger.error("Error " + e.getMessage());
            }
        }
    }

    public List<Car> getPaintedCars()
    {
        return cars;
    }
}
