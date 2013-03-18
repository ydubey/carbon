package com.elega9t.commons.model;

import java.util.UUID;

public class EntityImpl implements Entity {

    private final String id;
    private final String name;

    public EntityImpl(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

}
