package com.elega9t.commons.model;

public class RunnableEntityChainElement extends RunnableEntityImpl implements RunnableEntity, RunnableEntityLifecycleListener {

    public RunnableEntityChainElement(String name) {
        super(name);
    }

    @Override
    public void started(RunnableEntity runnableEntity) {
        try {
            start();
        } catch (RunnableEntityException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stopped(RunnableEntity runnableEntity) {
        try {
            stop();
        } catch (RunnableEntityException e) {
            e.printStackTrace();
        }
    }

}
