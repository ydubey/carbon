package com.elega9t.commons.model;

import java.util.ArrayList;
import java.util.List;

public class RunnableEntityImpl extends EntityImpl implements RunnableEntity {

    private List<RunnableEntityLifecycleListener> lifecycleListeners = new ArrayList<RunnableEntityLifecycleListener>();

    public RunnableEntityImpl(String name, String type) {
        super(name, type);
    }

    @Override
    public void start() throws RunnableEntityException {
    }

    @Override
    public void stop() throws RunnableEntityException {
    }

    @Override
    public void addLifecycleListener(RunnableEntityLifecycleListener runnableEntityLifecycleListener) {
        lifecycleListeners.add(runnableEntityLifecycleListener);
    }

    @Override
    public boolean removeLifecycleListener(RunnableEntityLifecycleListener runnableEntityLifecycleListener) {
        return lifecycleListeners.remove(runnableEntityLifecycleListener);
    }

}
