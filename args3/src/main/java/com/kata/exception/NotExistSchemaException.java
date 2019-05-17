package com.kata.exception;

/**
 * @author sunjing
 */
public final class NotExistSchemaException extends RuntimeException {

    private static final String MESSAGE = "not exist schema for flagName:%s";

    public NotExistSchemaException(String flagName) {
        super(String.format(MESSAGE, flagName));
    }
}
