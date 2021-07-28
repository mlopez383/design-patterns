package com.avantica.tutorial.designpatterns.nullObject;

import org.junit.Assert;
import org.junit.Test;

public class NullObjectTest {
    static final String EXPECTED_EXISTING_TESTING_SERVER = "QAserver";
    static final String EXPECTED_EXISTING_DEVELOPMENT_SERVER = "DEVserver";
    static final String EXPECTED_NULL_PRODUCTION_SERVER = "NOT AVAILABLE";

    @Test
    public void validateTwoExistingServers() {
        AbstractServer abstractServer1 = ServerFactory.getServer("DEVserver");
        AbstractServer abstractServer2 = ServerFactory.getServer("QAserver");
        Assert.assertEquals("Failure - expected development server name does not match", EXPECTED_EXISTING_DEVELOPMENT_SERVER, abstractServer1.getNameServer());
        Assert.assertEquals("Failure - expected testing server name does not match", EXPECTED_EXISTING_TESTING_SERVER, abstractServer2.getNameServer());
    }

    @Test
    public void validateNullServer() {
        AbstractServer abstractServer = ServerFactory.getServer("PRODserver");
        Assert.assertEquals("Failure - expected NULL server message does not match", EXPECTED_NULL_PRODUCTION_SERVER, abstractServer.getNameServer());
    }
}
