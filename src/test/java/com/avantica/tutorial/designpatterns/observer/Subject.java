package com.avantica.tutorial.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    private List<Observer> observers = new ArrayList<Observer>();
    private String conversionResults = "";

    public void add(Observer observer) {
        observers.add(observer);
    }

    public void remove(Observer observer) {
        observers.remove(observer);
    }

    public void update() {
        for (Observer observer: observers) {
            observer.update();
            saveObserverUpdate(observer.getValue());
        }
    }

    /*
    * Saves the observer update in order to compare their results in the unit test.
    * */
    private void saveObserverUpdate(String value) {
        conversionResults += value + "\n";
    }

    public String getResults(){
        return conversionResults;
    }
}

