package com.avantica.tutorial.designpatterns.nullObject;

public class ServerFactory {
    public static final String[] servers = {"QAserver", "DEVserver"};

    public static AbstractServer getServer (String server){
        for (int i = 0; i < servers.length; i++) {
            if (servers[i].equalsIgnoreCase(server)) {
                return new ExistingServer(server);
            }
        }
        return new NullServer();
    }
}
