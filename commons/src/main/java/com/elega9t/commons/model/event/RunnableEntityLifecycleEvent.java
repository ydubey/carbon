package com.elega9t.commons.model.event;

import com.elega9t.commons.model.RunnableEntity;

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
