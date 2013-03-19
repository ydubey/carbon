package com.elega9t.commons.model.runnable;

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

}
