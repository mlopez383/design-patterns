package com.avantica.tutorial.designpatterns.facade;

public class BlankWebApplicationFacade implements WebApplicationFacade {
    private DomainName domainName;
    private Database database;

    public BlankWebApplicationFacade() {
        this.domainName = new DomainName();
        this.database = new Database();
    }

    public void createWebApplication(String domain_name, String ip, String dbname) {
        domainName.register(domain_name, ip);
        database.create(ip, dbname);
    }

    public String getDomainNameStatus() {
        return domainName.getStatus();
    }

    public String getDatabaseStatus() {
        return database.getStatus();
    }
}
