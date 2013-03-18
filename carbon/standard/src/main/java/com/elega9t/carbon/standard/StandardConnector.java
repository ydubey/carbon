package com.elega9t.carbon.standard;

import com.elega9t.carbon.Connector;
import com.elega9t.commons.model.RunnableEntityChainElement;
import com.elega9t.commons.model.RunnableEntityException;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.elega9t.carbon.standard.Type.CONNECTOR;

public class StandardConnector extends RunnableEntityChainElement implements Connector {

    private static final Logger LOGGER = Logger.getLogger(StandardConnector.class.getName());

    private int port;

    private Selector selector = null;
    private ServerSocketChannel serverChannel = null;

    public StandardConnector(String name) {
        super(name, CONNECTOR.getType());
    }

    @Override
    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public void start() throws RunnableEntityException {
        long startTime = System.currentTimeMillis();
        fireStartingEvent();
        try {
            selector = Selector.open();
            serverChannel = ServerSocketChannel.open();
            serverChannel.socket().bind(new InetSocketAddress(port));
            serverChannel.configureBlocking(false);
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);
            while(selector.isOpen()) {
                for (Iterator<SelectionKey> i = selector.selectedKeys().iterator(); i.hasNext();) {
                    SelectionKey key = i.next();
                    i.remove();
                    if (key.isConnectable()) {
                        ((SocketChannel)key.channel()).finishConnect();
                    }
                    if (key.isAcceptable()) {
                        // accept connection
                        SocketChannel client = serverChannel.accept();
                        client.configureBlocking(false);
                        client.socket().setTcpNoDelay(true);
                        client.register(selector, SelectionKey.OP_READ);
                    }
                    if (key.isReadable()) {
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, String.format("Error occurred while starting %s on port %d", getType(), port), e);
            throw new RunnableEntityException(e);
        }
    }

    @Override
    public void stop() throws RunnableEntityException {
        LOGGER.log(Level.INFO, String.format("Stopping %s on port %d...", getType(), port));
        if(selector != null) {
            long startTime = System.currentTimeMillis();
            fireStoppingEvent();
            try {
                selector.close();
                serverChannel.socket().close();
                serverChannel.close();
                LOGGER.log(Level.INFO, String.format("%s on port %d stopped in %dms.", getType(), port, System.currentTimeMillis() - startTime));
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, String.format("Error occurred while stopping %s on port %d", getType(), port), e);
                throw new RunnableEntityException(e);
            }
        } else {
            LOGGER.log(Level.INFO, String.format("%s on port %d not started yet!", getType(), port));
        }
    }

}
