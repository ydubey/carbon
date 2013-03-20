package com.elega9t.commons.model.runnable;

import com.elega9t.commons.model.EntityImpl;
import com.elega9t.commons.model.runnable.event.RunnableEntityLifecycleEvent;
import com.elega9t.commons.model.runnable.event.RunnableEntityState;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RunnableEntityImpl extends EntityImpl implements RunnableEntity {

    private static final Logger LOGGER = Logger.getLogger(RunnableEntityImpl.class.getName());

    private List<RunnableEntityLifecycleListener> lifecycleListeners = new ArrayList<RunnableEntityLifecycleListener>();

    public RunnableEntityImpl(String name, String type) {
        super(name, type);
    }

    @Override
    public final void init() throws RunnableEntityException {
        long startTime = System.currentTimeMillis();
        try {
            setState(RunnableEntityState.INITIALIZING);
            initEntity();
            setState(RunnableEntityState.INITIALIZED);
            LOGGER.log(Level.INFO, String.format("Initialized %s '%s' in %dms.", getType(), getName(), System.currentTimeMillis() - startTime));
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, String.format("Error while initializing %s '%s'", getType(), getName()), e);
            throw new RunnableEntityException(e);
        }
    }

    public void initEntity() throws Exception {
    }

    @Override
    public final void start() throws RunnableEntityException {
        long startTime = System.currentTimeMillis();
        try {
            setState(RunnableEntityState.STARTING);
            startEntity();
            setState(RunnableEntityState.STARTED);
            LOGGER.log(Level.INFO, String.format("Started %s '%s' in %dms.", getType(), getName(), System.currentTimeMillis() - startTime));
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, String.format("Error while starting %s '%s'", getType(), getName()), e);
            throw new RunnableEntityException(e);
        }
    }

    public void startEntity() throws Exception {
    }

    @Override
    public final void stop() throws RunnableEntityException {
        long startTime = System.currentTimeMillis();
        try {
            setState(RunnableEntityState.STOPPING);
            stopEntity();
            setState(RunnableEntityState.STOPPED);
            LOGGER.log(Level.INFO, String.format("Stopped %s '%s' in %dms.", getType(), getName(), System.currentTimeMillis() - startTime));
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, String.format("Error while stopping %s '%s'", getType(), getName()), e);
            throw new RunnableEntityException(e);
        }
    }

    public void stopEntity() throws Exception {
    }

    @Override
    public final void pause() throws RunnableEntityException {
        long startTime = System.currentTimeMillis();
        try {
            setState(RunnableEntityState.PAUSING);
            pauseEntity();
            setState(RunnableEntityState.PAUSED);
            LOGGER.log(Level.INFO, String.format("Paused %s '%s' in %dms.", getType(), getName(), System.currentTimeMillis() - startTime));
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, String.format("Error while pausing %s '%s'", getType(), getName()), e);
            throw new RunnableEntityException(e);
        }
    }

    public void pauseEntity() throws Exception {
    }

    @Override
    public final void resume() throws RunnableEntityException {
        long startTime = System.currentTimeMillis();
        try {
            setState(RunnableEntityState.RESUMING);
            resumeEntity();
            setState(RunnableEntityState.RESUMED);
            LOGGER.log(Level.INFO, String.format("Resumed %s '%s' in %dms.", getType(), getName(), System.currentTimeMillis() - startTime));
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, String.format("Error while resuming %s '%s'", getType(), getName()), e);
            throw new RunnableEntityException(e);
        }
    }

    public void resumeEntity() throws Exception {
    }

    @Override
    public final void destroy() throws RunnableEntityException {
        long startTime = System.currentTimeMillis();
        try {
            setState(RunnableEntityState.DESTROYING);
            destroyEntity();
            setState(RunnableEntityState.DESTROYED);
            LOGGER.log(Level.INFO, String.format("Destroyed %s '%s' in %dms.", getType(), getName(), System.currentTimeMillis() - startTime));
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, String.format("Error while destroying %s '%s'", getType(), getName()), e);
            throw new RunnableEntityException(e);
        }
    }

    public void destroyEntity() throws Exception {
    }

    @Override
    public void addLifecycleListener(RunnableEntityLifecycleListener runnableEntityLifecycleListener) {
        lifecycleListeners.add(runnableEntityLifecycleListener);
    }

    @Override
    public boolean removeLifecycleListener(RunnableEntityLifecycleListener runnableEntityLifecycleListener) {
        return lifecycleListeners.remove(runnableEntityLifecycleListener);
    }

    public void setState(RunnableEntityState state) {
        RunnableEntityLifecycleEvent event = new RunnableEntityLifecycleEvent(state, this);
        for (RunnableEntityLifecycleListener lifecycleListener : lifecycleListeners) {
            lifecycleListener.lifecycleEventOccurred(event);
        }
    }

}
