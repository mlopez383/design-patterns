package com.avantica.tutorial.designpatterns.templateMethod;

public class CreditCardPayment extends Payment{
    static final double TAX = 0.10;

    @Override
    protected void calculateTax() {
        amountTax = amountWithoutTax * TAX;
    }

    @Override
    protected String getReceipt() {
        return "ELECTRONIC RECEIPT";
    }

    protected String sendElectronicReceiptToEmail() {
        return "ELECTRONIC RECEIPT SENT TO EMAIL";
    }
}
