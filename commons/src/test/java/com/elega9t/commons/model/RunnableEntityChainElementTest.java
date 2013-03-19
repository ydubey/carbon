package com.elega9t.commons.model;

import com.elega9t.commons.model.event.RunnableEntityLifecycleEvent;
import com.elega9t.commons.model.event.RunnableEntityState;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RunnableEntityChainElementTest {

    private static final String NAME = "testEntity";
    private static final String TYPE = "testEntityType";

    private RunnableEntityChainElement test;

    @Mock
    private RunnableEntity mockRunnableEntity;

    @Before
    public void setUp() throws Exception {
        test = spy(new RunnableEntityChainElement(NAME, TYPE));
    }

    @Test
    public void STARTING_invokesStart() throws Exception {
        test.lifecycleEventOccurred(new RunnableEntityLifecycleEvent(RunnableEntityState.STARTING, mockRunnableEntity));

        verify(test).start();
    }

    @Test
    public void STOPPING_invokesStart() throws Exception {
        test.lifecycleEventOccurred(new RunnableEntityLifecycleEvent(RunnableEntityState.STOPPING, mockRunnableEntity));

        verify(test).stop();
    }

}
