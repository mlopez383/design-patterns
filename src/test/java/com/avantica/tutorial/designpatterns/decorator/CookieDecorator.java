package com.avantica.tutorial.designpatterns.decorator;

public class CookieDecorator extends DecoratorCake{
    private final String COOKIE_DECORATOR_NAME = "Cookies";

    public CookieDecorator(Cake cake) {
        super(cake);
    }

    private String getCookies() {
        return COOKIE_DECORATOR_NAME;
    }

    public String getName() {
        return super.getName() + "\nwith " + this.getCookies();
    }
}
