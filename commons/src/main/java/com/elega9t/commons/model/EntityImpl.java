package com.elega9t.commons.model;

import java.util.UUID;

public class EntityImpl implements Entity {

    private final String id;
    private final String name;
    private final String type;

    public EntityImpl(String name, String type) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.type = type;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }

}
