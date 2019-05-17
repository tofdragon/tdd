package com.kata.schema;

/**
 * @author sunjing
 */
public final class StringSchema implements Schema {

    private static final String FLAG_NAME = "-s";

    private static final String DEFAULT_VALUE = "";

    @Override
    public String flagName() {
        return FLAG_NAME;
    }

    @Override
    public Object defaultValue() {
        return DEFAULT_VALUE;
    }

    @Override
    public Object parserValue(String value) {
        return value;
    }
}