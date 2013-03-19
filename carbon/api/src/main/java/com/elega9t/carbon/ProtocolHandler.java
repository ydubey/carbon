package com.elega9t.carbon;

import com.elega9t.commons.model.RunnableEntity;
import com.elega9t.commons.model.RunnableEntityLifecycleListener;

public interface ProtocolHandler extends RunnableEntity, RunnableEntityLifecycleListener {

    void setPort(int port);

}
