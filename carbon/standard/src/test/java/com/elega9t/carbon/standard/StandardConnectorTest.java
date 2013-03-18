package com.elega9t.carbon.standard;

import org.junit.Before;
import org.junit.Test;

public class StandardConnectorTest {

    private static final String NAME = "testConnector";
    private static final int PORT = 8080;

    private StandardConnector test;

    @Before
    public void setUp() throws Exception {
        test = new StandardConnector(NAME);
        test.setPort(PORT);
    }

    @Test
    public void stop() throws Exception {
        test.stop();
    }

}
