package com.avantica.tutorial.designpatterns.facade;

public class DomainName {
    private String domainName;
    private String IP;
    private String status = "NONE";
    private static final String DOMAIN_NAME_REGISTERED_STATUS = "DOMAIN NAME REGISTERED";

    public void register(String domainName, String IP){
        this.domainName = domainName;
        this.IP = IP;
        this.status = DOMAIN_NAME_REGISTERED_STATUS;
    }

    public String getDomainName() {
        return domainName;
    }

    public String getIP() {
        return IP;
    }

    public String getStatus() {
        return status;
    }
}
