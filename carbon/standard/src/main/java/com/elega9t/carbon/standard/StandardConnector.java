package com.elega9t.carbon.standard;

import com.elega9t.carbon.Connector;
import com.elega9t.commons.model.RunnableEntityChainElement;

import static com.elega9t.carbon.standard.Type.CONNECTOR;

public class StandardConnector extends RunnableEntityChainElement implements Connector {

    private int port;
    private int acceptCount;

    public StandardConnector(String name) {
        super(name, CONNECTOR.getType());
    }

    @Override
    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public void setAcceptCount(int acceptCount) {
        this.acceptCount = acceptCount;
    }

}
