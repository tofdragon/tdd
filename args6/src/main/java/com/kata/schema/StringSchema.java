package com.kata.schema;

import com.kata.Schema;

/**
 * @author sunjing
 */
public final class StringSchema extends Schema<String> {

    private static final String DEFAULT_VALUE = "";

    public StringSchema(final String flag) {
        super(flag, DEFAULT_VALUE);
    }

    public StringSchema(final String flag, final String defaultValue) {
        super(flag, defaultValue);
    }

    @Override
    protected String doParse(final String value) {
        return value;
    }
}
