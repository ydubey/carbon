package com.elega9t.commons.model.runnable;

import com.elega9t.commons.model.runnable.event.RunnableEntityLifecycleEvent;

public interface RunnableEntityLifecycleListener {

    void lifecycleEventOccurred(RunnableEntityLifecycleEvent runnableEntity);

}
