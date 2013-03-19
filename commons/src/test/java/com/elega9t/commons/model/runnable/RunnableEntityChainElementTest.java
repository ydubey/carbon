package com.elega9t.commons.model.runnable;

import com.elega9t.commons.model.runnable.event.RunnableEntityLifecycleEvent;
import com.elega9t.commons.model.runnable.event.RunnableEntityState;
import com.elega9t.commons.model.runnable.RunnableEntity;
import com.elega9t.commons.model.runnable.RunnableEntityChainElement;
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
    public void INITIALIZING_invokesInit() throws Exception {
        test.lifecycleEventOccurred(new RunnableEntityLifecycleEvent(RunnableEntityState.INITIALIZING, mockRunnableEntity));

        verify(test).init();
    }

    @Test
    public void STARTING_invokesStart() throws Exception {
        test.lifecycleEventOccurred(new RunnableEntityLifecycleEvent(RunnableEntityState.STARTING, mockRunnableEntity));

        verify(test).start();
    }

    @Test
    public void STOPPING_invokesStop() throws Exception {
        test.lifecycleEventOccurred(new RunnableEntityLifecycleEvent(RunnableEntityState.STOPPING, mockRunnableEntity));

        verify(test).stop();
    }

    @Test
    public void PAUSING_invokesPause() throws Exception {
        test.lifecycleEventOccurred(new RunnableEntityLifecycleEvent(RunnableEntityState.PAUSING, mockRunnableEntity));

        verify(test).pause();
    }

    @Test
    public void RESUMING_invokesResume() throws Exception {
        test.lifecycleEventOccurred(new RunnableEntityLifecycleEvent(RunnableEntityState.RESUMING, mockRunnableEntity));

        verify(test).resume();
    }

    @Test
    public void DESTROYING_invokesResume() throws Exception {
        test.lifecycleEventOccurred(new RunnableEntityLifecycleEvent(RunnableEntityState.DESTROYING, mockRunnableEntity));

        verify(test).destroy();
    }

}
