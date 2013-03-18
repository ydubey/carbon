package com.elega9t.commons.model;

public interface RunnableEntity extends Entity {

    void start() throws RunnableEntityException;

    void stop() throws RunnableEntityException;

    void addLifecycleListener(RunnableEntityLifecycleListener runnableEntityLifecycleListener);

    boolean removeLifecycleListener(RunnableEntityLifecycleListener runnableEntityLifecycleListener);

}
