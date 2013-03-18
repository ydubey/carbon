package com.elega9t.commons.model;

public class RunnableEntityException extends Exception {

    public RunnableEntityException() {
    }

    public RunnableEntityException(String message) {
        super(message);
    }

    public RunnableEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public RunnableEntityException(Throwable cause) {
        super(cause);
    }

    public RunnableEntityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
