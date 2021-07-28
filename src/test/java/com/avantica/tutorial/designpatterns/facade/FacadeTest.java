package com.avantica.tutorial.designpatterns.facade;

import org.junit.Assert;
import org.junit.Test;
import java.util.regex.Pattern;

public class FacadeTest {
    private static final String DOMAIN_NAME = "example.com";
    private static final String IP = "250.125.84.204";
    private static final String DB_NAME = "exampledb";
    private static final String EXPECTED_DOMAIN_NAME_STATUS = "DOMAIN NAME REGISTERED";
    private static final String EXPECTED_DATABASE_STATUS = "DATABASE CREATED";
    private static final String EXPECTED_WEB_BUILDER_STATUS = "WEB APPLICATION GENERATED for '" + DOMAIN_NAME + "' with the database named '" + DB_NAME + "'";
    private static final Pattern IP_PATTERN = Pattern.compile("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
    private static final Pattern DNS_PATTERN = Pattern.compile("^[a-zA-Z0-9][a-zA-Z0-9-]{1,61}[a-zA-Z0-9]\\.[a-zA-Z]{2,}$");

    private boolean validateIP(String ip) {
        return IP_PATTERN.matcher(ip).matches();
    }

    private boolean validateDNS(String ip) {
        return DNS_PATTERN.matcher(ip).matches();
    }

    private DefaultWebApplicationFacade initDefaultWebApplication(){
        DefaultWebApplicationFacade webApplication = new DefaultWebApplicationFacade();
        webApplication.createWebApplication(DOMAIN_NAME, IP, DB_NAME);
        return webApplication;
    }

    private void validateWebApplicationStatus(DefaultWebApplicationFacade webApplication, String DnsStatus, String DbStatus, String WebStatus){
        Assert.assertEquals("Failure - expected domain name status does not match", DnsStatus, webApplication.getDomainName().getStatus());
        Assert.assertEquals("Failure - expected database status does not match", DbStatus, webApplication.getDatabase().getStatus());
        Assert.assertEquals("Failure - expected web builder status does not match", WebStatus, webApplication.getWebBuilder().getStatus());
    }

    @Test
    public void validateDefaultWebApplicationCreation(){
        DefaultWebApplicationFacade webApplication = initDefaultWebApplication();
        validateWebApplicationStatus(webApplication, EXPECTED_DOMAIN_NAME_STATUS, EXPECTED_DATABASE_STATUS, EXPECTED_WEB_BUILDER_STATUS);
    }

    @Test
    public void validateNonInitializedDefaultWebApplication(){
        DefaultWebApplicationFacade webApplication = new DefaultWebApplicationFacade();
        validateWebApplicationStatus(webApplication, "NONE", "NONE", "NONE");
    }

    @Test
    public void checkNullValuesOfDefaultWebApplication(){
        DefaultWebApplicationFacade webApplication = initDefaultWebApplication();
        Assert.assertNotNull("Failure - expected domain name is null", webApplication.getDomainName().getDomainName());
        Assert.assertNotNull("Failure - expected IP is null", webApplication.getDomainName().getIP());
        Assert.assertNotNull("Failure - expected hostname is null", webApplication.getDatabase().getHostname());
        Assert.assertNotNull("Failure - expected database name is null", webApplication.getDatabase().getName());
        Assert.assertNotNull("Failure - expected web builder status is null", webApplication.getWebBuilder().getStatus());
    }

    @Test
    public void validateIPFormat(){
        DefaultWebApplicationFacade webApplication = initDefaultWebApplication();
        Assert.assertTrue("Failure - expected IP has an invalid format", validateIP(webApplication.getDomainName().getIP()));
        Assert.assertTrue("Failure - expected IP has an invalid format", validateIP(webApplication.getDatabase().getHostname()));
    }

    @Test
    public void validateDNSFormat(){
        DefaultWebApplicationFacade webApplication = initDefaultWebApplication();
        Assert.assertTrue("Failure - expected DNS has an invalid format", validateDNS(webApplication.getDomainName().getDomainName()));
    }


    /******************** TEST OF A NEW FACADE WITH DIFFERENT BEHAVIOUR*********************/
    @Test
    public void validateBlankWebApplicationCreation(){
        BlankWebApplicationFacade webApplication = new BlankWebApplicationFacade();
        webApplication.createWebApplication(DOMAIN_NAME, IP, DB_NAME);
        Assert.assertEquals("Failure - expected domain name status does not match", EXPECTED_DOMAIN_NAME_STATUS, webApplication.getDomainNameStatus());
        Assert.assertEquals("Failure - expected database status does not match", EXPECTED_DATABASE_STATUS, webApplication.getDatabaseStatus());
    }
}
