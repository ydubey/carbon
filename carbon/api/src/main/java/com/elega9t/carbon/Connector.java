package com.elega9t.carbon;

import com.elega9t.commons.model.RunnableEntity;
import com.elega9t.commons.model.RunnableEntityLifecycleListener;

public interface Connector extends RunnableEntity, RunnableEntityLifecycleListener {

    void setPort(int port);

    void setAcceptCount(int acceptCount);

}
