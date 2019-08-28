package com.epam.geometry.exceptions;

public class DataMissingException extends Exception {
    public DataMissingException() {
        super();
    }

    public DataMissingException(String message) {
        super(message);
    }

    public DataMissingException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataMissingException(Throwable cause) {
        super(cause);
    }

    protected DataMissingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
