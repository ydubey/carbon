package com.elega9t.carbon.standard;

public enum Type {

    CONNECTOR("connector");

    private String type;

    Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type;
    }

}
