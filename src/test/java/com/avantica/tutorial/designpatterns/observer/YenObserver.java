package com.avantica.tutorial.designpatterns.observer;

public class YenObserver implements Observer {
    private LocalCurrency localCurrency;
    private double value;
    private static final double CONVERSION_FACTOR = 15.893367;

    public YenObserver(LocalCurrency localCurrency) {
        this.localCurrency = localCurrency;
        localCurrency.add(this);
    }

    public void update() {
        this.value = localCurrency.getValue() * CONVERSION_FACTOR;
    }

    public String getValue () {
        return String.format( "%.2f", this.value) + " yens";
    }
}