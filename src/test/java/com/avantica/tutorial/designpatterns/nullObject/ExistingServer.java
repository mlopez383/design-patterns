package com.avantica.tutorial.designpatterns.nullObject;

public class ExistingServer implements AbstractServer {
    private String nameServer;

    public ExistingServer (String nameServer) {
        this.nameServer = nameServer;
    }

    public String getNameServer() {
        return  this.nameServer;
    }
}
