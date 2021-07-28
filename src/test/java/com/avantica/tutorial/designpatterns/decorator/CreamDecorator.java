package com.avantica.tutorial.designpatterns.decorator;

public class CreamDecorator extends DecoratorCake{
    private final String CREAM_DECORATOR_NAME = "Cream";

    public CreamDecorator(Cake cake) {
        super(cake);
    }

    private String getCream() {
        return CREAM_DECORATOR_NAME;
    }

    public String getName() {
        return super.getName() + "\nwith " + this.getCream();
    }
}
