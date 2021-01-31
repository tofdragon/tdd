package com.kata.exception;

import java.util.List;

/**
 * @author sunjing
 */
public final class DoesNotExistFlagInSchemaException extends RuntimeException {

    private static final String FORMAT = "Does not exit flags: [%s] in schema!";

    public DoesNotExistFlagInSchemaException(List<String> notExistFlags) {
        super(String.format(FORMAT, String.join(",", notExistFlags)));
    }
}
