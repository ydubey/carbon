package com.elega9t.carbon;

import com.elega9t.commons.model.runnable.RunnableEntity;
import com.elega9t.commons.model.runnable.RunnableEntityLifecycleListener;

import java.util.concurrent.Executor;

public interface Endpoint extends RunnableEntity, RunnableEntityLifecycleListener {

    void setPort(int port);

    void setExecutor(Executor executor);

}
