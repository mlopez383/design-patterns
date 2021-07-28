package com.avantica.tutorial.designpatterns.facade;

public class Database {
    private String hostname;
    private String name;
    private String status = "NONE";
    private static final String DATABASE_CREATED_STATUS = "DATABASE CREATED";

    public void create(String hostname, String name) {
        this.hostname = hostname;
        this.name = name;
        this.status = DATABASE_CREATED_STATUS;
    }

    public String getHostname() {
        return hostname;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }
}