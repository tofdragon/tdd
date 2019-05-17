package com.kata.schema;

/**
 *
 * @author sunjing
 */
public final class IntegerSchema implements Schema {

    private static final String FLAG_NAME = "-i";

    private static final Object DEFAULT_VALUE = 0;

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
        return Integer.parseInt(value);
    }
}
