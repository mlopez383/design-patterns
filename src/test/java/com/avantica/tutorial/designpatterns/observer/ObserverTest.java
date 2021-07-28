package com.avantica.tutorial.designpatterns.observer;

import org.junit.Assert;
import org.junit.Test;

public class ObserverTest {
    static final String CONVERSIONS_CURRENCY_EXPECTED = "14.47 dollars\n" +
            "12.33 euros\n" +
            "1589.34 yens\n";

    @Test
    public void validateCurrencyObservers(){
        LocalCurrency localCurrency = new LocalCurrency();
        new DollarObserver(localCurrency);
        new EuroObserver(localCurrency);
        new YenObserver(localCurrency);
        localCurrency.setValue(100);
        Assert.assertEquals("Failure - expected currency conversion do not match", CONVERSIONS_CURRENCY_EXPECTED, localCurrency.getConversions());
    }
}
