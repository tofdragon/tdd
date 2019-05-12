package com.kata.exception;

/**
 * 不存在Schema异常
 * @author sunjing
 */
public class NotExistSchemaException extends RuntimeException {

    public NotExistSchemaException(String message) {
        super(message);
    }
}
