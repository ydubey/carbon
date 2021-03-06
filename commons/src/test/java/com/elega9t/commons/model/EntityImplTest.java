package com.elega9t.commons.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EntityImplTest {

    private static final String NAME = "testEntity";
    private static final String TYPE = "testEntityType";

    private EntityImpl test;

    @Before
    public void setUp() throws Exception {
        test = new EntityImpl(NAME, TYPE);
    }

    @Test
    public void id_isAutomaticallyInitialized() throws Exception {
        assertNotNull(test.getId());
    }

    @Test
    public void name_isInitialized() throws Exception {
        assertEquals(NAME, test.getName());
    }

    @Test
    public void type_isInitialized() throws Exception {
        assertEquals(TYPE, test.getType());
    }

}
