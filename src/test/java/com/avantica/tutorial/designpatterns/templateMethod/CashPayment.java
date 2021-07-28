package com.avantica.tutorial.designpatterns.templateMethod;

public class CashPayment extends Payment{
    static final double TAX = 0.15;

    @Override
    protected void calculateTax() {
        amountTax = amountWithoutTax * TAX;
    }

    @Override
    protected String getReceipt() {
        return "PHYSICAL RECEIPT";
    }
}
