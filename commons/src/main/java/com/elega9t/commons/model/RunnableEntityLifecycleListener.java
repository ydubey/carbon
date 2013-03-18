package com.elega9t.commons.model;

public interface RunnableEntityLifecycleListener {

    void started(RunnableEntity runnableEntity);

    void stopped(RunnableEntity runnableEntity);

}
