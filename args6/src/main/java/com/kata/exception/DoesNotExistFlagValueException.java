package com.kata.exception;

/**
 * @author sunjing
 */
public final class DoesNotExistFlagValueException extends RuntimeException {

    private static final String FORMAT = "dost not exit flag [%s] value!";

    public DoesNotExistFlagValueException(String flag) {
        super(String.format(FORMAT, flag));
    }
}
