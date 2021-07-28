package com.avantica.tutorial.designpatterns.facade;

public class DefaultWebApplicationFacade implements WebApplicationFacade {
    private DomainName domainName;
    private Database database;
    private WebBuilder webBuilder;

    public DefaultWebApplicationFacade() {
        this.domainName = new DomainName();
        this.database = new Database();
        this.webBuilder = new WebBuilder();
    }

    public void createWebApplication(String domain_name, String ip, String dbname) {
        domainName.register(domain_name, ip);
        database.create(ip, dbname);
        webBuilder.build(domain_name, database);
    }

    public DomainName getDomainName() {
        return domainName;
    }

    public Database getDatabase() {
        return database;
    }

    public WebBuilder getWebBuilder() {
        return webBuilder;
    }
}
