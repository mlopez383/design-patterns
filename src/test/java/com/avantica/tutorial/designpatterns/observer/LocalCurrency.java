package com.avantica.tutorial.designpatterns.observer;

public class LocalCurrency extends Subject {
    private double value;

    public void setValue (double value) {
        this.value = value;
        this.update();
    }

    public double getValue() {
        return value;
    }

    public String getConversions() {
        return this.getResults();
    }
}
