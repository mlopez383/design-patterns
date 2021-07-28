package com.avantica.tutorial.designpatterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class SingletonUnitTests {
    @Test
    public void singleton() {
        SingletonService instance = SingletonService.getInstance();
        SingletonService sameInstance = SingletonService.getInstance();

        Assert.assertTrue(instance == sameInstance);
        System.out.println("testing");
    }
}
