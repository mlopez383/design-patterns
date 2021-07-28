package com.avantica.tutorial.designpatterns.templateMethod;

import org.junit.Assert;
import org.junit.Test;

public class TemplateMethodTest {
    static final double AMOUNT_WITHOUT_TAX = 1000;
    static final String PAYMENT_CLASS_NAME_EXPECTED = "Payment";
    static final double CASH_PAYMENT_WITH_TAX_EXPECTED = 1150;
    static final double CREDIT_CARD_PAYMENT_WITH_TAX_EXPECTED = 1100;
    static final String CASH_PAYMENT_RECEIPT_EXPECTED = "PHYSICAL RECEIPT";
    static final String CREDIT_CARD_PAYMENT_RECEIPT_EXPECTED = "ELECTRONIC RECEIPT";
    static final String ELECTRONIC_RECEIPT_SENT_TO_EMAIL_EXPECTED = "ELECTRONIC RECEIPT SENT TO EMAIL";

    @Test
    public void validateCashPayment(){
        CashPayment cashPayment = new CashPayment();
        cashPayment.setAmountWithoutTax(AMOUNT_WITHOUT_TAX);
        cashPayment.calculateAmountWithTax();
        double amountWithTax = cashPayment.getAmountWithTax();
        Assert.assertTrue("Failure - expected cash payment with tax does not match", CASH_PAYMENT_WITH_TAX_EXPECTED == amountWithTax);
        Assert.assertEquals("Failure - expected cash payment receipt does not match", CASH_PAYMENT_RECEIPT_EXPECTED, cashPayment.getReceipt());
        Assert.assertEquals("Failure - expected class name does not match", PAYMENT_CLASS_NAME_EXPECTED, cashPayment.getClass().getSuperclass().getSimpleName());
    }

    @Test
    public void validateCreditCardPayment(){
        CreditCardPayment creditCardPayment = new CreditCardPayment();
        creditCardPayment.setAmountWithoutTax(AMOUNT_WITHOUT_TAX);
        creditCardPayment.calculateAmountWithTax();
        double amountWithTax = creditCardPayment.getAmountWithTax();
        Assert.assertTrue("Failure - expected credit card payment with tax does not match", CREDIT_CARD_PAYMENT_WITH_TAX_EXPECTED == amountWithTax);
        Assert.assertEquals("Failure - expected credit card payment receipt does not match", CREDIT_CARD_PAYMENT_RECEIPT_EXPECTED, creditCardPayment.getReceipt());
        Assert.assertEquals("Failure - expected message of electronic receipt sent to email does not match", ELECTRONIC_RECEIPT_SENT_TO_EMAIL_EXPECTED, creditCardPayment.sendElectronicReceiptToEmail());
        Assert.assertEquals("Failure - expected payment class name does not match", PAYMENT_CLASS_NAME_EXPECTED, creditCardPayment.getClass().getSuperclass().getSimpleName());
    }

    @Test
    public void validatePositiveAmountWithCashPayment(){
        CashPayment cashPayment = new CashPayment();
        cashPayment.setAmountWithoutTax(AMOUNT_WITHOUT_TAX);
        double amountWithoutTax = cashPayment.getAmountWithoutTax();
        Assert.assertTrue("Failure - expected amount of cash payment is negative or zero", amountWithoutTax > 0);
    }

    @Test
    public void validatePositiveAmountWithCreditCardPayment(){
        CreditCardPayment creditCardPayment = new CreditCardPayment();
        creditCardPayment.setAmountWithoutTax(AMOUNT_WITHOUT_TAX);
        double amountWithoutTax = creditCardPayment.getAmountWithoutTax();
        Assert.assertTrue("Failure - expected amount of credit card payment is negative or zero", amountWithoutTax > 0);
    }
}

