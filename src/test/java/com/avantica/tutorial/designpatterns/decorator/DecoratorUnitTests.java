package com.avantica.tutorial.designpatterns.decorator;

import org.junit.Assert;
import org.junit.Test;

public class DecoratorUnitTests {
    @Test
    public void validateChocolateCakeDecoration() {
        final String CHOCOLATE_CAKE_EXPECTED = "Chocolate Cake:\n" +
                "with Cherry\n" +
                "with Cream";
        ChocolateCake chocolateCake = new ChocolateCake();
        CherryDecorator cherryDecorator = new CherryDecorator(chocolateCake);
        CreamDecorator creamDecorator = new CreamDecorator(cherryDecorator);
        Assert.assertEquals(CHOCOLATE_CAKE_EXPECTED, creamDecorator.getName());
    }

    @Test
    public void validateVanillaCakeDecoration() {
        final String VANILLA_CAKE_EXPECTED = "Vanilla Cake:\n" +
                "with Cherry\n" +
                "with Cream\n" +
                "with Cookies";
        VanillaCake vanillaCake = new VanillaCake();
        CherryDecorator cherryDecorator = new CherryDecorator(vanillaCake);
        CreamDecorator creamDecorator = new CreamDecorator(cherryDecorator);
        CookieDecorator cookieDecorator = new CookieDecorator(creamDecorator);
        Assert.assertEquals(VANILLA_CAKE_EXPECTED, cookieDecorator.getName());
    }
}
