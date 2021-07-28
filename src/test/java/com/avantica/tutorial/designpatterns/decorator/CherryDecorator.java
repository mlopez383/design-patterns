package com.avantica.tutorial.designpatterns.decorator;

public class CherryDecorator extends DecoratorCake{
    private final String CHERRY_DECORATOR_NAME = "Cherry";

    public CherryDecorator(Cake cake) {
        super(cake);
    }

    private String getCherry() {
        return CHERRY_DECORATOR_NAME;
    }

    public String getName() {
        return super.getName() + "\nwith " + this.getCherry();
    }
}
