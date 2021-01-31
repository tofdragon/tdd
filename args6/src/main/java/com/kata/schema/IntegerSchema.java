package com.kata.schema;

import com.kata.Schema;

/**
 * @author sunjing
 */
public final class IntegerSchema extends Schema<Integer> {

    private static final String DEFAULT_VALUE = "0";

    public IntegerSchema(final String flag) {
        super(flag, DEFAULT_VALUE);
    }

    public IntegerSchema(final String flag, final String defaultValue) {
        super(flag, defaultValue);
    }

    @Override
    protected Integer doParse(final String value) {
        return Integer.valueOf(value);
    }
}
