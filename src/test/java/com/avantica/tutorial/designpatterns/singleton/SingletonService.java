package com.avantica.tutorial.designpatterns.singleton;

public class SingletonService {

    private static SingletonService service = null;

    private SingletonService() {
    }

    public static SingletonService getInstance() {
        if (service == null) {
            service = new SingletonService();
        }
        return service;
    }
}
