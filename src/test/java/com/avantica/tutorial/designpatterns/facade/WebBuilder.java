package com.avantica.tutorial.designpatterns.facade;

public class WebBuilder {
    private String status = "NONE";

    public void build(String domainName, Database database) {
        status = "WEB APPLICATION GENERATED for \'" + domainName + "\' with the database named \'" + database.getName() + "\'";
    }

    public String getStatus() {
        return status;
    }
}
