package com.elega9t.commons.model;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RunnableEntityChainElement extends RunnableEntityImpl implements RunnableEntity, RunnableEntityLifecycleListener {

    private static final Logger LOGGER = Logger.getLogger(RunnableEntityChainElement.class.getName());

    public RunnableEntityChainElement(String name, String type) {
        super(name, type);
    }

    @Override
    public final void started(RunnableEntity runnableEntity) {
        try {
            start();
        } catch (RunnableEntityException e) {
            LOGGER.log(Level.SEVERE, String.format("Error while starting %s '%s'.", getType(), getName()), e);
        }
    }

    @Override
    public final void stopped(RunnableEntity runnableEntity) {
        try {
            stop();
        } catch (RunnableEntityException e) {
            LOGGER.log(Level.SEVERE, String.format("Error while stopping %s '%s'.", getType(), getName()), e);
        }
    }

}
