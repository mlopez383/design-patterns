package com.avantica.tutorial.designpatterns.prototype;

import java.util.*;

public class BlankCarsList extends CarsList
{
    private static BlankCarsList blankCarsList = null;

    private BlankCarsList()
    {
        cars = new ArrayList<Car>();
    }

    public static BlankCarsList Instance()
    {
        if (blankCarsList == null)
            blankCarsList = new BlankCarsList();
        return blankCarsList;
    }

    private void add(Car doc)
    {
        cars.add(doc);
    }

    public void initialize(){
        add(new Ford());
        add(new Chevrolet());
    }
}
