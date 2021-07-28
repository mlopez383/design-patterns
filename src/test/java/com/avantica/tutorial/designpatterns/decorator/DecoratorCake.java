package com.avantica.tutorial.designpatterns.decorator;

public abstract class DecoratorCake implements Cake{
    protected Cake cake;

    public DecoratorCake(Cake cake) {
        this.cake = cake;
    }

    public String getName() {
        return cake.getName();
    }
}
