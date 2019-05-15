package com.kata.exception;

/**
 * 不合法的Schema
 *
 * @author sunjing
 */
public final class InValidSchemaException extends RuntimeException {

    private static final String MESSAGE = "不合法的Schema,标记名称:%s";

    public InValidSchemaException(String flagName) {
        super(String.format(MESSAGE, flagName));
    }
}
