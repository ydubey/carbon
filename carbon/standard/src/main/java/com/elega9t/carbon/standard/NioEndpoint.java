package com.elega9t.carbon.standard;

import com.elega9t.carbon.Endpoint;
import com.elega9t.commons.model.runnable.RunnableEntityChainElement;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.concurrent.Executor;

public class NioEndpoint extends RunnableEntityChainElement implements Endpoint {

    private int port;
    private Executor executor;

    private Selector selector = null;
    private ServerSocketChannel serverSocketChannel = null;

    public NioEndpoint(String name, String type) {
        super(name, type);
    }

    @Override
    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public void setExecutor(Executor executor) {
        this.executor = executor;
    }

    @Override
    public void startEntity() throws Exception {
        selector = Selector.open();
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(port));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

}
