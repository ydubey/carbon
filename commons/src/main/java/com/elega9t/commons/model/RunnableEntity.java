package com.elega9t.commons.model;

public interface RunnableEntity extends Entity {

    void init() throws RunnableEntityException;

    void start() throws RunnableEntityException;

    void stop() throws RunnableEntityException;

    void pause() throws RunnableEntityException;

    void resume() throws RunnableEntityException;

    void destroy() throws RunnableEntityException;

    void addLifecycleListener(RunnableEntityLifecycleListener runnableEntityLifecycleListener);

    boolean removeLifecycleListener(RunnableEntityLifecycleListener runnableEntityLifecycleListener);

}
