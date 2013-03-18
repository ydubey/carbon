package com.elega9t.commons.model;

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

    private RunnableEntityChainElement test;

    @Mock
    private RunnableEntity mockRunnableEntity;

    @Before
    public void setUp() throws Exception {
        test = spy(new RunnableEntityChainElement(NAME));
    }

    @Test
    public void started_invokesStart() throws Exception {
        test.started(mockRunnableEntity);

        verify(test).start();
    }

    @Test
    public void stopped_invokesStop() throws Exception {
        test.stopped(mockRunnableEntity);

        verify(test).stop();
    }

}
