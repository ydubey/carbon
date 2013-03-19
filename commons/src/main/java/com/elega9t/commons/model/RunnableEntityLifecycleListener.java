package com.elega9t.commons.model;

import com.elega9t.commons.model.event.RunnableEntityLifecycleEvent;

public interface RunnableEntityLifecycleListener {

    void lifecycleEventOccurred(RunnableEntityLifecycleEvent runnableEntity);

}
