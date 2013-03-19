package com.elega9t.commons.model;

import com.elega9t.commons.model.event.RunnableEntityLifecycleEvent;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RunnableEntityChainElement extends RunnableEntityImpl implements RunnableEntity, RunnableEntityLifecycleListener {

    private static final Logger LOGGER = Logger.getLogger(RunnableEntityChainElement.class.getName());

    public RunnableEntityChainElement(String name, String type) {
        super(name, type);
    }

    @Override
    public final void lifecycleEventOccurred(RunnableEntityLifecycleEvent runnableEntity) {
        try {
            switch (runnableEntity.getState()) {
                case INITIALIZING:
                    init();
                    break;
                case STARTING:
                    start();
                    break;
                case STOPPING:
                    stop();
                    break;
                case PAUSING:
                    pause();
                    break;
                case RESUMING:
                    resume();
                    break;
                case DESTROYING:
                    destroy();
                    break;
            }
        } catch (RunnableEntityException e) {
            LOGGER.log(Level.SEVERE, String.format("Error while %s %s '%s'.", runnableEntity.getState(), getType(), getName()), e);
        }
    }

}
