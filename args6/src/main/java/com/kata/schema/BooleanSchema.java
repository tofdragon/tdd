package com.kata.schema;

import com.kata.Schema;

/**
 * @author sunjing
 */
public final class BooleanSchema extends Schema<Boolean> {

    private static final String DEFAULT_VALUE = "false";

    public BooleanSchema(final String flag) {
        super(flag, DEFAULT_VALUE);
    }

    public BooleanSchema(final String flag, final String defaultValue) {
        super(flag, defaultValue);
    }

    @Override
    protected Boolean doParse(final String value) {
        return Boolean.valueOf(value);
    }
}
