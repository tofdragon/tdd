package com.kata.schema;

/**
 * @author sunjing
 */
public final class BooleanSchema implements Schema {

    private static final String FLAG_NAME = "-l";

    @Override
    public String flagName() {
        return FLAG_NAME;
    }

    @Override
    public Object defaultValue() {
        return Boolean.FALSE;
    }

    @Override
    public Object parserValue(String value) {
        return Boolean.valueOf(value);
    }
}
