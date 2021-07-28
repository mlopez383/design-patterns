package com.avantica.tutorial.designpatterns.prototype;

import org.apache.log4j.Logger;

public abstract class Car implements Cloneable
{
    protected String color;
    final static Logger logger = Logger.getLogger(Car.class);

    public Car duplicate() throws Exception
    {
        Car result;

        try
        {
            result = (Car)this.clone();
        }
        catch (CloneNotSupportedException exception)
        {
            logger.error("cannot clone the Car Object");
            throw new Exception("cannot clone the Car Object");
        }
        return result;
    }

    public void create(String color)    {
        this.color = color;
    }

    public String getColor(){
        return this.color;
    }

    public abstract String getFeatures();
}

