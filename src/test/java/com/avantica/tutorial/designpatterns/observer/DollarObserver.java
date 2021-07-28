package com.avantica.tutorial.designpatterns.observer;

public class DollarObserver implements Observer {
    private LocalCurrency localCurrency;
    private double value;
    private static final double CONVERSION_FACTOR = 0.144725;

    public DollarObserver(LocalCurrency localCurrency) {
        this.localCurrency = localCurrency;
        localCurrency.add(this);
    }

    public void update() {
        this.value = localCurrency.getValue() * CONVERSION_FACTOR;
    }

    public String getValue () {
        return String.format( "%.2f", this.value) + " dollars";
    }
}



