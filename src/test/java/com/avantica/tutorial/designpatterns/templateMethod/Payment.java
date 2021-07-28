package com.avantica.tutorial.designpatterns.templateMethod;

public abstract class Payment {
    protected double amountWithoutTax;
    protected double amountTax;
    protected double amountWithTax;

    protected abstract void calculateTax();
    protected abstract String getReceipt();

    public void calculateAmountWithTax() {
        this.calculateTax();
        amountWithTax = amountWithoutTax + amountTax;
    }

    public double getAmountWithTax() {
        return amountWithTax;
    }

    public double getAmountWithoutTax() {
        return amountWithoutTax;
    }

    public void setAmountWithoutTax(double amountWithoutTax) {
        this.amountWithoutTax = amountWithoutTax;
    }
}



