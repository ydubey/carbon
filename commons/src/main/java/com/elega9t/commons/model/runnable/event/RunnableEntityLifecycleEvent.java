package com.elega9t.commons.model.runnable.event;

import com.elega9t.commons.model.runnable.RunnableEntity;

public class RunnableEntityLifecycleEvent {

    private final RunnableEntityState state;

    private final RunnableEntity source;

    public RunnableEntityLifecycleEvent(RunnableEntityState state, RunnableEntity source) {
        this.state = state;
        this.source = source;
    }

    public RunnableEntityState getState() {
        return state;
    }

    public RunnableEntity getSource() {
        return source;
    }

}
